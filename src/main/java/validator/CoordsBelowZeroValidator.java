package validator;

import component.DashboardComponent;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class CoordsBelowZeroValidator implements Validator {

    private List<DashboardComponent> components;

    public void setComponents(List<DashboardComponent> components) {
        this.components = components;
    }

    @Override
    public void validate() throws DashboardValidationException {
        AtomicBoolean flag = new AtomicBoolean(false);
        components.forEach(dashboardComponent -> {
            if (dashboardComponent.getX() < 0 || dashboardComponent.getY() < 0)
                flag.set(true);
                //throw new DashboardValidationException(); почему я так не могу сделать?
        });
        if(flag.get())
            throw new DashboardValidationException("Coords below zero");
    }
}
