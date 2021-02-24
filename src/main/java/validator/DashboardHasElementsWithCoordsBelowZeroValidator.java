package validator;

import component.DashboardComponent;
import dashboard.AbstractDashboard;
import validator.exception.DashboardHasElementsWithCoordsBelowZeroExeption;
import validator.exception.DashboardValidationException;

import java.util.List;

public class DashboardHasElementsWithCoordsBelowZeroValidator implements Validator {
    @Override
    public void validate(AbstractDashboard dashboard) throws DashboardValidationException {

        List<DashboardComponent> componentsList = dashboard.getListComponents();

        for (int i = 0; i < componentsList.size(); i++) {
            DashboardComponent dashboardComponent1 = componentsList.get(i);

            if (dashboardComponent1.getX() < 0 || dashboardComponent1.getY() < 0)
                throw new DashboardHasElementsWithCoordsBelowZeroExeption("Элементы со значением меньше 0");
        }

    }
}
