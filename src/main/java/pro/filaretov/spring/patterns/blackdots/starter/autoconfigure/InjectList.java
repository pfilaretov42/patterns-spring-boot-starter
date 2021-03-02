package pro.filaretov.spring.patterns.blackdots.starter.autoconfigure;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Inject a custom list of beans.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectList {
    Class[] value();
}
