package pro.filaretov.spring.patterns.blackdots.starter.autoconfigure;

import java.beans.Introspector;
import java.util.Set;
import javax.inject.Singleton;
import org.reflections.Reflections;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AutowireCandidateQualifier;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import pro.filaretov.spring.patterns.blackdots.starter.annotation.Legacy;

/**
 * Import registrar to register bean definitions for legacy components, which in turn will result in these components
 * being spring beans.
 */
public class LegacyBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        // find all legacy classes annotated with @Singleton...
        Reflections reflections = new Reflections("pro.filaretov.spring.patterns.blackdots.legacy");
        Set<Class<?>> beanClasses = reflections.getTypesAnnotatedWith(Singleton.class);

        // and register them as bean definitions with @Legacy annotation
        for (Class<?> beanClass : beanClasses) {
            GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
            beanDefinition.setBeanClass(beanClass);
            beanDefinition.setScope(BeanDefinition.SCOPE_SINGLETON);
            beanDefinition.addQualifier(new AutowireCandidateQualifier(Legacy.class));

            String beanName = Introspector.decapitalize(beanClass.getSimpleName());

            registry.registerBeanDefinition(beanName, beanDefinition);
        }
    }
}
