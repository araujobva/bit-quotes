/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitquotes.controller;

import java.io.*;

/**
 *
 * @author bruno
 */
public class CBackUpSQLite {

    private String databasePath = System.getProperty("user.home") + "/Applications/Bit Quotes - BETA/bitQuoteDatabase.db";

    public boolean backUp(String backupFilePath) {
        String backupFile = backupFilePath + ".db";
        String command = "cp \"" + this.databasePath + "\" \"" + backupFile + "\"";

        try {
            System.out.println("Executando comando: " + command);

            ProcessBuilder processBuilder = new ProcessBuilder("/bin/bash", "-c", command);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();

            // Captura a saída do processo
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            int exitCode = process.waitFor();

            // Exibir saída do comando para debug
            System.out.println("Saída do comando:\n" + output);
            System.out.println("Código de saída: " + exitCode);

            if (exitCode == 0) {
                System.out.println("Backup criado com sucesso em: " + backupFile);
                return true;
            } else {
                System.out.println("Falha ao criar o backup. Código de saída: " + exitCode);
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean restoreBackup(String backupFilePath) {
        String restorePath = System.getProperty("user.home") + "/Applications/Bit Quotes - BETA/bitQuoteDatabase.db";
        String command = "cp \"" + backupFilePath + "\" \"" + restorePath + "\"";

        try {
            System.out.println("Executando comando: " + command);

            ProcessBuilder processBuilder = new ProcessBuilder("/bin/bash", "-c", command);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();

            // Captura a saída do processo
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            int exitCode = process.waitFor();

            // Exibir saída do comando para debug
            System.out.println("Saída do comando:\n" + output);
            System.out.println("Código de saída: " + exitCode);

            if (exitCode == 0) {
                System.out.println("Backup restaurado com sucesso em: " + restorePath);
                return true;
            } else {
                System.out.println("Falha ao restaurar o backup. Código de saída: " + exitCode);
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
