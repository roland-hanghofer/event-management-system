package at.ems.domain.ticketManagement;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class TournamentDay {

    @Id
    @GeneratedValue
    private long id;

    @NonNull
    private LocalDate date;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Tournament tournament;

    @OneToMany(mappedBy = "day", cascade = CascadeType.ALL, orphanRemoval = true)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<Ticket> tickets;

    // *****************************************************

    public void attachTournament(Tournament tournament) {
        tournament.removeDay(this);
        tournament.addDay(this);
    }

    public void detachTournament(Tournament tournament) {
        tournament.removeDay(this);
    }

    public void addTicket(Ticket ticket) {
        if (tickets == null) {
            tickets = new HashSet<>();
        }
        ticket.setDay(this);
        tickets.add(ticket);
    }

    public void removeTicket(Ticket ticket) {
        ticket.setDay(null);
        tickets.remove(ticket);
    }
}
