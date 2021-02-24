import component.*;
import dashboard.*;
import validator.*;
import validator.exception.DashboardValidationException;

public class Main {

    public static void main(String... args) {

        DashboardBuilder builder = new DashboardBuilder();

        Dashboard result = builder.name("dash").editable().build();

        DashboardComponent component1 = new LabelComponent(4, 4, 2, 2);
        DashboardComponent component2 = new LabelComponent(5, 5, 2, 2);
        DashboardComponent component3 = new LabelComponent(10, 10, 1, 1);

        result.addComponent(component1);
        result.addComponent(component2);
        result.addComponent(component3);

        Validator validator = new DashBoardCheckNameNotNullValidator();
        Validator validator1 = new DashboardHasElementsWhichIntersectValidator();
        Validator validator2 = new DashboardDoesNotHaveElementsValidator();
        Validator validator3 = new DashboardHasElementsWithCoordsBelowZeroValidator();

        result.addValidator(validator);
        result.addValidator(validator1);
        result.addValidator(validator2);
        result.addValidator(validator3);

        try {
            result.validate();
        } catch (DashboardValidationException e) {
            e.printStackTrace();
        }
    }
}

