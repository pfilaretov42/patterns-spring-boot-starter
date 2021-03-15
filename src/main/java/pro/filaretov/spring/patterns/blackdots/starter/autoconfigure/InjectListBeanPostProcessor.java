package pro.filaretov.spring.patterns.blackdots.starter.autoconfigure;

import java.beans.Introspector;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.SneakyThrows;
import org.reflections.ReflectionUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import pro.filaretov.spring.patterns.blackdots.starter.annotation.InjectList;


/**
 * {@link BeanPostProcessor} to make {@link InjectList} annotation work.
 */
public class InjectListBeanPostProcessor implements BeanPostProcessor {

    @Autowired
    private ApplicationContext context;

    @SneakyThrows
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // fields annotated with @InjectList
        Set<Field> fields = ReflectionUtils
            .getAllFields(bean.getClass(), field -> field.isAnnotationPresent(InjectList.class));

        for (Field field : fields) {
            // values provided via @InjectList
            Class[] classes = field.getAnnotation(InjectList.class).value();

            // we relay on a convention that a bean name is a decapitalised class name
            List<Object> beans = Arrays.stream(classes)
                // context.getBean(aClass) may not work if context holds a bean proxy
                // which is interface proxy, not inherited proxy. That's why lookup by bean ID is a better way.
                .map(aClass -> Introspector.decapitalize(aClass.getSimpleName()))
                .map(name -> context.getBean(name))
                .collect(Collectors.toList());

            // set field with beans of desired classes
            field.setAccessible(true);
            field.set(bean, beans);
        }

        return bean;
    }
}
