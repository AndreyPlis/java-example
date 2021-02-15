package dashboard;

import component.*;

import java.util.*;

public abstract class AbstractDashboard extends Object implements Dashboard, Cloneable {

    private List<DashboardComponent> components = new ArrayList<>();


    private String name;


    private DashboardComponent dashboardComponent = new LabelComponent(1, 1);


    @Override
    public void redirect(String dashboardUrl) {

    }

    @Override
    public void search(String search) {

    }

    protected abstract void render();

    @Override
    public void start() {
        System.out.println("starting...");
        render();
    }

    @Override
    public void stop() {

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractDashboard that = (AbstractDashboard) o;
        return Objects.equals(components, that.components) && Objects.equals(dashboardComponent, that.dashboardComponent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(components, dashboardComponent);
    }

    @Override
    public AbstractDashboard clone() {
        AbstractDashboard clone = null;
        try {
            clone = (AbstractDashboard) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(e);
        }
        clone.dashboardComponent = new LabelComponent(0, 0);
        return clone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
