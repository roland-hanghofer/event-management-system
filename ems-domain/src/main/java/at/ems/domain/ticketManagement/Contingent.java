package at.ems.domain.ticketManagement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Contingent implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Tournament tournament;

    @Id
    @ManyToOne
    @JoinColumn
    @NonNull
    private Sponsor sponsor;

    @NonNull
    private int amountDaysaverTickets;

    @NonNull
    private int amountGoldenVipTickets;

    @NonNull
    private int amountPlayersPartyTickets;

    @NonNull
    private int amountBoxTickets;

    @NonNull
    private int amountParkTickets;
}
