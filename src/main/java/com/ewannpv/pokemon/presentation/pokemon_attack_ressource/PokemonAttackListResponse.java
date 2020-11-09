package com.ewannpv.pokemon.presentation.pokemon_attack_ressource;

public class PokemonAttackListResponse {
    public String id;
    public String name;
    public int cost;
    public int dmg;

    public PokemonAttackListResponse() {
    }

    public PokemonAttackListResponse(final String id, final String name, final int cost, final int dmg) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.dmg = dmg;
    }
}
