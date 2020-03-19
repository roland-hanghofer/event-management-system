package at.ems.domain.ticketManagement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
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
        PlayerspartyTicket//,
        //ParkTicket
    };

    public enum PaymentMethod {
        Invitation,
        Cash,
        ForAccount,
        Cooperation
    }

    @Id
    @GeneratedValue
    private long id;

    @NonNull
    private TicketType type;

    @NotNull
    private PaymentMethod paymentMethod;

    @NotNull
    private String invoiceAddress;




    private int category; //for daysaver tickets only

    private boolean catering;

    private boolean parking;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private TournamentDay day;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private Sponsor sponsor;
}
