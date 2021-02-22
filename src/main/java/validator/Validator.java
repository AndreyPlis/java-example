package validator;

//@FunctionalInterface
public interface Validator {

    void validate() throws DashboardValidationException;
}
