/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crud;

import com.databaseConnection.DB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author luiso
 */
public class HomeModel {

    public List<Bean> loadData() {
        List<Bean> list = new ArrayList<Bean>();

        try {
            String query = "select * from users";
            PreparedStatement ps = (PreparedStatement) DB.connectionDb.prepareStatement(query);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                int id = result.getInt("Id");
                String nome = result.getString("nome");
                String cpf = result.getString("cpf");
                String telefone = result.getString("telefone");
                String email = result.getString("email");
                String senha = result.getString("senha");

                Bean bean = new Bean(id, nome, cpf, telefone, email, senha);
                list.add(bean);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "" + e);
        }

        return list;
    }
    

    public void cadastrarUsuario(Bean beanObj) {

        try {
            String query = "insert into users values(null,?,?,?,?,?)";

            PreparedStatement ps = (PreparedStatement) DB.connectionDb.prepareStatement(query);
            ps.setString(1, beanObj.getNome());
            ps.setString(2, beanObj.getCpf());
            ps.setString(3, beanObj.getTelefone());
            ps.setString(4, beanObj.getEmail());
            ps.setString(5, beanObj.getSenha());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "" + e);
        }
    }

    public Bean retornarDados(int id) {
        Bean bean = null;

        try {
            String query = "select * from users where id = '" + id + "'";

            PreparedStatement ps = (PreparedStatement) DB.connectionDb.prepareStatement(query);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                int ids = result.getInt("Id");
                String nome = result.getString("nome");
                String cpf = result.getString("cpf");
                String telefone = result.getString("telefone");
                String email = result.getString("email");
                String senha = result.getString("senha");
                bean = new Bean(ids, nome, cpf, telefone, email, senha);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "" + e);
        }

        return bean;
    }

    public void atualizarUsuario(Bean bean) {

        try {

            if (JOptionPane.showConfirmDialog(null, "Realmente gostaria de atualizar usuário?") == 0) {
                String query = "update users set nome = ?, cpf = ?, telefone = ?, email = ?, senha = ? where id = ?";

                PreparedStatement ps = (PreparedStatement) DB.connectionDb.prepareStatement(query);
                ps.setString(1, bean.getNome());
                ps.setString(2, bean.getCpf());
                ps.setString(3, bean.getTelefone());
                ps.setString(4, bean.getEmail());
                ps.setString(5, bean.getSenha());
                ps.setInt(6, bean.getId());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "" + e);
        }
    }

    public void deletarUsuario(int id) {

        try {

            if (JOptionPane.showConfirmDialog(null, "Realmente gostaria de deletar usuário?") == 0) {
                String query = "delete from users where id = ?";

                PreparedStatement ps = (PreparedStatement) DB.connectionDb.prepareStatement(query);
                ps.setInt(1, id);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Usuário deletado com sucesso!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "" + e);
        }
    }

}
