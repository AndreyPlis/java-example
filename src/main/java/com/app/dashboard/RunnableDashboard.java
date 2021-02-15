package com.app.dashboard;

import com.app.component.AbstractComponent;

import java.util.ArrayList;
import java.util.List;

public class RunnableDashboard extends AbstractDashboard {

    public static RunnableDashboard create(List<AbstractComponent> components) {
        RunnableDashboard dash = new RunnableDashboard();
        dash.setComponents(new ArrayList(components));

        return dash;
    }

    @Override
    protected void render() {
        System.out.println("render runnable");
    }

    @Override
    public RunnableDashboard clone() throws CloneNotSupportedException {
        RunnableDashboard dash = new RunnableDashboard();
        dash.setComponents(new ArrayList(this.components));

        return dash;
    }
}
