package validator;

import dashboard.AbstractDashboard;

public class DashboardHasNameValidator implements Validator {
    private AbstractDashboard dashboard;

    public DashboardHasNameValidator() {
    }

    public DashboardHasNameValidator(AbstractDashboard dashboard) {
        this.dashboard = dashboard;
    }

    @Override
    public void setDashboard(AbstractDashboard dashboard) {
        this.dashboard = dashboard;
    }

    @Override
    public Boolean validate() {
        if (dashboard.getName() == null)
            return false;
        return !dashboard.getName().isEmpty();
    }
}
