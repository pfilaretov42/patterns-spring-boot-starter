package pro.filaretov.spring.patterns.blackdots.starter.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.springframework.context.annotation.Conditional;
import pro.filaretov.spring.patterns.blackdots.starter.condition.OnRegionCondition;

/**
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Conditional(OnRegionCondition.class)
public @interface ConditionalOnRegion {

}
