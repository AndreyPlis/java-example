package dashboard;

import validator.DashboardHasElementsValidator;

public class EditableDashboard extends AbstractDashboard {

    public EditableDashboard() {
        this.addValidator(new DashboardHasElementsValidator(this));
    }

    @Override
    protected void render() {
        System.out.println("render editable");
    }

}
