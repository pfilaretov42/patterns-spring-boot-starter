package pro.filaretov.spring.patterns.blackdots.starter.condition;

import org.springframework.boot.autoconfigure.condition.AllNestedConditions;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

/**
 * {@link @ConditionalOnProperty} annotation is not {@link java.lang.annotation.Repeatable}, so this condition
 * fixes it - we can have several conditions based on properties applied.
 */
public class OnRegionCondition extends AllNestedConditions {

    public OnRegionCondition() {
        super(ConfigurationPhase.REGISTER_BEAN);
    }

    @ConditionalOnProperty("black.dots.region")
    static class R {

    }

    @ConditionalOnProperty("black.dots.region-enabled")
    static class S {

    }

}
