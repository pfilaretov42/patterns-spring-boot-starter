package pro.filaretov.spring.patterns.blackdots.starter.autoconfigure;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.context.properties.bind.validation.BindValidationException;
import org.springframework.boot.test.context.runner.WebApplicationContextRunner;
import pro.filaretov.spring.patterns.blackdots.starter.controller.BlackDotsController;

class BlackDotsAutoConfigurationIT {

    private WebApplicationContextRunner contextRunner;

    @BeforeEach
    void setUp() {
        contextRunner = new WebApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(BlackDotsAutoConfiguration.class));
    }

    @Test
    public void autoConfigurationStartedSuccessfully() {
        contextRunner.run(context -> assertThat(context).hasNotFailed()
            .hasSingleBean(BlackDotsController.class)
            .hasSingleBean(BlackDotsProperties.class)
            .getBean(BlackDotsProperties.class)
            .hasNoNullFieldsOrProperties()
        );
    }

    @Test
    void autoConfigurationFailedValidation() {
        contextRunner.withPropertyValues("black.dots.octave=1")
            .run(context -> assertThat(context).hasFailed().getFailure()
                .hasRootCauseInstanceOf(BindValidationException.class)
                .hasStackTraceContaining("'black.dots' on field 'octave'")
            );
    }
}