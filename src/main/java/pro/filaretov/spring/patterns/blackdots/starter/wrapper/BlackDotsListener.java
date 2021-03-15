package pro.filaretov.spring.patterns.blackdots.starter.wrapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * Listener for a context refreshed event, meaning that it will be triggered when the context is fully built and ready.
 */
@Slf4j
public class BlackDotsListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.info("Black dots are ready now");
    }
}
