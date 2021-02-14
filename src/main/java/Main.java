import component.ImageComponent;
import component.LabelComponent;
import dashboard.*;

public class Main {

    public static void main(String... args) {

        Dashboard dash = new RunnableDashboard();

        AbstractDashboard dash2 = new EditableDashboard();

        dash.start();

        dash2.start();

        dash2.stop();
        Dashboard dash3 = new RunnableDashboard();

        System.out.println(dash2.hashCode());
        System.out.println(dash.hashCode());
        System.out.println(dash3.equals(dash));


        ImageComponent img = new ImageComponent(5, 34, "imgtest", true, 4);
        LabelComponent lbl = new LabelComponent(12, 7, "lbltest", true, 2);

        LabelComponent lbl1 = new LabelComponent(12, 7, "lbltest1", true, 6);
        LabelComponent lbl2 = new LabelComponent(12, 7, "lbltest2", true, 1);


        System.out.println("compare - " + img.compareTo(lbl));

        dash2.addComponent(img);
        dash2.addComponent(lbl);
        dash2.addComponent(lbl1);
        dash2.addComponent(lbl2);

        dash2.sort();

        dash2.addComponent(img);

        EditableDashboard dash4 = new EditableDashboard.Builder().build();

        EditableDashboard dash5 = new EditableDashboard.Builder().idDashboard(45).name("name5").build();

        RunnableDashboard dash6 = new RunnableDashboard.Builder().name("name6").build();

        dash5.addComponent(img);
        dash5.addComponent(lbl);
        dash5.addComponent(lbl1);
        dash5.addComponent(lbl2);

        dash6.addComponent(img);
        dash6.addComponent(lbl);
        dash6.addComponent(lbl1);

        Dashboard dash7 = dash5.clone();
        Dashboard dash8 = dash6.clone();

    }
}
