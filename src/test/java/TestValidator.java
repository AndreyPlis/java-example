import dashboard.*;
import org.junit.jupiter.api.*;
import validator.*;

public class TestValidator {


    @Test
    public void validatorShouldThrowExceptionIfDashboardDoesNotHaveElements() {
        Assertions.assertThrows(DashboardValidationException.class, () -> {
            Dashboard dashboard = new DashboardBuilder().name("test")
                    .addValidator(new ElementsCountValidator())  // validate elements count
                    .build();

            dashboard.validate();
        });
    }

    @Test
    public void validatorShouldThrowExceptionIfDashboardDoesNotHaveName() {
        Assertions.assertThrows(DashboardValidationException.class, () -> {
            Dashboard dashboard = new DashboardBuilder()
                    .addValidator(new DashboardNameValidator())  //validate dashboard name
                    .build();
            dashboard.validate();
        });
    }

    @Test
    public void validatorShouldThrowExceptionIfDashboardHasElementsWithCoordsBelowZero() {
        Assertions.assertThrows(DashboardValidationException.class, () -> {
            Dashboard dashboard = new DashboardBuilder().addImage(-1, -1, 1, 1)
                    .addValidator(new IntersectComponentsValidator())  //intersect components
                    .addValidator(new CoordsBelowZeroValidator())  //coords below zero
                    .build();
            dashboard.validate();
        });
    }

    @Test
    public void validatorShouldThrowExceptionIfDashboardHasElementsWhichIntersect() {
        Assertions.assertThrows(DashboardValidationException.class, () -> {
            Dashboard dashboard = new DashboardBuilder().addImage(1, 1, 5, 5).addLabel(3, 3, 6, 6)
                    .addValidator(new IntersectComponentsValidator())  //intersect components
                    .build();
            dashboard.validate();
        });
    }

    @Test
    public void validatorShouldPassWithoutExceptions() {
        Assertions.assertDoesNotThrow(() -> {
            Dashboard dashboard = new DashboardBuilder().name("test").addImage(1, 1, 2, 2).addLabel(10, 10, 6, 6)
                    .addValidator(new ElementsCountValidator())  //validate elements count
                    .addValidator(new DashboardNameValidator())  //validate dashboard name
                    .addValidator(new IntersectComponentsValidator())  //intersect components
                    .addValidator(new CoordsBelowZeroValidator())  //coords below zero
                    .build();
            dashboard.validate();
        });
    }
}
