package pro.filaretov.spring.patterns.blackdots.starter.autoconfigure;

import java.lang.reflect.Method;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Custom pointcut that can specify if it matches or not dynamically, i.e. not as a string constant.
 */
public class CustomPointcut extends DynamicMethodMatcherPointcut {

    @Autowired
    private BlackDotsProperties blackDotsProperties;

    @Override
    public boolean matches(Method method, Class<?> aClass, Object... objects) {
        return true;
    }

    @Override
    public ClassFilter getClassFilter() {
        return clazz -> clazz.getPackage().getName().contains(blackDotsProperties.getPointcutPackage());
    }
}
