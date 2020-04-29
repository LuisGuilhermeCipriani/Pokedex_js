/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PokemonDao;
import java.util.ArrayList;
import java.util.List;
import model.Pokemon;

/**
 *
 * @author cipri
 */
public class PokemonController {
    Pokemon pokemon;
    List<Pokemon> listaPokemon;
    PokemonDao pokemonDao;

    public PokemonController() {
        pokemon = new Pokemon();
        listaPokemon = new ArrayList<>();
        pokemonDao = new PokemonDao();
    }

    public List<Pokemon> getListaPokemon() {
        return listaPokemon;
    }  
    
    public void cadastrar(Pokemon pokemon){
        listaPokemon.add(pokemon);
    }
}
