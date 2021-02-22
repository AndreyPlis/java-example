package validator;

import dashboard.AbstractDashboard;

public class DashboardHasNoElementsWhichIntersectValidator implements Validator {
    private AbstractDashboard dashboard;

    public DashboardHasNoElementsWhichIntersectValidator() {
    }

    public DashboardHasNoElementsWhichIntersectValidator(AbstractDashboard dashboard) {
        this.dashboard = dashboard;
    }

    @Override
    public void setDashboard(AbstractDashboard dashboard) {
        this.dashboard = dashboard;
    }

    @Override
    public Boolean validate() {
        return !this.dashboard.isComponentsIntersect();
    }

}
