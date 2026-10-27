package exercicios26102026parte0.oo.exercicio1;

import java.util.List;

public class AutomationService {
    public void execute(
            AutomationRule rule,
            List<SmartDevice> devices) {

        devices.forEach(rule::execute);
    }
}