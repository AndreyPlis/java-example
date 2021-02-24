package validator;

public class DashboardNameValidator implements Validator {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void validate() throws DashboardValidationException {
        if (name == null || name.equals(""))
            throw new DashboardValidationException("Name is empty");
    }
}