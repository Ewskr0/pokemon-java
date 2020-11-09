package com.ewannpv.pokemon.domain.entities;

public class PokemonEntity {

    public final String id;
    public final String name;
    public final String type;
    public final PokemonAttackEntity attack;

    public PokemonEntity(String id, String name, String type, PokemonAttackEntity attack) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.attack = attack;
    }

}
