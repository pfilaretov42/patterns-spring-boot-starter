package pro.filaretov.spring.patterns.blackdots.starter.autoconfigure;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

/**
 * Aspect to handle exception (it's not working as requires maven aspectj plugin etc.).
 * The problem is that pointcut can only contain constant expression and cannot be configured dynamically,
 * but the spring boot starter does not know about packages, classes and methods
 * it's going to be used for in main app(s).
 */
@Aspect
public class ExceptionHandlerAspect {

    @AfterThrowing(pointcut = "execution(* pro.filaretov..*.*(..))", throwing = "exception")
    public void handle(ClassCastException exception) {
        System.out.println("Something went wrong with instrument");
    }

}
