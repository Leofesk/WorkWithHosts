package com.leofesk.workwithhosts.gui;

import com.leofesk.workwithhosts.core.AllMSG;
import com.leofesk.workwithhosts.core.LoadRes;

import javax.swing.JFrame;
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

public class AboutWindow {

    // JFrame;
    private static JFrame frameAbout;

    // JPanel;
    private static JPanel panelMain;

    // JLabel;
    private static JLabel labelInfo;

    // JTextArea;
    private static JTextArea textAreaAbout;

    // JScrollPane;
    private static JScrollPane scrollPaneAbout;

    // Font;
    private static Font fontText = new Font("Monospaced", Font.BOLD, 16);
    private static Font fontTextAreaAbout = new Font("Monospaced", Font.BOLD, 16);

    // Color;
    private static Color colorPanelsBG = new Color(180, 180, 180);
    private static Color colorLabelsFG = new Color(126, 6, 0);
    private static Color colorTextAreaAboutBG = new Color(215, 215, 215);
    private static Color colorTextAreaAboutFG = new Color(0, 0, 0);

    // Border;
    private static Border borderLineTextAreaAbout = BorderFactory.createLineBorder(colorPanelsBG);

    // Creating about window;
    public static void createAboutWindow() {

        // frameConfirmClose;
        frameAbout = new JFrame("About");
        frameAbout.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frameAbout.setResizable(false);

        // panelMain;
        panelMain = new JPanel();
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
        panelMain.setBackground(colorPanelsBG);
        panelMain.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));

        // labelInfo;
        labelInfo = new JLabel(AllMSG.TITLE_APP + " (" + AllMSG.TITLE_VERSION + ")");
        labelInfo.setFont(fontText);
        labelInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelInfo.setForeground(colorLabelsFG);
        labelInfo.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));

        // textAreaAbout;
        textAreaAbout = new JTextArea();
        textAreaAbout.setLineWrap(true);
        textAreaAbout.setWrapStyleWord(true);
        textAreaAbout.setFont(fontTextAreaAbout);
        textAreaAbout.setBackground(colorPanelsBG);
        textAreaAbout.setEditable(false);
        textAreaAbout.setForeground(colorTextAreaAboutFG);

        // scrollPaneAbout;
        scrollPaneAbout = new JScrollPane(textAreaAbout);
        scrollPaneAbout.setBackground(colorTextAreaAboutBG);
        scrollPaneAbout.setBorder(borderLineTextAreaAbout);

        // Add To JPanel;
        panelMain.add(labelInfo);
        panelMain.add(scrollPaneAbout);

        // Add To JFrame;
        frameAbout.add(panelMain);
        frameAbout.setSize(600, 300);
        frameAbout.setLocationRelativeTo(null);
        frameAbout.setVisible(true);

        readAboutText();

    }

    // Add to GUI 'about.txt' text;
    private static void readAboutText() {

        LoadRes.openAbout();

    }

    // Update AboutWindow;
    public static void updateGUI() {

        textAreaAbout.setCaretPosition(0);

    }

    // Getters And Setters;

    public static void setTextAreaAbout(String msg) {

        textAreaAbout.append(msg + "\n");

    }

}
