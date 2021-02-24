package validator;

import component.DashboardComponent;
import dashboard.AbstractDashboard;
import validator.exception.DashboardDoesNotHaveElementsException;
import validator.exception.DashboardValidationException;

import java.util.List;

public class DashboardDoesNotHaveElementsValidator implements Validator {
    @Override
    public void validate(AbstractDashboard dashboard) throws DashboardValidationException {

        List<DashboardComponent> componentsList = dashboard.getListComponents();
        if (componentsList.size() == 0)
            throw new DashboardDoesNotHaveElementsException("Отсутствуют элементы");

    }
}
