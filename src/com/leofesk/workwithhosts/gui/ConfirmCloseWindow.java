package com.leofesk.workwithhosts.gui;

import com.leofesk.workwithhosts.core.ConfigApp;
import com.leofesk.workwithhosts.core.SaveFile;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.WindowConstants;

import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Dimension;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmCloseWindow {

    // JFrame;
    private static JFrame frameConfirmClose;

    // JPanel;
    private static JPanel panelMain;

    // JLabel;
    private static JLabel labelMSG;

    // JButton;
    private static JButton buttonYes;
    private static JButton buttonNo;
    private static JButton buttonCancel;

    // Dimension;
    private static Dimension buttonSize = new Dimension(100, 25);

    // Font;
    private static Font fontText = new Font("Ariel", Font.BOLD, 15);

    // Color;
    private static Color colorPanelsBG = new Color(180, 180, 180);
    private static Color colorLabelsFG = new Color(0, 0, 0);
    private static Color colorButtonsBG = new Color(30, 30, 30);
    private static Color colorButtonsFG = new Color(185, 185, 185);

    // Creating confirm close window;
    public static void createConfirmCloseWindow() {

        // frameConfirmClose;
        frameConfirmClose = new JFrame("Confirm save file...");
        frameConfirmClose.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frameConfirmClose.setResizable(false);

        // panelMain;
        panelMain = new JPanel();
        panelMain.setLayout(new FlowLayout());
        panelMain.setBackground(colorPanelsBG);
        panelMain.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));

        // labelMSG;
        labelMSG = new JLabel("Save file before exit of application?");
        labelMSG.setFont(fontText);
        labelMSG.setForeground(colorLabelsFG);

        // buttonYes;
        buttonYes = new JButton("Yes");
        buttonYes.setPreferredSize(buttonSize);
        buttonYes.setFont(fontText);
        buttonYes.setFocusPainted(false);
        buttonYes.setBackground(colorButtonsBG);
        buttonYes.setForeground(colorButtonsFG);
        buttonYes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonYesAction();
            }
        });

        // buttonNo;
        buttonNo = new JButton("No");
        buttonNo.setPreferredSize(buttonSize);
        buttonNo.setFont(fontText);
        buttonNo.setFocusPainted(false);
        buttonNo.setBackground(colorButtonsBG);
        buttonNo.setForeground(colorButtonsFG);
        buttonNo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonNoAction();
            }
        });

        // buttonCancel;
        buttonCancel = new JButton("Cancel");
        buttonCancel.setPreferredSize(buttonSize);
        buttonCancel.setFont(fontText);
        buttonCancel.setFocusPainted(false);
        buttonCancel.setBackground(colorButtonsBG);
        buttonCancel.setForeground(colorButtonsFG);
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonCancelAction();
            }
        });

        // Add To JPanel;

        panelMain.add(labelMSG);
        panelMain.add(buttonYes);
        panelMain.add(buttonNo);
        panelMain.add(buttonCancel);

        // Add To JFrame;
        frameConfirmClose.add(panelMain);
        frameConfirmClose.setSize(350, 100);
        frameConfirmClose.setLocationRelativeTo(null);
        frameConfirmClose.setVisible(true);

    }

    // Button Actions;

    // Button Action: Yes;
    private static void buttonYesAction() {

        SaveFile.writeFile();
        ConfigApp.deleteTempConfigFile();
        System.exit(0);

    }

    // Button Action: No;
    private static void buttonNoAction() {

        ConfigApp.deleteTempConfigFile();
        System.exit(0);

    }

    // Button Action: Cancel;
    private static void buttonCancelAction() {

        frameConfirmClose.dispose();

    }

}
