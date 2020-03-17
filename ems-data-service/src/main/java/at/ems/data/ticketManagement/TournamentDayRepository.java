package at.ems.data.ticketManagement;

import at.ems.domain.ticketManagement.TournamentDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentDayRepository extends JpaRepository<TournamentDay, Long> {


}
