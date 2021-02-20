package validator;

import component.DashboardComponent;
import dashboard.Dashboard;

import java.util.List;

public class ValidatorCoordsBelowZero implements Validator {

    @Override
    public String check(Dashboard dashboard, List<DashboardComponent> components) {

        for (DashboardComponent component : components) {
            if (component.getX() < 0 || component.getY() < 0)
                return "coordinate < 0";
        }
        return "ok";
    }
}
