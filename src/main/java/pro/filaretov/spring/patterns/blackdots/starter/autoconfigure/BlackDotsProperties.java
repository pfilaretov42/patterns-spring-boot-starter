package pro.filaretov.spring.patterns.blackdots.starter.autoconfigure;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.validation.annotation.Validated;

/**
 *
 */
@Getter
@Setter
@ToString
@Validated
@ConfigurationProperties(prefix = "black.dots")
public class BlackDotsProperties {

    public static final String DEFAULT_OCTAVE = "first";

    /**
     * Which octave to play into.
     */
    @NotBlank
    @Size(min = 2, max = 20)
    private String octave = DEFAULT_OCTAVE;

    @Valid
    @NestedConfigurationProperty
    private Instrument instrument = new Instrument();

    @Getter
    @Setter
    @ToString
    public static class Instrument {

        /**
         * Which instrument type to play.
         */
        @NotBlank
        private String type = "Grand Piano";
    }
}


