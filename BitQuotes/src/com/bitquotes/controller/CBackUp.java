/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.controller;

import javax.swing.JOptionPane;

/**
 *
 * @author bruno
 */

public class CBackUp {
    
    private String user = "root";
    private String password = "852";
    private String database = "bit_quote_test";
    private String backupFilePath; //Define o caminho onde deseja salvar o backup.
    
    public boolean backUp(String backupFilePath) {
        this.backupFilePath = backupFilePath;
        String[] executeCmd = {"/bin/bash", "-c", "mysqldump -u " + user + " -p" + password + " " + database + " > " + this.backupFilePath +".sql"};
        try {
            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();
            if (processComplete == 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            return false;
        }
    }
    
}

