package com.app;

import com.app.dashboard.*;

import java.util.ArrayList;

public class Main {

    public static String currentURL;

    public static void main(String... args) {

        Dashboard dash = RunnableDashboard.create(new ArrayList<>());
        AbstractDashboard dash2 = EditableDashboard.create(new ArrayList<>());

        dash.start();
        dash2.start();
        dash2.stop();
    }
}
