package dashboard;

import component.Builder;
import component.DashboardComponent;

public class EditableDashboard extends AbstractDashboard {

    public EditableDashboard(Builder builder) {
    }

    @Override
    protected void render() {
        System.out.println("render editable");
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
    public void addComponent(DashboardComponent component) {
        super.addComponent(component);
        System.out.println("Добавлен новый объект");
    }

    @Override
    public void removeComponent(DashboardComponent component) {
        super.removeComponent(component);
    }

    @Override
    public int search(DashboardComponent component, String search) {
        return super.search(component, search);
    }

    @Override
    public void changeComponent(DashboardComponent component, DashboardComponent componentChange) {
        super.changeComponent(component, componentChange);
    }

    @Override
    public Object clone() {
        super.clone();
        return this;
    }
}
