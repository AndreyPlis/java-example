package validator;

import dashboard.AbstractDashboard;

//@FunctionalInterface
public interface Validator {

    public void setDashboard(AbstractDashboard dashboard);

    public Boolean validate();

}
