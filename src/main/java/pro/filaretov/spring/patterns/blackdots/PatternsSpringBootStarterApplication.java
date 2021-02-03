package pro.filaretov.spring.patterns.blackdots;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * TODO - do we still need the main class even though this is a boot starter? But cannot build without the main class!
 */
@SpringBootApplication
public class PatternsSpringBootStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatternsSpringBootStarterApplication.class, args);
    }

}
