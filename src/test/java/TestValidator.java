import dashboard.*;
import org.junit.jupiter.api.*;
import validator.*;

public class TestValidator {


    @Test
    public void validatorShouldThrowExceptionIfDashboardDoesNotHaveElements() {
        Assertions.assertThrows(DashboardValidationException.class, () -> {
            Dashboard dashboard = new DashboardBuilder().name("test")
                    .addValidator(new ValidatorElementsCount())  //validate elements count
                    .build();
            dashboard.validate();
        });
    }

    @Test
    public void validatorShouldThrowExceptionIfDashboardDoesNotHaveName() {
        Assertions.assertThrows(DashboardValidationException.class, () -> {
            Dashboard dashboard = new DashboardBuilder()
                    .addValidator(new ValidatorDashboardName())  //validate dashboard name
                    .build();
            dashboard.validate();
        });
    }

    @Test
    public void validatorShouldThrowExceptionIfDashboardHasElementsWithCoordsBelowZero() {
        Assertions.assertThrows(DashboardValidationException.class, () -> {
            Dashboard dashboard = new DashboardBuilder().addImage(-1, -1, 1, 1)
                    .addValidator(new ValidatorCoordsBelowZero())   //coords below zero
                    .build();
            dashboard.validate();
        });
    }

    @Test
    public void validatorShouldThrowExceptionIfDashboardHasElementsWhichIntersect() {
        Assertions.assertThrows(DashboardValidationException.class, () -> {
            Dashboard dashboard = new DashboardBuilder().addImage(1, 1, 5, 5).addLabel(3, 3, 6, 6)
                    .addValidator(new ValidatorIntersectComponents())  //intersect components
                    .build();
            dashboard.validate();
        });
    }

    @Test
    public void validatorShouldThrowExceptionIfDashboardNameLength() {
        Assertions.assertThrows(DashboardValidationException.class, () -> {
            Dashboard dashboard = new DashboardBuilder().name("ab")
                    .addValidator(new ValidatorDashboardNameLength())   // validate name length ()
                    .build();
            dashboard.validate();
        });
    }

    @Test
    public void validatorShouldThrowExceptionIfDashboardElementsSqurea() {
        Assertions.assertThrows(DashboardValidationException.class, () -> {
            Dashboard dashboard = new DashboardBuilder().addImage(1, 1, 44, 33)
                    .addValidator(new ValidatorElementsSqurea())   // validate elements squrea
                    .build();
            dashboard.validate();
        });
    }

    @Test
    public void validatorShouldPassWithoutExceptions() {
        Assertions.assertDoesNotThrow(() -> {
            Dashboard dashboard = new DashboardBuilder().name("test").addImage(1, 1, 2, 2).addLabel(10, 10, 6, 6)
                    .addValidator(new ValidatorElementsCount()) // validate elements count
                    .addValidator(new ValidatorDashboardName()) // validate dashboard name
                    .addValidator(new ValidatorIntersectComponents()) // intersect components
                    .addValidator(new ValidatorCoordsBelowZero()) // coords below zero
                    .build();
            dashboard.validate();
        });
    }
}
