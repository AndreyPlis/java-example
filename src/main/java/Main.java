import component.*;
import dashboard.*;

import java.util.*;

public class Main {

    public static void main(String... args) {

        Dashboard dash = new RunnableDashboard();

        AbstractDashboard dash2 = new EditableDashboard();

        dash2.clone();

        dash.start();

        dash2.start();

        dash2.stop();


        List<DashboardComponent> components = new ArrayList<>();


        DashboardComponent component1 = new LabelComponent(1,1);
        DashboardComponent component2 = new LabelComponent(2,2);
        DashboardComponent component3 = new LabelComponent(1,1);


        components.add(component1);
        components.add(component2);
        //components.add(component3);


        DashboardBuilder builder = new DashboardBuilder();

        Dashboard result = builder.name("dash").editable().build();


        System.out.println(components.indexOf(component3));

    }
}
