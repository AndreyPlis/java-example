import component.*;
import dashboard.*;
import validator.ValidatorDashboardName;
import validator.ValidatorElementsCount;

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


        DashboardComponent component1 = new LabelComponent(1, 1, 3, 4);
        DashboardComponent component2 = new LabelComponent(2, 2, 5, 6);
        DashboardComponent component3 = new LabelComponent(1, 1, 7, 8);


        components.add(component1);
        components.add(component2);
        //components.add(component3);


        DashboardBuilder builder = new DashboardBuilder();

        //   Dashboard result = builder.name("dash").editable().build();

        //      Dashboard testtest = builder.name("").editable().build();
        Dashboard testtest = builder.editable().addImage(1, 2, 3, 4).build();
        testtest.addValidator(new ValidatorDashboardName());
        testtest.addValidator(new ValidatorElementsCount());

        try {
            testtest.validate();
        } catch (DashboardValidationException e) {
            e.printStackTrace();
        }

        System.out.println(components.indexOf(component3));

    }
}
