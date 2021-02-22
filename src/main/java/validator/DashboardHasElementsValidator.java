package validator;

import dashboard.AbstractDashboard;

public class DashboardHasElementsValidator implements Validator {

    private AbstractDashboard dashboard;

    public DashboardHasElementsValidator() {
    }

    public DashboardHasElementsValidator(AbstractDashboard dashboard) {
        this.dashboard = dashboard;
    }

    public void setDashboard(AbstractDashboard dashboard) {
        this.dashboard = dashboard;
    }

    @Override
    public Boolean validate() {
        return !dashboard.isComponentListEmpty();
    }
}
