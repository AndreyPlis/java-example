package dashboard;

import component.*;
import validator.*;
import validator.Validator;

import javax.xml.bind.*;
import java.util.*;

public abstract class AbstractDashboard extends Object implements Dashboard, Cloneable {

    private String name;
    private List<DashboardComponent> components = new ArrayList<>();
    private DashboardComponent dashboardComponent = new LabelComponent(1, 1);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public Boolean isComponentListEmpty() {
        return this.components.isEmpty();
    }

    public Boolean isAnyComponentCoordsBelowZero() {
        for (DashboardComponent component : components) {
            if (component.isCoodsBelowZero())
                return true;
        }
        return false;
    }

    public Boolean isComponentsIntersect() {
        for (int i = 0; i < this.components.size(); i++)
            for (int j = 0; j < this.components.size(); j++)
                if (i != j && this.components.get(i).hasIntersects(this.components.get(j).getX(), this.components.get(j).getY()))
                    return true;
        return false;
    }
}
