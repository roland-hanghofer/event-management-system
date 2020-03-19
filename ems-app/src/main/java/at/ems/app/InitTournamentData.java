package at.ems.app;

import at.ems.domain.ticketManagement.Tournament;
import at.ems.ticketManagement.logic.TournamentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collection;

@Component
public class InitTournamentData implements CommandLineRunner {
    @Autowired
    private TournamentManager tournamentManager;
    @Override
    public void run(String... args) throws Exception {
        Tournament tournament1 = new Tournament("Sommerturnier 2019",
                LocalDate.of(2019, 7, 3),
                LocalDate.of(2019, 7, 5));
        Tournament tournament2 = new Tournament("Winterturnier 2019",
                LocalDate.of(2019, 12, 11),
                LocalDate.of(2019, 12, 13));

        tournamentManager.addTournament(tournament1);

        tournamentManager.addTournament(tournament2);

        Collection<Tournament> tournaments = tournamentManager.getTournaments();
        int x = 1;
    }
}
