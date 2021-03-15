package pro.filaretov.spring.patterns.blackdots.starter.autoconfigure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import pro.filaretov.spring.patterns.blackdots.starter.wrapper.BlackDotsListener;
import pro.filaretov.spring.patterns.blackdots.starter.wrapper.DealerControllerAdvice;

/**
 *
 */
//@Configuration
//@ConditionalOnClass(BlackDoter.class)
@ConditionalOnProperty(value = "black.dots.enabled", havingValue = "true", matchIfMissing = true)
@EnableConfigurationProperties(BlackDotsProperties.class)
@ComponentScan("pro.filaretov.spring.patterns.blackdots.starter")
@Import(LegacyBeanDefinitionRegistrar.class)
@EnableAspectJAutoProxy
@Slf4j
public class BlackDotsAutoConfiguration {

    public BlackDotsAutoConfiguration() {
        log.info("BlackDotsAutoConfiguration created");
    }

    /*@Autowired
    private BlackDotsProperties blackDotsProperties;

    @Bean
    @ConditionalOnMissingBean
    public BlackDoterConfig blackDoterConfig() {
        String octave = blackDotsProperties.getOctave();

        return new BlackDoterConfig(octave);
    }

    @Bean
    @ConditionalOnMissingBean
    public BlackDoter blackDoter(BlackDoterConfig blackDoterConfig) {
        return new BlackDoter(blackDoterConfig);
    }
*/

    @Bean
    public InjectListBeanPostProcessor injectListBeanPostProcessor() {
        return new InjectListBeanPostProcessor();
    }

    @Bean
    @ConditionalOnProperty("black.dots.pointcut-package")
    public CustomPointcut customPointcut() {
        return new CustomPointcut();
    }

    @Bean
    @ConditionalOnProperty("black.dots.pointcut-package")
    public ExceptionHandlerAspect exceptionHandlerAspect() {
        return new ExceptionHandlerAspect();
    }

    @Bean
    @ConditionalOnProperty("black.dots.pointcut-package")
    public DefaultPointcutAdvisor defaultPointcutAdvisor(CustomPointcut customPointcut,
        ExceptionHandlerAspect exceptionHandlerAspect) {
        return new DefaultPointcutAdvisor(customPointcut, exceptionHandlerAspect);
    }

    // TODO - for some reason DealerControllerAdvice is picked up as a @Component.
    //      Why? There is no component scan on its package, isn't there?
//    @Bean
//    public DealerControllerAdvice dealerControllerAdvice() {
//        return new DealerControllerAdvice();
//    }

    @Bean
    public BlackDotsListener blackDotsListener() {
        return new BlackDotsListener();
    }
}
