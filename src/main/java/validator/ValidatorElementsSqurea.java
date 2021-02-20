package validator;

import component.DashboardComponent;
import dashboard.Dashboard;

import java.util.List;

public class ValidatorElementsSqurea implements Validator {

    @Override
    public String check(Dashboard dashboard, List<DashboardComponent> components) {

        for (DashboardComponent component : components) {
            if (component.getHeight() * component.getWidth() > 100)
                return "squrea > 100";
        }
        return "ok";
    }
}
