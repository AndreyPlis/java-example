package dashboard;

import component.*;

public interface Dashboard extends Cloneable {

    void redirect(String dashboardUrl);

    void search(String search);

    void start();

    void stop();

    void addComponent(DashboardComponent component);

    void removeComponent(DashboardComponent component);

    int getElementX(int i);

    int getElementY(int i);

    int getElementSize(int i);

    int componentsSize();

    Dashboard clone();

    void sortComponents();
}