package com.leofesk.workwithhosts.core;

import com.leofesk.workwithhosts.gui.MainWindow;

import java.io.FileWriter;
import java.io.IOException;

public class SaveFile {

    // Basic method to saving file;
    public static void writeFile() {

        try {

            FileWriter fw = new FileWriter(ConfigApp.getFilePath());
            fw.write(MainWindow.getTextAreaEditor());
            fw.close();

            AllMSG.showMSG_MainWindow("Success write file!");

        } catch (IOException ioe) {

            AllMSG.showError_MainWindow("Error save file!");

        }

    }

}
