package validator;

import component.DashboardComponent;
import dashboard.Dashboard;

import java.util.List;

public class ValidatorElementsCount implements Validator {

    @Override
    public String check(Dashboard dashboard, List<DashboardComponent> components) {

        if (components.size() == 0)
            return "count = 0";
        else
            return "ok";
    }
}
