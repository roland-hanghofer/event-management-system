package at.ems.domain.ticketManagement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Ticket {
    public enum TicketType {
        GoldenVipTicket,
        DaysaverTicket,
        BoxTicket,
        PlayerspartyTicket,
        ParkTicket
    };

    @Id
    @GeneratedValue
    private long id;

    @NonNull
    private TicketType type;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private TournamentDay day;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private Sponsor sponsor;
}
