package com.leofesk.workwithhosts;

import com.leofesk.workwithhosts.core.ConfigApp;
import com.leofesk.workwithhosts.core.OpenFile;
import com.leofesk.workwithhosts.gui.MainWindow;

public class StartClass {

    // Init application.
    public static void main(String[] args) {

        MainWindow.createMainWindow();

        ConfigApp.identifyOS();

        OpenFile.readFile();

        MainWindow.updateGUI();

    }

}