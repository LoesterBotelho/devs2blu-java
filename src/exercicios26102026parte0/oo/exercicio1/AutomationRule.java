package exercicios26102026parte0.oo.exercicio1;

import java.util.Objects;

public record AutomationRule(
		
        String name,
        DevicePredicate condition,
        DeviceAction action) {

    public AutomationRule {
        
    	if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Rule name is required");
        }
        
        Objects.requireNonNull(condition);
        Objects.requireNonNull(action);
        
    }

    public boolean appliesTo(SmartDevice device) {
        return condition.test(device);
    }

    public void execute(SmartDevice device) {
        if (appliesTo(device)) {
            action.execute(device);
        }
    }
    
}