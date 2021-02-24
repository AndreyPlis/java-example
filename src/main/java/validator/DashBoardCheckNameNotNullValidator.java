package validator;

import dashboard.AbstractDashboard;
import validator.exception.DashboardHasNoNameExeption;
import validator.exception.DashboardValidationException;

public class DashBoardCheckNameNotNullValidator implements Validator {
    @Override
    public void validate(AbstractDashboard dashboard) throws DashboardValidationException {

        if (dashboard.getName().equals(""))
            throw new DashboardHasNoNameExeption("Отсутствует название");
    }
}
