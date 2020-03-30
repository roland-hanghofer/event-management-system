package at.ems.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDate;

@SpringBootApplication
@ComponentScan("at.ems")
@EnableJpaRepositories(basePackages = {"at.ems.data"})
@EntityScan("at.ems.domain")
public class EmsApplication {

    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2016, 1, 1);
        LocalDate d1 = date.plusDays(100);
        LocalDate d2 = date.plusDays(300);
        SpringApplication.run(EmsApplication.class, args);
    }

}
