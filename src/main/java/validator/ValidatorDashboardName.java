package validator;

import component.DashboardComponent;
import dashboard.Dashboard;

import java.util.List;

public class ValidatorDashboardName implements Validator {

    @Override
    public String check(Dashboard dashboard, List<DashboardComponent> components) {

        if (dashboard.getName() != null)
            return "ok";
        else return "invalid name";
    }
}
