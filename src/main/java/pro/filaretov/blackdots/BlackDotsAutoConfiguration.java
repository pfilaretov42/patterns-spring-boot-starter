package pro.filaretov.blackdots;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 */
@Configuration
@ConditionalOnClass(BlackDoter.class)
@EnableConfigurationProperties(BlackDotsProperties.class)
public class BlackDotsAutoConfiguration {

    @Autowired
    private BlackDotsProperties blackDotsProperties;

    @Bean
    @ConditionalOnMissingBean
    public BlackDoterConfig blackDoterConfig() {
        String octave = blackDotsProperties.getOctave();

        return new BlackDoterConfig(octave != null ? octave : BlackDotsProperties.DEFAULT_OCTAVE);
    }

    @Bean
    @ConditionalOnMissingBean
    public BlackDoter blackDoter(BlackDoterConfig blackDoterConfig) {
        return new BlackDoter(blackDoterConfig);
    }

}
