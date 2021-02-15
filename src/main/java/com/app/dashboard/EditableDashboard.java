package com.app.dashboard;

import com.app.component.AbstractComponent;

import java.util.ArrayList;
import java.util.List;

public class EditableDashboard  extends  AbstractDashboard{

    public static EditableDashboard create(List<AbstractComponent> components){
        EditableDashboard dash = new EditableDashboard();
        dash.setComponents(new ArrayList(components));

        return dash;
    }

    @Override
    protected void render() {
        System.out.println("render editable");
    }

    @Override
    public AbstractDashboard clone() throws CloneNotSupportedException {
        EditableDashboard dash = new EditableDashboard();
        dash.setComponents(new ArrayList(this.components));

        return dash;
    }

}
