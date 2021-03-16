package pro.filaretov.spring.patterns.blackdots.starter.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.springframework.context.annotation.Conditional;
import pro.filaretov.spring.patterns.blackdots.starter.autoconfigure.OnServiceManCondition;

/**
 * Conditional to check whether we want a service man to be set out or not.
 */
@Retention(RetentionPolicy.RUNTIME)
@Conditional(OnServiceManCondition.class)
public @interface ConditionalOnServiceMan {

}
