package pro.filaretov.spring.patterns.blackdots.starter.autoconfigure;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Annotation to mark beans created from the legacy framework.
 */
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface Legacy {

}
