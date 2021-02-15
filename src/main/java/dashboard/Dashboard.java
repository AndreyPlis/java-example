package dashboard;

import component.*;

public interface Dashboard extends Cloneable {

    void redirect(String dashboardUrl);

    int search(DashboardComponent component, String search);

    void start();

    void stop();

    void addComponent(DashboardComponent component);

    void removeComponent(DashboardComponent component);

    void changeComponent(DashboardComponent component, DashboardComponent componentChange);

    void sortComponent();

    Object clone();

}
