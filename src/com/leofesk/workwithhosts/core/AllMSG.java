package com.leofesk.workwithhosts.core;

import com.leofesk.workwithhosts.gui.AboutWindow;
import com.leofesk.workwithhosts.gui.MainWindow;

public class AllMSG {

    // Constants Titles;
    public static final String TITLE_APP = "Work With Hosts";
    public static final String TITLE_VERSION = "1.0.0";

    public static final String TITLE_INFO = "Info: ";
    public static final String TITLE_ERROR = "Error: ";

    // Show all messages to GUI;

    public static void showMSG_MainWindow(String msg) {

        MainWindow.changeColorFont("green");
        MainWindow.setLabelMSG(TITLE_INFO + msg);

    }

    // Show all errors to GUI;

    public static void showError_MainWindow(String msg) {

        MainWindow.changeColorFont("red");
        MainWindow.setLabelMSG(TITLE_ERROR + msg);

    }

    public static void showError_About(String msg) {

        AboutWindow.setTextAreaAbout(TITLE_ERROR + msg);

    }

}
