/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.FuncionarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */
public class FuncionarioDAO {
    Connection conn;
    
    public void cadastrarFuncionario(FuncionarioDTO objDTO){
        String comando = "insert into funcionario (nome, cpf, telefone) values (?,?,?)";
        conn = new ConexaoDAO().conectarDAO();
        try {
            PreparedStatement pstm;
            pstm = conn.prepareStatement(comando);
            pstm.setString(1, objDTO.getNome());
            pstm.setInt(2, objDTO.getCpf());
            pstm.setInt(3, objDTO.getTelefone());
            pstm.execute();
            
        } catch (Exception e){
            
            JOptionPane.showMessageDialog(null, "FuncionarioDAO" +  e);
        }
    }
    public ArrayList<FuncionarioDTO> listar(){
        String comando = "select * from funcionario";
        FuncionarioDTO objFuncionarioDTO = new FuncionarioDTO();
        
        ArrayList<FuncionarioDTO> lista = new ArrayList();
         try {
            PreparedStatement pstm;
            pstm = conn.prepareStatement(comando);
            
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                objFuncionarioDTO.setId(rs.getInt("id"));
                objFuncionarioDTO.setNome(rs.getString("nome"));
                objFuncionarioDTO.setCpf(rs.getInt("cpf"));
                objFuncionarioDTO.setTelefone(rs.getInt("telefone"));
                
                lista.add(objFuncionarioDTO);
            }
            
        } catch (Exception e){
            
            JOptionPane.showMessageDialog(null, "FuncionarioDAO" +  e);
        }
         return lista;
    }
    
    public FuncionarioDTO listar(String nome){
        String comando = "select * from funcionario where nome like " + nome;
        FuncionarioDTO objFuncionarioDTO = new FuncionarioDTO();
        try {
            PreparedStatement pstm;
            pstm = conn.prepareStatement(comando);
            
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                objFuncionarioDTO.setId(rs.getInt("id"));
                objFuncionarioDTO.setNome(rs.getString("nome"));
                objFuncionarioDTO.setCpf(rs.getInt("cpf"));
                objFuncionarioDTO.setTelefone(rs.getInt("telefone"));
            }
        } catch (Exception e) {
        }
        return objFuncionarioDTO;
    }
}
