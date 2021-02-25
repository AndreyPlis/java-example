package dashboard;

import component.*;
import validator.*;

import java.io.*;
import java.util.*;

public class DashboardBuilder {

    private String name;

    private boolean editable = false;

    private List<DashboardComponent> components = new ArrayList<>();

    private List<Validator> validators = new ArrayList<>();


    public DashboardBuilder name(String name) {
        this.name = name;
        return this;
    }

    public DashboardBuilder editable() {
        editable = true;
        return this;
    }


    public DashboardBuilder runnable() {
        editable = false;
        return this;
    }

    public DashboardBuilder addLabel(int x, int y, int width, int height) {
        components.add(ComponentsFactory.create(ComponentsFactory.Type.LABEL, x, y));
        return this;
    }

    public DashboardBuilder addImage(int x, int y, int width, int height) {
        components.add(ComponentsFactory.create(ComponentsFactory.Type.IMAGE, x, y));
        return this;
    }

    public DashboardBuilder addValidator(Validator validator) {
        validators.add(validator);
        return this;
    }


    public Dashboard build() {
        AbstractDashboard dash = null;
        if (editable)
            dash = new EditableDashboard();
        else
            dash = new RunnableDashboard();

        dash.setName(name);
        for (DashboardComponent component : components)
            dash.addComponent(component);

        for (Validator validator : validators)
            dash.addValidator(validator);

        return dash;
    }

}
