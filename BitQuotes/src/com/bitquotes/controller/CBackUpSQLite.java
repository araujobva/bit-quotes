/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.controller;

/**
 *
 * @author bruno
 */
public class CBackUpSQLite {

    private String databasePath = System.getProperty("user.dir") + "/bitQuoteDatabase.db"; // Caminho relativo do arquivo do database no projeto

    public boolean backUp(String backupFilePath) {
        // A variável backupFilePath que veio por parâmetro, é o caminho do diretório para salvar o backup
        String[] executeCmd = {"/bin/bash", "-c", "cp " + this.databasePath + " " + backupFilePath + ".db"};
        try {
            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();
            return processComplete == 0;
        } catch (Exception ex) {
            return false;
        }
    }
    
    public boolean restoreBackup(String backupFilePath) {
        String restorePath = System.getProperty("user.dir") + "/bitQuoteDatabase.db"; // Caminho relativo do arquivo do database no projeto
        String[] executeCmd = {"/bin/bash", "-c", "cp " + backupFilePath + " " + restorePath};
        try {
            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();
            if (processComplete == 0) {
                System.out.println("Backup restaurado com sucesso!");
                return true;
            } else {
                System.out.println("Falha ao restaurar o backup.");
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

}

