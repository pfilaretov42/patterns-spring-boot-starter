package pro.filaretov.spring.patterns.blackdots.starter.autoconfigure;

import javax.swing.JOptionPane;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Condition to check whether we are in a specific region or not.
 */
public class OnRegionCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return JOptionPane.showConfirmDialog(null, "Is it RU region?") == 0;
    }
}
