package dashboard;

import component.*;

import java.util.*;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

import static java.util.Arrays.*;

public abstract class AbstractDashboard implements Dashboard {

    private List<DashboardComponent> components = new ArrayList<>();

    String dashboardUrl = "";


    @Override
    public void redirect(String dashboardUrl) {
        this.dashboardUrl = dashboardUrl;
    }

    @Override
    public int search(DashboardComponent component, String search) {
        component.getName().equals(search);
        return components.indexOf(component);
    }

    protected abstract void render();

    @Override
    public void start() {
        System.out.println("starting...");
        render();
    }

    @Override
    public void stop() {
        System.out.println("STOP");
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
    public void changeComponent(DashboardComponent component, DashboardComponent componentChange) {
        int index = components.indexOf(component);
        components.add(index, componentChange);
    }

    class SortedByName implements Comparator<DashboardComponent> {
        public int compare(DashboardComponent component1, DashboardComponent component2) {
            String str1 = component1.getName();
            String str2 = component2.getName();
            return str1.compareTo(str2);
        }

        @Override
        public Comparator<DashboardComponent> reversed() {
            return null;
        }
    }

    @Override
    public void sortComponent() {
        components.sort(new SortedByName());
        System.out.println("Сортировка по названию");
    }

    @Override
    public Object clone() {
        System.out.println("Создана копия DashDoard");
        List<DashboardComponent> componentsClone = new ArrayList<>();
        componentsClone.addAll(components);
        return componentsClone;
    }
}

