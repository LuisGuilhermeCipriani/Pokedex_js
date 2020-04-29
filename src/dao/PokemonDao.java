/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Pokemon;
import model.Tipo;
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
    
    public List<Pokemon> buscar(){
        Connection conexao = new ConnectionFactory().connector();
        String sql = "SELECT * FROM pokemon";
        List<Pokemon> lista = new ArrayList<>();
        try{
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                Pokemon pokemon = new Pokemon();
                pokemon.setNome(rs.getString("nome"));
                pokemon.setAnterior(rs.getString("anterior"));
                pokemon.setProximo(rs.getString("proximo"));
                pokemon.setID(rs.getInt("ID"));
                pokemon.setTipo(Tipo.valueOf(rs.getString("tipo")));
                lista.add(pokemon);
            }
            return lista;
        }catch(SQLException ex){
            throw new RuntimeException("Erro ao buscar Pokemon" + ex);
        }
    }
}
