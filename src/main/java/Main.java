import dashboard.*;

public class Main {

    public static void main(String... args) {

        Dashboard dash = new RunnableDashboard();

        AbstractDashboard dash2 = new EditableDashboard();

        dash.start();

        dash2.start();

        dash2.stop();/////////тест
    }
}
