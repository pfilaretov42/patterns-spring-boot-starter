package pro.filaretov.spring.patterns.blackdots.starter.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.springframework.web.bind.annotation.RestController;

/**
 * {@link RestController} that wraps all the responses and adds dealer name.
 */
@RestController
@Retention(RetentionPolicy.RUNTIME)
public @interface DealerController {

}
