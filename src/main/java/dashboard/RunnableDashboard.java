package dashboard;

public class RunnableDashboard extends AbstractDashboard {
    @Override
    protected void render() {
        System.out.println("render runnable");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        RunnableDashboard dash = new RunnableDashboard();
        this.components.forEach(dash::addComponent);
        return dash;
    }
}
