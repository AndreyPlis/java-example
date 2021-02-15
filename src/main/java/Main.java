import component.Builder;
import component.ImageComponent;
import component.LabelComponent;
import dashboard.Dashboard;

public class Main {

    public static void main(String... args) {
        Builder builder = new Builder();

        Dashboard dashboard1 = builder.buildEditableDashboard();
        Dashboard dashboard2 = builder.buildRunnableDashboard();

        dashboard1.start();
        dashboard2.start();

        ImageComponent timetable = new ImageComponent(4, 10, "Расписание");
        LabelComponent timetableName = new LabelComponent(6, 11, "Расписание");
        dashboard1.addComponent(timetable);
        dashboard1.addComponent(timetableName);

        ImageComponent graph = new ImageComponent(4, 10, "График");
        LabelComponent graph1 = new LabelComponent(6, 11, "График №1");
        dashboard1.addComponent(graph);
        dashboard1.addComponent(graph1);

        dashboard1.clone();
        dashboard1.sortComponent();

        graph.equals(timetable);
    }
}
