package com.leofesk.workwithhosts.core;

import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

import java.util.Properties;

public class ConfigApp {

    public static String nameOS;

    private static Properties config = new Properties();
    private static OutputStream output = null;

    private static String filePath;

    // Creating temporary configuration file in system;
    public static void createConfig() {

        try {

            output = new FileOutputStream("config.properties");
            config.setProperty("filePathWindows", "C:\\Windows\\system32\\drivers\\etc\\hosts");
            config.setProperty("filePathLinux", "/etc/hosts");
            config.setProperty("currentOS", "Not identified!");

            config.store(output, null);

            AllMSG.showMSG_MainWindow("Config file successfully created!");

        } catch (IOException ioe) {

            AllMSG.showError_MainWindow(ioe.getMessage());

        } finally {

            if (output != null) {

                try {

                    output.close();

                } catch (IOException ioe) {

                    AllMSG.showError_MainWindow(ioe.getMessage());

                }

            }

        }

    }

    // After closing the application, this method removes configuration file;
    public static void deleteTempConfigFile() {

        File tempConfigFile  = new File("config.properties");
        tempConfigFile.delete();
        AllMSG.showMSG_MainWindow("Temporary config file successfully deleted!");

    }

    // Update parameter configuration file;
    public static void updateConfigProp(String configKey, String configValue) {

        try {

            output = new FileOutputStream("config.properties");

            config.setProperty(configKey, configValue);

            config.store(output, null);

        } catch (IOException ioe) {

            AllMSG.showError_MainWindow(ioe.getMessage());

        } finally {

            if (output != null) {

                try {

                    output.close();

                } catch (IOException ioe) {

                    AllMSG.showError_MainWindow(ioe.getMessage());

                }

            }

        }

    }

    // Identification of the current user's operating system;
    public static void identifyOS() {

        createConfig();

        if (isWindows()) {

            nameOS = "Windows";
            updateConfigProp("currentOS", nameOS);
            filePath = "" + ConfigApp.getConfigProp("filePathWindows");

        } else if (isUnix()) {

            nameOS = "Linux";
            updateConfigProp("currentOS", nameOS);
            filePath = "" + ConfigApp.getConfigProp("filePathLinux");

        }

        // In future add Mac OS;

    }


    // Check user operation system: Windows;
    private static boolean isWindows() {

        String os = System.getProperty("os.name").toLowerCase();

        return (os.indexOf( "win" ) >= 0);
    }

    // Check user operation system: Linux;
    private static boolean isUnix () {

        String os = System.getProperty("os.name").toLowerCase();
        return (os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0);

    }

    // Getters And Setters;

    public static String getConfigProp(String configKey) {

        return config.getProperty(configKey);

    }

    public static String getFilePath() {

        return filePath;

    }

    public static void setFilePath(String filePath) {

        ConfigApp.filePath = filePath;

    }

}
