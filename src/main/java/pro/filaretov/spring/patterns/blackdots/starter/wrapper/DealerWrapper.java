package pro.filaretov.spring.patterns.blackdots.starter.wrapper;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Wrapper object that adds dealer name to the response.
 */
@AllArgsConstructor
@Getter
public class DealerWrapper {

    private final Object data;
    private final String dealer;

}
