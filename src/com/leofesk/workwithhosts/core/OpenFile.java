package com.leofesk.workwithhosts.core;

import com.leofesk.workwithhosts.gui.MainWindow;

import javax.swing.JFileChooser;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class OpenFile {

    private static String line = null;

    // Initialization method;
    public static void readFile() {

        openFile(ConfigApp.getFilePath());

    }

    // Change filepath in MainWindow, and updating configuration file;
    public static void getNewFilePath() {

        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int status = chooser.showOpenDialog(null);

        if (status == JFileChooser.APPROVE_OPTION) {

            File selectFile = chooser.getSelectedFile();
            String temp = selectFile.getName();

            if ((temp.equals("hosts")) || (temp.equals("hosts.txt"))) {

                ConfigApp.setFilePath(selectFile.getAbsolutePath());

                if (ConfigApp.nameOS.equals("Linux")) {

                    ConfigApp.updateConfigProp("filePathLinux", ConfigApp.getFilePath());

                } else if (ConfigApp.nameOS.equals("Windows")) {

                    ConfigApp.updateConfigProp("filePathWindows", ConfigApp.getFilePath());

                }

                AllMSG.showMSG_MainWindow("Changing file path successfully complete!");

                openFile(ConfigApp.getFilePath());

            } else {

                AllMSG.showError_MainWindow("You choose wrong file, need 'hosts'!");

            }

        } else if (status == JFileChooser.CANCEL_OPTION) {

            AllMSG.showError_MainWindow("You don't choose file, need 'hosts'!");

        }

    }

    // General method to open and read file;
    private static void openFile(String filePath) {

        try {

            FileReader fileReader = new FileReader(filePath);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {

                MainWindow.setTextAreaEditor(line);

            }

            bufferedReader.close();


        } catch (FileNotFoundException fnfe) {

            AllMSG.showError_MainWindow("Can't find file! Please click 'Open' and choosing the right file!");

        } catch (IOException ioe) {

            AllMSG.showError_MainWindow("Can't read file: " + filePath);

        }

    }

}
