package dashboardFactory;

import dashboard.Dashboard;
import dashboard.EditableDashboard;
import dashboard.RunnableDashboard;

public class DashboardFactory {
    public static Dashboard createDashboard(DashboardType type) {
        switch (type) {
            case EDITABLE_DASHBOARD:
                return new EditableDashboard();
            case RUNNABLE_DASHBOARD:
                return new RunnableDashboard();
            default:
                throw new IllegalArgumentException();
        }
    }
}
