package pro.filaretov.spring.patterns.blackdots.starter.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.springframework.context.annotation.Conditional;
import pro.filaretov.spring.patterns.blackdots.starter.autoconfigure.OnRegionCondition;

/**
 * Conditional to check whether we are in a specific region or not.
 */
@Retention(RetentionPolicy.RUNTIME)
@Conditional(OnRegionCondition.class)
public @interface ConditionalOnRegion {

}
