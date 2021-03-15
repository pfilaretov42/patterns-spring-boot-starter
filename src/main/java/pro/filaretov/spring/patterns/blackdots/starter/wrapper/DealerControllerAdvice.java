package pro.filaretov.spring.patterns.blackdots.starter.wrapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import pro.filaretov.spring.patterns.blackdots.starter.annotation.DealerController;
import pro.filaretov.spring.patterns.blackdots.starter.autoconfigure.BlackDotsProperties;

/**
 * Controller advice that is applied for {@link DealerController} annotation and wraps response body.
 */
@ControllerAdvice(annotations = DealerController.class)
@Slf4j
public class DealerControllerAdvice implements ResponseBodyAdvice {

    @Autowired
    private BlackDotsProperties properties;

    public DealerControllerAdvice() {
        log.info("DealerControllerAdvice created");
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class aClass,
        ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        return new DealerWrapper(body, properties.getDealerName());
    }
}
