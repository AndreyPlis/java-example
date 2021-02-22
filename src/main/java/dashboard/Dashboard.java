package dashboard;

import component.*;
import validator.Validator;

import java.util.ArrayList;
import java.util.List;


public interface Dashboard extends Cloneable {

    List<Validator> validators = new ArrayList<>();

    void redirect(String dashboardUrl);

    void search(String search);

    void start();

    void stop();

    void addComponent(DashboardComponent component);

    void removeComponent(DashboardComponent component);

    default void validate() throws DashboardValidationException {
        for (Validator validator : validators) {
            if (!validator.validate())
                throw new DashboardValidationException("");
        }
    }

    default void addValidator(Validator validator) {
        validator.setDashboard((AbstractDashboard) this);
        validators.add(validator);

    }

}

