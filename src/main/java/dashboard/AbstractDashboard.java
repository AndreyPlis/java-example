package dashboard;

import component.*;

import java.util.*;

public abstract class AbstractDashboard implements Dashboard {

    private List<DashboardComponent> components = new ArrayList<>();


    @Override
    public void redirect(String dashboardUrl) {
        System.out.println("redirect..." + dashboardUrl);
    }

    @Override
    public void search(String search) {
        System.out.println("search..." + search);
    }

    protected abstract void render();

    public int componentsSize() {
        return components.size();
    }

    public ArrayList<DashboardComponent> getComponents() {
        return (ArrayList<DashboardComponent>) components;
    }

    @Override
    public void start() {
        System.out.println("starting...");
        render();
    }

    @Override
    public void stop() {
        System.out.println("stop...");
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
    public abstract Dashboard clone();

    public void sortComponents() {
        Collections.sort(components);
    }

    @Override
    public int getElementX(int i) {
        return components.get(i).getX();
    }

    @Override
    public int getElementY(int i) {
        return components.get(i).getY();
    }

    @Override
    public int getElementSize(int i) {
        return components.get(i).getSize();
    }
}
