package dashboard;

public class EditableDashboard extends AbstractDashboard {
    @Override
    protected void render() {
        System.out.println("render editable");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        EditableDashboard dash = new EditableDashboard();
        this.components.forEach(dash::addComponent);
        return dash;
    }
}
