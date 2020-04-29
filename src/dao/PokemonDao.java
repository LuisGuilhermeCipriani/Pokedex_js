/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Pokemon;
import util.ConnectionFactory;

/**
 *
 * @author cipri
 */
public class PokemonDao {
    
    public void inserir(Pokemon pokemon){
        Connection conexao = new ConnectionFactory().connector();
        String sql = "INSERT INTO pokemos(nome, anterior, proximo, ID, tipo) VALUES(?, ?, ?, ?, ?)";
        try{
            PreparedStatement stm = conexao.prepareStatement(sql);
            
            stm.setString(1, pokemon.getNome());
            stm.setString(2, pokemon.getAnterior());
            stm.setString(3, pokemon.getProximo());
            stm.setInt(4, pokemon.getID());
            stm.setString(5, pokemon.getTipo().name());
            
            stm.executeUpdate();
            
        }catch(SQLException ex){
            throw new RuntimeException("Erro ao inserir Pokemon" + ex);
        }
    }
}
