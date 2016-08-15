package pl.opackisebastian.webui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by seb on 17.07.16.
 */
@SpringBootApplication
@ComponentScan("pl.opackisebastian.*")
public class ChessOnlineWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChessOnlineWebApplication.class);
    }
}
