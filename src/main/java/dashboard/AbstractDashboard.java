package dashboard;

import component.*;

import java.util.*;

public abstract class AbstractDashboard implements Dashboard {

    private List<DashboardComponent> components = new ArrayList<>();


    @Override
    public void redirect(String dashboardUrl) {
        System.out.println("redirect to " + dashboardUrl);
    }

    @Override
    public void search(String search) {
        System.out.println("searching " + search);
    }

    protected abstract void render();

    @Override
    public void start() {
        System.out.println("starting...");
        render();
    }

    @Override
    public void stop() {
        System.out.println("stopping");
    }

    @Override
    public void addComponent(DashboardComponent component) {
        components.add(component);
    }

    @Override
    public void removeComponent(DashboardComponent component) {
        components.remove(component);
    }

    @Override
    public void sort() {
        Collections.sort(components);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractDashboard)) return false;
        AbstractDashboard that = (AbstractDashboard) o;
        return components.equals(that.components);
    }

    @Override
    public int hashCode() {
        return Objects.hash(components);
    }
}
