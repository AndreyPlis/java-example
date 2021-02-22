package validator;

import component.DashboardComponent;

import java.util.List;

public class IntersectComponentsValidator implements Validator {

    private List<DashboardComponent> components;

    public void setComponents(List<DashboardComponent> components) {
        this.components = components;
    }

    @Override
    public void validate() throws DashboardValidationException {
        for (int i = 0; i < components.size(); i++)
            for (int j = i + 1; j < components.size(); j++) {
                if (components.get(i).getX() == components.get(j).getX() && components.get(i).getY() == components.get(j).getY())
                    throw new DashboardValidationException("Intersect components");
            }
    }
}
