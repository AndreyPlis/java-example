package validator;

import component.DashboardComponent;

import java.util.List;

public class ElementsCountValidator implements Validator {

    private List<DashboardComponent> components;

    public void setComponents(List<DashboardComponent> components) {
        this.components = components;
    }

    @Override
    public void validate() throws DashboardValidationException {
        if (components == null || components.isEmpty())
            throw new DashboardValidationException();
    }
}
