package validator;

import dashboard.AbstractDashboard;

public class DashboardHasNoElementsWithCoordsBelowZeroValidator implements Validator {
    private AbstractDashboard dashboard;

    public DashboardHasNoElementsWithCoordsBelowZeroValidator() {
    }

    public DashboardHasNoElementsWithCoordsBelowZeroValidator(AbstractDashboard dashboard) {
        this.dashboard = dashboard;
    }

    @Override
    public void setDashboard(AbstractDashboard dashboard) {
        this.dashboard = dashboard;
    }

    @Override
    public Boolean validate() {
        return !dashboard.isAnyComponentCoordsBelowZero();
    }
}
