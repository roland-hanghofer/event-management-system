package at.ems.ticketManagement.service;

import at.ems.core.rest.RestUtils;
import at.ems.domain.ticketManagement.Sponsor;
import at.ems.domain.ticketManagement.Ticket;
import at.ems.domain.ticketManagement.Tournament;
import at.ems.domain.ticketManagement.TournamentDay;
import at.ems.ticketManagement.logic.TicketManager;
import at.ems.ticketManagement.logic.TournamentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;

@RestController
public class TournamentControllerImpl implements TournamentController {
    @Autowired
    private TournamentManager tournamentManager;

    @Autowired
    private TicketManager ticketManager;

    @Override
    public ResponseEntity<?> addTournament(Tournament tournament) {
        return RestUtils.voidRequest((t) -> tournamentManager.addTournament(t), tournament);
    }

    @Override
    public ResponseEntity<Collection<Tournament>> getTournaments() {
        return RestUtils.request(() -> tournamentManager.getTournaments());
    }

    @Override
    public ResponseEntity<Collection<TournamentDay>> getTournamentDays(Long tournamentId) {
        return RestUtils.request((id) -> tournamentManager.getTournamentDays(id), tournamentId);
    }

    @Override
    public ResponseEntity<Collection<Ticket>> getTicketForTournamentDay(Long dayId) {
        return RestUtils.request((id) -> ticketManager.getTicketsForDay(id), dayId);
    }

    @Override
    public ResponseEntity<Map<TournamentDay, Collection<Pair<Ticket, Sponsor>>>> getTournamentDaysAndTickets(Long tournamentId) {
        return RestUtils.request((id) -> tournamentManager.getTournamentDaysAndTickets(id), tournamentId);
    }
}
