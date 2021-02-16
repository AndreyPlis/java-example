package dashboard;

import component.*;
import validator.Validator;



public interface Dashboard extends Cloneable {

    void redirect(String dashboardUrl);

    void search(String search);

    void start();

    void stop();

    void addComponent(DashboardComponent component);

    void removeComponent(DashboardComponent component);

    void validate() throws DashboardValidationException;

    void addValidator(Validator validator);

}
