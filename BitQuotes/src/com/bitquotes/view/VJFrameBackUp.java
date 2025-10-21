/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.view;

import java.awt.Dimension;
import javax.swing.*;
import com.bitquotes.controller.CBackUpSQLite;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author bruno
 */

public class VJFrameBackUp {

    public void vJFrameBackUp() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos de Banco de Dados (*.db)", "db");
        // Define o filtro para permitir apenas arquivos com a extensão desejada (exemplo: ".db")
        fileChooser.setFileFilter(filter);
        Dimension dimension = new Dimension(800, 600);
        fileChooser.setPreferredSize(dimension);
        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            String backupFilePath = fileChooser.getSelectedFile().getAbsolutePath();
            CBackUpSQLite back = new CBackUpSQLite();
            boolean verification = back.backUp(backupFilePath);
            if (verification) {
                JOptionPane.showMessageDialog(null,"BackUp feito com sucesso!\nCaminhos do BackUp salvo: " + backupFilePath + ".db" , "SUCESSO!",JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao realizar o BackUp!\n", "ERRO!", JOptionPane.ERROR_MESSAGE);
            }        
        }
    }
    
    public void vJFrameRecoverBackUp() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos de Banco de Dados (*.db)", "db");
        // Define o filtro para mostrar apenas arquivos .db
        fileChooser.setFileFilter(filter);
        Dimension dimension = new Dimension(800, 600);
        fileChooser.setPreferredSize(dimension);
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            String backupFilePath = fileChooser.getSelectedFile().getAbsolutePath();
            CBackUpSQLite restore = new CBackUpSQLite();
            boolean verification = restore.restoreBackup(backupFilePath);
            if (verification) {
                JOptionPane.showMessageDialog(null, "Restauração do BackUp feita com sucesso!\nIMPORTANTE: Por causa da restauração do BackUp, o programa será fechado! ", "SUCESSO!", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao realizar a restauração!\n", "ERRO!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
}

