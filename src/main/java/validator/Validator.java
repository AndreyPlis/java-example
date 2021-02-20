package validator;

import dashboard.Dashboard;
import component.*;

import java.util.List;

@FunctionalInterface
public interface Validator {

    String check(Dashboard dashboard, List<DashboardComponent> components);
}
