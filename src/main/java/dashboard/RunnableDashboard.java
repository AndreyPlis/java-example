package dashboard;

import component.Builder;
import component.DashboardComponent;

public class RunnableDashboard extends AbstractDashboard {

    public RunnableDashboard(Builder builder) {
    }

    @Override
    protected void render() {
        System.out.println("render runnable");
    }

    @Override
    public void redirect(String dashboardUrl) {
        super.redirect(dashboardUrl);
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void stop() {
        super.stop();
    }

    @Override
    public int search(DashboardComponent component, String search) {
        return super.search(component, search);
    }

    @Override
    public Object clone() {
        super.clone();
        return this;
    }
}
