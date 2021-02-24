package validator;

import dashboard.AbstractDashboard;
import validator.exception.DashboardValidationException;

@FunctionalInterface
public interface Validator {
    void validate(AbstractDashboard dashboard) throws DashboardValidationException;

}
