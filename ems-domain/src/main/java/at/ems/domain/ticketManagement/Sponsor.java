package at.ems.domain.ticketManagement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
//@RequiredArgsConstructor
public class Sponsor {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, unique = true)
    @NonNull
    private String company = "";

    @Column(nullable = false, unique = true)
    @NonNull
    private String contact = "";

    @OneToMany(mappedBy = "sponsor")
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private Set<Contingent> contingents = new HashSet<>();

    @OneToMany(mappedBy = "sponsor")
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private Set<Ticket> tickets;

    public Sponsor(@NonNull String company, @NonNull String contact) {
        this.company = company;
        this.contact = contact;
    }

    // *****************************************************

    public void addContingent(Contingent contingent) {
        if (contingents == null) {
            contingents = new HashSet<>();
        }
        contingent.setSponsor(this);
        contingents.add(contingent);
    }

    public void removeContingent(Contingent contingent) {
        contingent.setSponsor(null);
        contingents.remove(contingent);
    }

    public void addTicket(Ticket ticket) {
        if (tickets == null) {
            tickets = new HashSet<>();
        }
        ticket.setSponsor(this);
        tickets.add(ticket);
    }

    public void removeTicket(Ticket ticket) {
        ticket.setSponsor(null);
        tickets.remove(ticket);
    }
}
