package at.ems.app;

import at.ems.domain.ticketManagement.Ticket;
import at.ems.domain.ticketManagement.Tournament;
import at.ems.domain.ticketManagement.TournamentDay;
import at.ems.ticketManagement.logic.TicketManager;
import at.ems.ticketManagement.logic.TournamentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Collection;

@Component
public class InitTournamentData implements CommandLineRunner {
    @Autowired
    private TournamentManager tournamentManager;

    @Autowired
    private TicketManager ticketManager;

    @Override
    public void run(String... args) throws Exception {
        addTournaments();
    }

    @Transactional
    protected void addTournaments() {
        Tournament tournament1 = new Tournament("Sommerturnier 2019",
                LocalDate.of(2019, 7, 3),
                LocalDate.of(2019, 7, 5));
        Tournament tournament2 = new Tournament("Winterturnier 2019",
                LocalDate.of(2019, 12, 11),
                LocalDate.of(2019, 12, 13));

        tournamentManager.addTournament(tournament1);

        tournamentManager.addTournament(tournament2);

        Collection<Tournament> tournaments = tournamentManager.getTournaments();

        tournament1.getDays().forEach(d -> addTickets(d, 10 + ((Long)d.getId()).intValue(), 12, 23, 14));
        tournament2.getDays().forEach(d -> addTickets(d, 15 + ((Long)d.getId()).intValue(), 22, 23, 34));

        Collection<Tournament> ts = tournamentManager.getTournaments();
        ts.forEach(t -> {
            Collection<TournamentDay> days1 = tournamentManager.getTournamentDays(t.getId());
            int y = 1;
        });
        int x = 1;
    }

    private void addTickets(TournamentDay day, int goldenVipTickets, int daysaverTickets,
                            int playersPartyTickets, int boxTickets) {
        for (int i = 0; i < goldenVipTickets; i++) {
            addTicket(day, new Ticket(Ticket.TicketType.GoldenVipTicket));
        }
        for (int i = 0; i < daysaverTickets; i++) {
            addTicket(day, new Ticket(Ticket.TicketType.DaysaverTicket));
        }
        for (int i = 0; i < playersPartyTickets; i++) {
            addTicket(day, new Ticket(Ticket.TicketType.PlayerspartyTicket));
        }
        for (int i = 0; i < boxTickets; i++) {
            addTicket(day, new Ticket(Ticket.TicketType.BoxTicket));
        }
    }

    private void addTicket(TournamentDay day, Ticket ticket) {
        day.addTicket(ticket);
        ticketManager.addTicket(ticket);
    }
}
