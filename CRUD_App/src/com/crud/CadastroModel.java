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
public class CadastroModel {
    
    public void cadastrarUsuario (Bean beanObj) {
        
        try {
            String query = "insert into users values(null,?,?,?,?,?)";
            
            PreparedStatement ps = (PreparedStatement) DB.connectionDb.prepareStatement(query);
            ps.setString(1, beanObj.getNome()); 
            ps.setString(2, beanObj.getCpf()); 
            ps.setString(3, beanObj.getTelefone()); 
            ps.setString(4, beanObj.getEmail()); 
            ps.setString(5, beanObj.getSenha()); 
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso! Agora faça o login.");
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, ""+e);   
        }
    }
    
}
