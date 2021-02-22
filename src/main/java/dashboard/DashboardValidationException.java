package dashboard;

public class DashboardValidationException extends Exception {

    String name;

    public DashboardValidationException(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
