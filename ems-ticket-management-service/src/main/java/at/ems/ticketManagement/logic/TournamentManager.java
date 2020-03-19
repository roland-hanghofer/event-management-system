package at.ems.ticketManagement.logic;

import at.ems.domain.ticketManagement.*;
import org.springframework.data.util.Pair;

import javax.persistence.Tuple;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;

public interface TournamentManager {
    Tournament addTournament(Tournament tournament);

    Collection<Tournament> getTournaments();

    Collection<TournamentDay> getTournamentDays(Long tournamentId);

    Map<TournamentDay, Collection<Pair<Ticket, Sponsor>>> getTournamentDaysAndTickets(Long tournamentId);
}
