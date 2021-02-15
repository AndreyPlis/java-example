package dashboard;

import component.*;

public class DashboardBuilder {

    private String name;

    private boolean editable = false;


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

    public DashboardBuilder addLabel(int x, int y) {
        ComponentsFactory.create(ComponentsFactory.Type.LABEL, x, y);
        return this;
    }


    public Dashboard build() {
        AbstractDashboard dash = null;
        if (editable)
            dash = new EditableDashboard();
        else
            dash = new RunnableDashboard();

        dash.setName(name);
        return dash;
    }

}
