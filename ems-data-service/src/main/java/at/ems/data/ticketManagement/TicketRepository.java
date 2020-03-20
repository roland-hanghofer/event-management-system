package at.ems.data.ticketManagement;

import at.ems.domain.ticketManagement.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
