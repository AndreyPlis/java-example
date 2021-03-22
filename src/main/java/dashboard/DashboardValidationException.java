package dashboard;

public class DashboardValidationException extends Exception{

    public DashboardValidationException(String message) {
        super(message);
    }

    public DashboardValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
