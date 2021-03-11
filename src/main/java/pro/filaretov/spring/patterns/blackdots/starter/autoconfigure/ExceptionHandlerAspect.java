package pro.filaretov.spring.patterns.blackdots.starter.autoconfigure;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Method interceptor to add custom logic.
 */
@Slf4j
public class ExceptionHandlerAspect implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        try {
            return methodInvocation.proceed();
        } catch (ClassCastException e) {
            log.warn("Instruments are not castable!");
            throw e;
        }
    }
}
