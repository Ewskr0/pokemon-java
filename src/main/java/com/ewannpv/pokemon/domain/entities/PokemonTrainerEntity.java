package com.ewannpv.pokemon.domain.entities;

import java.util.List;

public class PokemonTrainerEntity {
    public final String id;
    public final String name;
    public final List<PokemonEntity> pokemons;

    public PokemonTrainerEntity(String id, String name, List<PokemonEntity> pokemons) {
        this.id = id;
        this.name = name;
        this.pokemons = pokemons;
    }
}
