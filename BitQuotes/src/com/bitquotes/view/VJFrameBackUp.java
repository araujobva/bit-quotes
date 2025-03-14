/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.view;

import java.awt.Dimension;
import javax.swing.*;
import com.bitquotes.controller.CBackUp;

/**
 *
 * @author bruno
 */

public class VJFrameBackUp {

    public void vJFrameBackUp() {
        JFileChooser fileChooser = new JFileChooser();
        Dimension dimension = new Dimension(800, 600);
        fileChooser.setPreferredSize(dimension);
        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            String fileName = fileChooser.getSelectedFile().getAbsolutePath();
            CBackUp back = new CBackUp();
            back.backUp(fileName);
        } else {
            System.out.println("Operação de salvar cancelada");
        }
    }

}

