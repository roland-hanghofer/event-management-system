package at.ems.ticketManagement.service;


import at.ems.domain.ticketManagement.Sponsor;
import at.ems.domain.ticketManagement.Ticket;
import at.ems.domain.ticketManagement.Tournament;
import at.ems.domain.ticketManagement.TournamentDay;
import org.springframework.data.util.Pair;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;

@RequestMapping("/tournaments")
public interface TournamentController {

    @PostMapping("/add")
    ResponseEntity<?> addTournament(@RequestBody Tournament tournament);

    @GetMapping
    ResponseEntity<Collection<Tournament>> getTournaments();

    @GetMapping("/getDays/{id}")
    ResponseEntity<Collection<TournamentDay>> getTournamentDays(@PathVariable("id") Long tournamentId);

    @GetMapping("/days/{id}/tickets")
    ResponseEntity<Collection<Ticket>> getTicketForTournamentDay(@PathVariable("id") Long dayId);

    @GetMapping("/getDaysAndTickets/{id}")
    ResponseEntity<Map<TournamentDay, Collection<Pair<Ticket, Sponsor>>>> getTournamentDaysAndTickets(@PathVariable("id") Long tournamentId);
}
