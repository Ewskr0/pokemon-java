package com.ewannpv.pokemon.presentation.pokemon_trainer_ressource;

import java.util.List;

import com.ewannpv.pokemon.presentation.pokemon_ressource.PokemonListResponse;

public class PokemonTrainerListResponse {
    public String id;
    public String name;
    public List<PokemonListResponse> pokemons;

    public PokemonTrainerListResponse() {
    }

    public PokemonTrainerListResponse(String id, String name, List<PokemonListResponse> pokemons) {
        this.id = id;
        this.name = name;
        this.pokemons = pokemons;
    }
}
