package dashboard;

import component.*;

public interface Dashboard extends Cloneable {

    void redirect(String dashboardUrl);

    void search(String search);

    void start();

    void stop();

    void addComponent(DashboardComponent component);

    void removeComponent(DashboardComponent component);

}