import dashboard.*;
import org.junit.jupiter.api.*;

public class TestValidator {


    @Test
    public void validatorShouldThrowExceptionIfDashboardDoesNotHaveElements() {
        Assertions.assertThrows(DashboardValidationException.class, () -> {
            Dashboard dashboard = new DashboardBuilder().name("test")
                    //.addValidator()  validate elements count
                    .build();

            dashboard.validate();
        });
    }

    @Test
    public void validatorShouldThrowExceptionIfDashboardDoesNotHaveName() {
        Assertions.assertThrows(DashboardValidationException.class, () -> {
            Dashboard dashboard = new DashboardBuilder()
                    //.addValidator()  validate dashboard name
                    .build();
            dashboard.validate();
        });
    }

    @Test
    public void validatorShouldThrowExceptionIfDashboardHasElementsWithCoordsBelowZero() {
        Assertions.assertThrows(DashboardValidationException.class, () -> {
            Dashboard dashboard = new DashboardBuilder().addImage(-1, -1, 1, 1)
                    //.addValidator()  intersect components
                    //.addValidator()  coords below zero
                    .build();
            dashboard.validate();
        });
    }

    @Test
    public void validatorShouldThrowExceptionIfDashboardHasElementsWhichIntersect() {
        Assertions.assertThrows(DashboardValidationException.class, () -> {
            Dashboard dashboard = new DashboardBuilder().addImage(1, 1, 5, 5).addLabel(3, 3, 6, 6)
                    //.addValidator()  intersect components
                    .build();
            dashboard.validate();
        });
    }

    @Test
    public void validatorShouldPassWithoutExceptions() {
        Assertions.assertDoesNotThrow(() -> {
            Dashboard dashboard = new DashboardBuilder().name("test").addImage(1, 1, 2, 2).addLabel(10, 10, 6, 6)
                    //.addValidator()  validate elements count
                    //.addValidator()  validate dashboard name
                    //.addValidator()  intersect components
                    //.addValidator()  coords below zero
                    .build();
            dashboard.validate();
        });
    }
}
