package at.ems.domain.ticketManagement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Tournament {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, unique = true)
    @NonNull
    private String name;

    @NonNull
    private LocalDate startDate;

    @NonNull
    private LocalDate endDate;

    @OneToMany(mappedBy = "tournament", cascade = CascadeType.ALL, orphanRemoval = true)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<Contingent> contingents = new HashSet<>();

    @OneToMany(mappedBy = "tournament", cascade = CascadeType.ALL, orphanRemoval = true)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private List<TournamentDay> days = new ArrayList<>();

    // *****************************************************

    public void addDay(TournamentDay day) {
        if (days == null) {
            days = new ArrayList<>();
        }
        day.setTournament(this);
        days.add(day);
    }

    public void removeDay(TournamentDay day) {
        day.setTournament(null);
        days.remove(day);
    }

    public void addContingent(Contingent contingent) {
        if (contingents == null) {
            contingents = new HashSet<>();
        }
        contingent.setTournament(this);
        contingents.add(contingent);
    }

    public void removeContingent(Contingent contingent) {
        contingent.setTournament(null);
        contingents.remove(contingent);
    }

/*
    public void setSponsors(Set<Contingent> sponsors) {
        sponsors.forEach(s -> addSponsor(s));
    }

    public void setDays(Set<TournamentDay> days) {
        days.forEach(d -> addDay(d));
    }

    // default initialization, primarily used for testing
    public void initializeAvailableTicketsPerDay(int goldenVipTickets, int daysaverTickets,
                                                 int playersPartyTickets, int boxTickets, int parkTickets) {
        for (LocalDate date = LocalDate.from(startDate);
             date.isBefore(endDate) || date.isEqual(endDate);
             date = date.plusDays(1)) {
            TournamentDay day = new TournamentDay(date);
            for (int i = 0; i < goldenVipTickets; i++) {
                day.addTicket(new Ticket(Ticket.TicketType.GoldenVipTicket));
            }
            for (int i = 0; i < daysaverTickets; i++) {
                day.addTicket(new Ticket(Ticket.TicketType.DaysaverTicket));
            }
            for (int i = 0; i < playersPartyTickets; i++) {
                day.addTicket(new Ticket(Ticket.TicketType.PlayerspartyTicket));
            }
            for (int i = 0; i < boxTickets; i++) {
                day.addTicket(new Ticket(Ticket.TicketType.BoxTicket));
            }
            for (int i = 0; i < parkTickets; i++) {
                day.addTicket(new Ticket(Ticket.TicketType.ParkTicket));
            }
            addDay(day);
        }
    }*/
}
