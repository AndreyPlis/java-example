package dashboard;

public class RunnableDashboard extends AbstractDashboard {

    private boolean isRun = true;


    @Override
    protected void render() {
        System.out.println("render runnable");
    }


    @Override
    public RunnableDashboard clone() {
        RunnableDashboard dash = (RunnableDashboard) super.clone();
        dash.isRun = false;
        return dash;
    }
}
