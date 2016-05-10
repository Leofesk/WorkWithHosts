package com.leofesk.workwithhosts.gui;

import com.leofesk.workwithhosts.core.*;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.WindowConstants;
import javax.swing.BoxLayout;
import javax.swing.border.Border;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainWindow {

    // JFrame;
    private static JFrame frameMain;

    // JMenu;
    private static JMenuBar menuBar;
    private static JMenu menuFile, menuHelp;
    private static JMenuItem menuItemOpen, menuItemSave, menuItemClose, menuItemAbout;

    // JPanel;
    private static JPanel panelMain;

    // JLabel;
    private static JLabel labelMSG;

    // JTextArea;
    private static JTextArea textAreaEditor;

    // JScrollPane;
    private static JScrollPane scrollPaneEditor;

    // Font;
    private static Font fontText = new Font("Ariel", Font.BOLD, 15);
    private static Font fontEditor = new Font("Ariel", Font.PLAIN, 15);

    // Color;
    private static Color colorPanelsBG = new Color(180, 180, 180);
    private static Color colorLabelsFG = new Color(0, 90, 190);
    private static Color colorEditorBG = new Color(215, 215, 215);
    private static Color colorLabelRED = new Color(181, 0, 16);
    private static Color colorLabelGREEN = new Color(42, 169, 6);

    // Border;
    private static Border borderLineEditor = BorderFactory.createLineBorder(Color.BLACK);
    private static Border borderLineMenuBar = BorderFactory.createLineBorder(colorPanelsBG);

    // Creating main window;
    public static void createMainWindow() {

        // frameMain;
        frameMain = new JFrame(AllMSG.TITLE_APP);
        frameMain.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frameMain.setResizable(false);

        // menuBar;
        menuBar = new JMenuBar();
        menuBar.setBorder(borderLineMenuBar);
        menuBar.setBackground(colorPanelsBG);

        // menuFile;
        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        // menuItems;
        menuItemOpen = new JMenuItem("Open");
        menuItemOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                menuItemOpenAction();
            }
        });

        menuItemSave = new JMenuItem("Save");
        menuItemSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                menuItemSaveAction();
            }
        });

        menuItemClose = new JMenuItem("Exit");
        menuItemClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                menuItemCloseAction();
            }
        });

        // menuAbout;
        menuHelp = new JMenu("Help");
        menuBar.add(menuHelp);

        // menuItems;
        menuItemAbout = new JMenuItem("About...");
        menuItemAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                menuItemAboutAction();
            }
        });

        // panelMain;
        panelMain = new JPanel();
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
        panelMain.setBackground(colorPanelsBG);
        panelMain.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));

        // labelMSG;
        labelMSG = new JLabel("Info: ");
        labelMSG.setFont(fontText);
        labelMSG.setForeground(colorLabelsFG);
        labelMSG.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelMSG.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));

        // textAreaEditor;
        textAreaEditor = new JTextArea();
        textAreaEditor.setRows(5);
        textAreaEditor.setColumns(10);
        textAreaEditor.setLineWrap(true);
        textAreaEditor.setWrapStyleWord(true);
        textAreaEditor.setFont(fontEditor);
        textAreaEditor.setBackground(colorEditorBG);

        // scrollPaneEditor;
        scrollPaneEditor = new JScrollPane(textAreaEditor);
        scrollPaneEditor.setBackground(colorEditorBG);
        scrollPaneEditor.setBorder(borderLineEditor);

        // All Add To JMenu;
        menuBar.add(menuFile);
        menuFile.add(menuItemOpen);
        menuFile.add(menuItemSave);
        menuFile.add(menuItemClose);

        menuBar.add(menuHelp);
        menuHelp.add(menuItemAbout);

        // Add To JPanel;
        panelMain.add(scrollPaneEditor);
        panelMain.add(labelMSG);

        // Add To JFrame;
        frameMain.setJMenuBar(menuBar);
        frameMain.add(panelMain);
        frameMain.setSize(640, 480);
        frameMain.setLocationRelativeTo(null);
        frameMain.setVisible(true);

        // Processing when the window is closed;
        frameMain.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                ConfirmCloseWindow.createConfirmCloseWindow();

            }
        });

    }

    // Menu Item Actions;

    // Item Action: Open;
    private static void menuItemOpenAction() {

        textAreaEditor.setText("");
        OpenFile.getNewFilePath();

    }

    // Item Action: Save;
    private static void menuItemSaveAction() {

        SaveFile.writeFile();

    }

    // Item Action: Close;
    private static void menuItemCloseAction() {

        ConfirmCloseWindow.createConfirmCloseWindow();

    }

    // Item Action: About;
    private static void menuItemAboutAction() {

        AboutWindow.createAboutWindow();
        AboutWindow.updateGUI();

    }

    // MSG: Change color;
    public static void changeColorFont(String color) {

        if (color.toLowerCase().equals("red")) {

            labelMSG.setForeground(colorLabelRED);

        }

        if (color.toLowerCase().equals("green")) {

            labelMSG.setForeground(colorLabelGREEN);

        }

    }

    // Update MainWindow;
    public static void updateGUI() {

        textAreaEditor.setCaretPosition(0);

    }

    // Getters And Setters;

    public static void setLabelMSG(String msg) {

        labelMSG.setText(msg);

    }

    public static void setTextAreaEditor(String text) {

        textAreaEditor.append(text + "\n");

    }

    public static String getTextAreaEditor() {

        return textAreaEditor.getText();

    }

}