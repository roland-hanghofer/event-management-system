package at.ems.data.ticketManagement;

import at.ems.domain.ticketManagement.Sponsor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SponsorRepository extends JpaRepository<Sponsor, Long> {
}
