package pro.filaretov.spring.patterns.blackdots.starter.autoconfigure;

import java.util.Date;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * Env Post Processor to resolve profile automatically.
 */
public class ProfileResolverEPP implements EnvironmentPostProcessor {

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        if (environment.getActiveProfiles().length == 0) {
            if (getYear() > 2000) {
                environment.setActiveProfiles("digital");
            } else {
                environment.setActiveProfiles("traditional");
            }
        }
    }

    private int getYear() {
        return 2021;
    }
}
