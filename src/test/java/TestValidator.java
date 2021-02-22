import dashboard.*;
import org.junit.jupiter.api.*;
import validator.DashboardHasElementsValidator;
import validator.DashboardHasNameValidator;
import validator.DashboardHasNoElementsWhichIntersectValidator;
import validator.DashboardHasNoElementsWithCoordsBelowZeroValidator;

public class TestValidator {

    @Test
    public void validatorShouldThrowExceptionIfDashboardDoesNotHaveElementsEditable() {
        Assertions.assertThrows(DashboardValidationException.class, () -> {
            DashboardBuilder builder = new DashboardBuilder();
            Dashboard dashboard = builder.name("dash").editable().addValidator(new DashboardHasElementsValidator()).build();
            dashboard.validate();
        });
    }

    @Test
    public void validatorShouldThrowExceptionIfDashboardDoesNotHaveElementsRunnable() {
        Assertions.assertThrows(DashboardValidationException.class, () -> {
            DashboardBuilder builder = new DashboardBuilder();
            Dashboard dashboard = builder.name("dash").runnable().addValidator(new DashboardHasElementsValidator()).build();
            dashboard.validate();
        });
    }

    @Test
    public void validatorShouldThrowExceptionIfDashboardHaveNullNameRunnable() {
        Assertions.assertThrows(DashboardValidationException.class, () -> {
            DashboardBuilder builder = new DashboardBuilder();
            Dashboard dashboard = builder.runnable().addValidator(new DashboardHasNameValidator()).build();
            dashboard.validate();
        });
    }

    @Test
    public void validatorShouldThrowExceptionIfDashboardDoesNotHaveNameEditable() {
        Assertions.assertThrows(DashboardValidationException.class, () -> {
            DashboardBuilder builder = new DashboardBuilder();
            Dashboard dashboard = builder.name("").runnable().addValidator(new DashboardHasNameValidator()).build();
            dashboard.validate();
        });
    }

    @Test
    public void validatorShouldThrowExceptionIfDashboardHaveNullNameEditable() {
        Assertions.assertThrows(DashboardValidationException.class, () -> {
            DashboardBuilder builder = new DashboardBuilder();
            Dashboard dashboard = builder.runnable().addValidator(new DashboardHasNameValidator()).build();
            dashboard.validate();
        });
    }

    @Test
    public void validatorShouldThrowExceptionIfDashboardDoesNotHaveNameRunnable() {
        Assertions.assertThrows(DashboardValidationException.class, () -> {
            DashboardBuilder builder = new DashboardBuilder();
            Dashboard dashboard = builder.name("").runnable().addValidator(new DashboardHasNameValidator()).build();
            dashboard.validate();
        });
    }

    @Test
    public void validatorShouldThrowExceptionIfDashboardHasElementsWithCoordsBelowZero() {
        Assertions.assertThrows(DashboardValidationException.class, () -> {
            DashboardBuilder builder = new DashboardBuilder().addImage(-1, -1, 1, 1)
                    .addValidator(new DashboardHasNoElementsWithCoordsBelowZeroValidator());
            Dashboard dashboard = builder.build();
            dashboard.validate();
        });
    }
    
    @Test
    public void validatorShouldThrowExceptionIfDashboardHasElementsWhichIntersect() {
        Assertions.assertThrows(DashboardValidationException.class, () -> {
            Dashboard dashboard = new DashboardBuilder().addImage(1, 4, 5, 5).addLabel(3, 4, 6, 6)
                    .addValidator(new DashboardHasNoElementsWhichIntersectValidator())
                    .build();
            dashboard.validate();
        });
    }

    @Test
    public void validatorShouldPassWithoutExceptions() {
        Assertions.assertDoesNotThrow(() -> {
            Dashboard dashboard = new DashboardBuilder().name("test").addImage(1, 1, 2, 2).addLabel(10, 10, 6, 6)
                    .addValidator(new DashboardHasElementsValidator())
                    .addValidator(new DashboardHasNameValidator())
                    .addValidator(new DashboardHasNoElementsWhichIntersectValidator())
                    .addValidator(new DashboardHasNoElementsWithCoordsBelowZeroValidator())
                    .build();
            dashboard.validate();
        });
    }
}
