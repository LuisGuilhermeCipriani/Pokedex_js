/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author cipri
 */
public class ConnectionFactory {
    
    public java.sql.Connection connector(){
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost/Pokedex_js","root","");
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }     
    }
}
