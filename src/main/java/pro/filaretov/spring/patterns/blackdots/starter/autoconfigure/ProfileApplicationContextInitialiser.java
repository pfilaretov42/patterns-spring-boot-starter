package pro.filaretov.spring.patterns.blackdots.starter.autoconfigure;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Context initialiser to check if a profile has been specified at the very early stage in the app startup.
 */
public class ProfileApplicationContextInitialiser implements ApplicationContextInitializer {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        if (applicationContext.getEnvironment().getActiveProfiles().length == 0) {
            throw new RuntimeException("No profiles have been specified!");
        }
    }
}
