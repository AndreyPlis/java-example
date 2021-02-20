package validator;

import component.DashboardComponent;
import dashboard.Dashboard;

import java.util.List;

public class ValidatorDashboardNameLength implements Validator {

    @Override
    public String check(Dashboard dashboard, List<DashboardComponent> components) {

        if (dashboard.getName() != null) {
            if (dashboard.getName().length() >= 3)
                return "ok";
            else return "length<3";
        } else return "length<3";
    }
}
