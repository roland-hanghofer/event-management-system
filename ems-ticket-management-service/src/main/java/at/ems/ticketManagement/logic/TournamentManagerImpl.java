package at.ems.ticketManagement.logic;

import at.ems.data.ticketManagement.TournamentDayRepository;
import at.ems.data.ticketManagement.TournamentRepository;
import at.ems.domain.ticketManagement.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class TournamentManagerImpl implements TournamentManager {
    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private TournamentDayRepository tournamentDayRepository;

    @Override
    @Transactional
    public Tournament addTournament(Tournament tournament) {
        tournament = tournamentRepository.save(tournament);
        for (LocalDate day = tournament.getStartDate(); day.isBefore(tournament.getEndDate()) || day.isEqual(tournament.getEndDate()); day = day.plusDays(1)) {
            tournament.addDay(new TournamentDay(day));
        }
        tournament.getDays().forEach(d -> tournamentDayRepository.save(d));
        return tournament;
    }

    @Override
    public Collection<Tournament> getTournaments() {
        List<Tournament> tournaments = tournamentRepository.findAll();
        tournaments.sort((t1, t2) -> t1.getStartDate().compareTo(t2.getStartDate()));
        return tournaments;
    }

    @Override
    @Transactional
    public Collection<TournamentDay> getTournamentDays(Long tournamentId) {
        return getTournament(tournamentId).getDays();
    }

    @Override
    @Transactional
    public Map<TournamentDay, Collection<Pair<Ticket, Sponsor>>> getTournamentDaysAndTickets(Long tournamentId) {
        Map<TournamentDay, Collection<Pair<Ticket, Sponsor>>> map = new HashMap<>();
        getTournament(tournamentId).getDays().forEach(d -> {
            String s = d.toString();
            map.put(d, d.getTickets()
                    .stream()
                    .map(t -> Pair.of(t, t.getSponsor()))
                    .collect(Collectors.toList()));
        });
        return map;
    }

    // *************************************************************

    private  Tournament getTournament(Long id) {
        Optional<Tournament> tournament = tournamentRepository.findById(id);
        if (!tournament.isPresent()) {
            throw new IllegalArgumentException(String.format("Tournament with id %l does not exist", id));
        }
        return tournament.get();
    }
}
