package validator;

import component.DashboardComponent;
import dashboard.AbstractDashboard;
import validator.exception.DashboardHasElementsWhichIntersectException;
import validator.exception.DashboardValidationException;

import java.util.List;

public class DashboardHasElementsWhichIntersectValidator implements Validator {

    @Override
    public void validate(AbstractDashboard dashboard) throws DashboardValidationException {

        List<DashboardComponent> componentsList = dashboard.getListComponents();

        for (int i = 0; i < componentsList.size(); i++) {
            for (int j = 0; j < componentsList.size(); j++) {
                DashboardComponent dashboardComponent1 = componentsList.get(i);
                DashboardComponent dashboardComponent2 = componentsList.get(j);

                int x1 = dashboardComponent1.getX();
                int y1 = dashboardComponent1.getY();
                int w1 = dashboardComponent1.getWidth();
                int h1 = dashboardComponent1.getHeight();

                int x2 = dashboardComponent2.getX();
                int y2 = dashboardComponent2.getY();
                int w2 = dashboardComponent2.getWidth();
                int h2 = dashboardComponent2.getHeight();

                if ((x1 <= x2 && x2 <= (x1 + w1)) && (y1 <= y2 && y2 <= (y1 + h1)))
                    throw new DashboardHasElementsWhichIntersectException("Элементы пересекаются");
                else if ((x2 < x1) && ((y2 + h2) > y1))
                    throw new DashboardHasElementsWhichIntersectException("Элементы пересекаются");
                else if ((y2 < y1) && ((x2 + w2) > x1))
                    throw new DashboardHasElementsWhichIntersectException("Элементы пересекаются");
                else if ((x2 < x1) && (y2 < h1) && ((y2 + h2) > y1) && ((x2 + w2) > x1))
                    throw new DashboardHasElementsWhichIntersectException("Элементы пересекаются");

            }
        }
    }
}
