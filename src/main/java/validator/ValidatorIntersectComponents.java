package validator;

import component.DashboardComponent;
import dashboard.Dashboard;

import java.util.List;

public class ValidatorIntersectComponents implements Validator {

    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private int a1;
    private int a2;
    private int b1;
    private int b2;

    @Override
    public String check(Dashboard dashboard, List<DashboardComponent> components) {

        for (int j = 0; j < components.size() - 1; j++) {
            for (int i = 0; i < components.size() - 1; i++) {

                x1 = components.get(j).getX();
                x2 = x1 + components.get(j).getWidth();
                y1 = components.get(j).getY();
                y2 = y1 + components.get(j).getHeight();

                a1 = components.get(i + 1).getX();
                a2 = a1 + components.get(i + 1).getWidth();
                b1 = components.get(i + 1).getY();
                b2 = b1 + components.get(i + 1).getHeight();

                if (((a1 <= x1) && (x1 <= a2) || (x1 <= a1) && (a1 <= x2)) && ((b1 <= y1) && (y1 <= b2) || (y1 <= b1) && (b1 <= y2)))
                    return "found intersect";
            }
        }
        return "ok";
    }
}
