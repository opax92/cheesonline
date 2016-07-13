package pl.opackisebastian.webui; /**
 * Created by seb on 15.06.16.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ComponentScan("pl.opackisebastian.*")
public class ChessOnlineWebApplication{
    public static void main(String[] args) {
        SpringApplication.run(ChessOnlineWebApplication.class, args);
    }
}