package com.ewannpv.pokemon.presentation.pokemon_ressource;

import com.ewannpv.pokemon.presentation.pokemon_attack_ressource.PokemonAttackListResponse;

public class PokemonListResponse {
    public  String id;
    public  String name;
    public  String type;
    public PokemonAttackListResponse attack;

    public PokemonListResponse() {
    }

    public PokemonListResponse(final String id,final String name,final String type, final PokemonAttackListResponse attack) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.attack = attack;
    }
}