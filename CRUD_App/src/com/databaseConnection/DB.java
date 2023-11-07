/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.databaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author luiso
 */
public class DB {
    
    public static Connection connectionDb = null;
    
    public static void loadConnection() {
    
    String url = "jdbc:mysql://localhost:3306/crud_app";
    String root = "root";
    String pass = "";
    
    try {
        connectionDb = DriverManager.getConnection(url, root, pass);
        
        if (connectionDb != null) {
         JOptionPane.showMessageDialog(null, "Banco de dados conectado!");
        }
    
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao conectar banco de dados "+e);
    }
    
    }
}
