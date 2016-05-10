package com.leofesk.workwithhosts.core;

import com.leofesk.workwithhosts.gui.AboutWindow;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class LoadRes {

    private static String temp = null;

    // Loading resources to AboutWindow;
    public static void openAbout() {

        try {

            InputStream inputStream = LoadRes.class.getResourceAsStream("/help/about.txt");
            InputStreamReader inputReader = new InputStreamReader(inputStream);

            BufferedReader reader = new BufferedReader(inputReader);

            while ((temp = reader.readLine()) != null) {

                AboutWindow.setTextAreaAbout(temp);

            }

            reader.close();

        } catch (IOException ioe) {

            AllMSG.showError_About("Can't read about text!");

        }

    }

}
