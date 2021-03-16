package pro.filaretov.spring.patterns.blackdots.starter.autoconfigure;

import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.JOptionPane;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Condition to check whether we want a service man to be set out or not.
 */
public class OnServiceManCondition implements Condition {

    private static final int DEFAULT_VALUE = Integer.MIN_VALUE;
    private static final AtomicInteger CACHED_RESULT = new AtomicInteger(DEFAULT_VALUE);

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        if (CACHED_RESULT.get() == DEFAULT_VALUE) {
            CACHED_RESULT.set(JOptionPane.showConfirmDialog(null, "Do you want a service man visit?"));
        }

        return CACHED_RESULT.get() == JOptionPane.YES_OPTION;
    }
}
