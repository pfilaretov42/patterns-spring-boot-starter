package pro.filaretov.spring.patterns.blackdots.starter.autoconfigure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pro.filaretov.spring.patterns.blackdots.starter.BlackDoter;
import pro.filaretov.spring.patterns.blackdots.starter.BlackDoterConfig;

/**
 *
 */
@Configuration
@ConditionalOnClass(BlackDoter.class)
@ConditionalOnProperty(value = "black.dots.enabled", havingValue = "true", matchIfMissing = true)
@EnableConfigurationProperties(BlackDotsProperties.class)
@ComponentScan("pro.filaretov.spring.patterns.blackdots.starter")
public class BlackDotsAutoConfiguration {

    @Autowired
    private BlackDotsProperties blackDotsProperties;

    @Bean
    @ConditionalOnMissingBean
    public BlackDoterConfig blackDoterConfig() {
        String octave = blackDotsProperties.getOctave();

        return new BlackDoterConfig(octave);
    }

    @Bean
    @ConditionalOnMissingBean
    public BlackDoter blackDoter(BlackDoterConfig blackDoterConfig) {
        return new BlackDoter(blackDoterConfig);
    }

}
