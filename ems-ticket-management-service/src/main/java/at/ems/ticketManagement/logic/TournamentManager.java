package at.ems.ticketManagement.logic;

import at.ems.domain.ticketManagement.Contingent;
import at.ems.domain.ticketManagement.Sponsor;
import at.ems.domain.ticketManagement.Tournament;
import at.ems.domain.ticketManagement.TournamentDay;

import java.time.LocalDate;
import java.util.Collection;

public interface TournamentManager {
    void addTournament(Tournament tournament, LocalDate start, LocalDate end);

    Collection<Tournament> getTournaments();

    Collection<TournamentDay> getTournamentDays(Tournament tournament);

    void addSponsor(Sponsor sponsor);

    void addContingent(Contingent contingent);

    void addTicket(TournamentDay tournamentDay, Sponsor sponsor);
}
