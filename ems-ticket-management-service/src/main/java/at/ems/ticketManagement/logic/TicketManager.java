package at.ems.ticketManagement.logic;

import at.ems.domain.ticketManagement.Ticket;

import java.util.Collection;

public interface TicketManager {
    Ticket addTicket(Ticket ticket);

    Collection<Ticket> getTicketsForDay(Long dayId);


}
