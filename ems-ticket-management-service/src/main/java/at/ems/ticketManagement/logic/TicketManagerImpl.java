package at.ems.ticketManagement.logic;

import at.ems.data.ticketManagement.TicketRepository;
import at.ems.data.ticketManagement.TournamentDayRepository;
import at.ems.domain.ticketManagement.Ticket;
import at.ems.domain.ticketManagement.TournamentDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

@Component
public class TicketManagerImpl implements TicketManager {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TournamentDayRepository tournamentDayRepository;

    @Override
    public Ticket addTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public Collection<Ticket> getTicketsForDay(Long dayId) {
        Optional<TournamentDay> days = tournamentDayRepository.findById(dayId);
        if (!days.isPresent()) {
            return new HashSet<>();
        }
        return days.get().getTickets();
    }
}
