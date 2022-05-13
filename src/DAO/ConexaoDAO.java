/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Aluno
 */
public class ConexaoDAO {
    
    
    String url = "jdbc:mysql://localhost:3306/empresa?user=root&password=";
    public Connection conectarDAO(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
        }
        return conn;
    }
   
   
    
}
