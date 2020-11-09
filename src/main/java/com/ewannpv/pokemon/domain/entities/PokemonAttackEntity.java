package com.ewannpv.pokemon.domain.entities;

public class PokemonAttackEntity {

    public final String id;
    public final String name;
    public final int cost;
    public final int dmg;

    public PokemonAttackEntity(String id, String name, int cost, int dmg) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.dmg = dmg;
    }
}
