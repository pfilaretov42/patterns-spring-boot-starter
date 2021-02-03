package pro.filaretov.spring.patterns.blackdots;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "black.dots")
public class BlackDotsProperties {

    public static final String DEFAULT_OCTAVE = "first";

    private String octave;

}


