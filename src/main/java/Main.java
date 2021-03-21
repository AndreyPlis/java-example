import collection.MultiMapImpl;
import component.*;
import dashboard.*;
import validator.*;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String... args) {

        Dashboard dash = new RunnableDashboard();
        AbstractDashboard dash2 = new EditableDashboard();

        MultiMapImpl<Integer, DashboardComponent> components = new MultiMapImpl<Integer, DashboardComponent>();

        DashboardComponent component1 = new LabelComponent(1, 1);
        DashboardComponent component2 = new LabelComponent(2, 2);
        DashboardComponent component3 = new LabelComponent(1, 1);
        DashboardComponent component4 = new LabelComponent(4, 5);

        components.put(1, component1);
        components.put(1, component2);
        components.put(2, component3);
        components.put(3, component2);

        components.print();
        System.out.println("size = " + components.size());
        System.out.println("isEmpty = " + components.isEmpty());
        System.out.println("containsKey 1 = " + components.containsKey(1));
        System.out.println("containsValue (1,1) = " + components.containsValue(component1));
        System.out.println("get values for key = 1: " + components.get(1).toString());

        components.put(2, component4);
        components.print();

        Set<DashboardComponent> testSet = new HashSet<DashboardComponent>();
        testSet.add(component2);
        testSet.add(component3);
        components.put(2, testSet);
        components.print();

        System.out.println("remove");
        components.remove(1);
        components.remove(3);
        components.print();

        components.clear();
        components.print();
    }
}
