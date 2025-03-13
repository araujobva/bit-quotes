/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.view;

import javax.swing.*;

/**
 *
 * @author bruno
 */

public class VJFrameBackUp {

    public void vJFrameBackUp() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            System.out.println("Faz o BackUp");
        } else {
            System.out.println("Operação de salvar cancelada");
        }
    }
}

