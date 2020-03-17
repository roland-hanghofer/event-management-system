package at.ems.ticketManagement.logic;

import at.ems.data.ticketManagement.TournamentRepository;
import at.ems.domain.ticketManagement.Contingent;
import at.ems.domain.ticketManagement.Sponsor;
import at.ems.domain.ticketManagement.Tournament;
import at.ems.domain.ticketManagement.TournamentDay;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Collection;

public class TournamentManagerImpl implements TournamentManager {
    @Autowired
    private TournamentRepository tournamentRepository;

    @Override
    public void addTournament(Tournament tournament, LocalDate start, LocalDate end) {
        for (LocalDate day = start; day.isBefore(day); day.plusDays(1)) {
            tournament.addDay(new TournamentDay());
        }
    }

    @Override
    public Collection<Tournament> getTournaments() {
        return null;
    }

    @Override
    public Collection<TournamentDay> getTournamentDays(Tournament tournament) {
        return null;
    }

    @Override
    public void addSponsor(Sponsor sponsor) {

    }

    @Override
    public void addContingent(Contingent contingent) {

    }

    @Override
    public void addTicket(TournamentDay tournamentDay, Sponsor sponsor) {

    }
}
