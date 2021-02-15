package com.app.dashboard;

import com.app.Main;
import com.app.component.*;

import java.util.*;

public abstract class AbstractDashboard implements Dashboard {

    protected List<AbstractComponent> components = new ArrayList<>();

    public void setComponents(List<AbstractComponent> components) {
        this.components = components;
    }

    @Override
    public void redirect(String dashboardUrl) {
        Main.currentURL = dashboardUrl;
    }

    @Override
    public void search(String search) {
        System.out.println("search results:");
        for (AbstractComponent component : components)
            if (component.getText().contains(search))
                System.out.println(search);
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
    public void addComponent(AbstractComponent component) {
        components.add(component);
    }

    @Override
    public void removeComponent(AbstractComponent component) {
        components.remove(component);
    }

    @Override
    public void sort() {
        Collections.sort(components);
    }

}
