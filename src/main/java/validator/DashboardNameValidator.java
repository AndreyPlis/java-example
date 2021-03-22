package validator;

import dashboard.*;

public class DashboardNameValidator implements Validator {

    @Override
    public void validate(AbstractDashboard abstractDashboard) throws DashboardValidationException {
        if (abstractDashboard.getName() == null || abstractDashboard.getName().isEmpty()) {
            throw new DashboardValidationException("name is empty");
        }
    }
}
