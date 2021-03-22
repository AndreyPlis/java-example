package validator;

import dashboard.*;

@FunctionalInterface
public interface Validator {

    void validate(AbstractDashboard abstractDashboard) throws DashboardValidationException;

}
