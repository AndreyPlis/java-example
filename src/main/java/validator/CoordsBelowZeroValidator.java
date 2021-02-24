package validator;

import component.DashboardComponent;

import java.util.List;

public class CoordsBelowZeroValidator implements Validator {

    private List<DashboardComponent> components;

    public void setComponents(List<DashboardComponent> components) {
        this.components = components;
    }

    @Override
    public void validate() throws DashboardValidationException {
        for (DashboardComponent component : components) {
            if (component.getX() < 0 || component.getY() < 0)
                throw new DashboardValidationException("Coords below zero");
        }
    }
}
