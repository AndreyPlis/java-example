package com.app.dashboard;

import com.app.component.*;

public interface Dashboard extends Cloneable {

    void redirect(String dashboardUrl);

    void search(String search);

    void start();

    void stop();

    void addComponent(AbstractComponent component);

    void removeComponent(AbstractComponent component);

    void sort();
}
