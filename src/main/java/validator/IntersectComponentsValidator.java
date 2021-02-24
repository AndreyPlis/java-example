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
                boolean flagX = intersect(components.get(i).getX(), components.get(j).getX(), components.get(i).getWidth(), components.get(j).getWidth());
                boolean flagY = intersect(components.get(i).getY(), components.get(j).getY(), components.get(i).getHeight(), components.get(j).getHeight());

                if (flagX && flagY)
                    throw new DashboardValidationException();
            }
    }

    private boolean intersect(int a, int b, int ac, int bc) {
        if (a < b)
            return a + ac > b;
        else
            return b + bc > a;
    }
}
