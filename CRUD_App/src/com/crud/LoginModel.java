/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crud;

import com.databaseConnection.DB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author luiso
 */
public class LoginModel {
    
    public boolean verificarLogin (String email, String senha) {
        boolean b = false;
        try {
            String query = "select email, senha from users where email ='"+email+"' AND senha ='"+senha+"'";
            
            Statement st = DB.connectionDb.createStatement();
            ResultSet result = st.executeQuery(query);
            
            if(result.next()){
                b = true;
                JOptionPane.showMessageDialog(null, "Bem vindo(a)!");
            } else {
                JOptionPane.showMessageDialog(null, "Email ou senha inválida. Tente novamente.");
            }
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, ""+e);   
        }    
        return b;
    }

    void cadastrarUsuario(Bean beanObj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
