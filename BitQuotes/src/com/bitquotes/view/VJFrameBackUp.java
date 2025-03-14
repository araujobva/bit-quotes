/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.view;

import java.awt.Dimension;
import javax.swing.*;
import com.bitquotes.controller.CBackUp;
import javax.swing.JOptionPane;

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
            boolean verification = back.backUp(fileName);
            if (verification) {
                JOptionPane.showMessageDialog(null,"BackUp feito com sucesso!\nCaminhos do BackUp salvo: " + fileName + ".sql" , "SUCESSO!",JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao realizar o BackUp!\n", "ERRO!", JOptionPane.ERROR_MESSAGE);
            }        
        }
    }
    
    public void vJFrameRecoverBackUp() {
        JFileChooser fileChooser = new JFileChooser();
        Dimension dimension = new Dimension(800, 600);
        fileChooser.setPreferredSize(dimension);
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            String fileName = fileChooser.getSelectedFile().getAbsolutePath();
            CBackUp restore = new CBackUp();
            boolean verification = restore.restoreBackUp(fileName);
            if (verification) {
                JOptionPane.showMessageDialog(null,"BackUp feito com sucesso!\nCaminhos do BackUp salvo: " + fileName + ".sql" , "SUCESSO!",JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao realizar o BackUp!\n", "ERRO!", JOptionPane.ERROR_MESSAGE);
            }        
        }
    }  

}

