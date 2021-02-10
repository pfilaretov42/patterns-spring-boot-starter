package pro.filaretov.spring.patterns.blackdots.starter.autoconfigure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 */
@ComponentScan("pro.filaretov.spring.patterns.blackdots.starter")
@ConditionalOnProperty("black.dots.enabled")
@Slf4j
public class BlackDotsAutoConfiguration {

    public BlackDotsAutoConfiguration() {
        log.info("BlackDotsAutoConfiguration created");
    }
}