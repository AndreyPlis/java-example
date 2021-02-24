import dashboard.*;
import org.junit.jupiter.api.*;
import validator.DashBoardCheckNameNotNullValidator;
import validator.DashboardDoesNotHaveElementsValidator;
import validator.DashboardHasElementsWhichIntersectValidator;
import validator.DashboardHasElementsWithCoordsBelowZeroValidator;
import validator.exception.DashboardValidationException;

public class TestValidator {


    @Test
    public void validatorShouldThrowExceptionIfDashboardDoesNotHaveElements() {
        Assertions.assertThrows(DashboardValidationException.class, () -> {
            Dashboard dashboard = new DashboardBuilder().name("test")
                    .addValidator(new DashboardDoesNotHaveElementsValidator())
                    .build();

            dashboard.validate();

        });
    }

    @Test
    public void validatorShouldThrowExceptionIfDashboardDoesNotHaveName() {
        Assertions.assertThrows(DashboardValidationException.class, () -> {
            Dashboard dashboard = new DashboardBuilder().name("")
                    .addValidator(new DashBoardCheckNameNotNullValidator())
                    .build();
            dashboard.validate();

        });
    }

    @Test
    public void validatorShouldThrowExceptionIfDashboardHasElementsWithCoordsBelowZero() {
        Assertions.assertThrows(DashboardValidationException.class, () -> {
            Dashboard dashboard = new DashboardBuilder().addImage(-1, -1, 1, 1).addLabel(3, 3, 6, 6)
                    .addValidator(new DashboardHasElementsWhichIntersectValidator())
                    .addValidator(new DashboardHasElementsWithCoordsBelowZeroValidator())
                    .build();

            dashboard.validate();

        });
    }

    @Test
    public void validatorShouldThrowExceptionIfDashboardHasElementsWhichIntersect() {
        Assertions.assertThrows(DashboardValidationException.class, () -> {
            Dashboard dashboard = new DashboardBuilder().addImage(1, 1, 5, 5).addLabel(3, 3, 2, 2)
                    .addValidator(new DashboardHasElementsWhichIntersectValidator())
                    .build();

            dashboard.validate();

        });
    }

    @Test
    public void validatorShouldPassWithoutExceptions() {
        Assertions.assertDoesNotThrow(() -> {
            Dashboard dashboard = new DashboardBuilder().name("test1").addImage(1, 1, 2, 2).addLabel(10, 10, 6, 6)
                    .addValidator(new DashboardDoesNotHaveElementsValidator())
                    .addValidator(new DashBoardCheckNameNotNullValidator())
                    .addValidator(new DashboardHasElementsWhichIntersectValidator())
                    .addValidator(new DashboardHasElementsWithCoordsBelowZeroValidator())
                    .build();

            dashboard.validate();

        });
    }

    @Test
    public void validatorShouldThrowExceptionIfDashboardDoesNotHaveElementsOrName() {
        Assertions.assertThrows(DashboardValidationException.class, () -> {
            Dashboard dashboard = new DashboardBuilder().name("").addImage(1, 1, 3, 3).addLabel(7, 7, 2, 2)
                    .addValidator(new DashboardDoesNotHaveElementsValidator())
                    .addValidator(new DashBoardCheckNameNotNullValidator())
                    .build();

            dashboard.validate();

        });
    }
}
