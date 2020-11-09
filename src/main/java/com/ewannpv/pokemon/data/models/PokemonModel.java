package com.ewannpv.pokemon.data.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "pokemons")
public class PokemonModel {

    @Id
    private String id;
    private String name;
    private String type;
    private PokemonAttackModel attack;

    public PokemonModel() {
    }

    public PokemonModel(String id, String name, String type, PokemonAttackModel attack) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.attack = attack;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PokemonAttackModel getAttack() {
        return this.attack;
    }

    public void setAttack(PokemonAttackModel attack) {
        this.attack = attack;
    }

    public PokemonModel id(String id) {
        this.id = id;
        return this;
    }

    public PokemonModel name(String name) {
        this.name = name;
        return this;
    }

    public PokemonModel type(String type) {
        this.type = type;
        return this;
    }

    public PokemonModel attack(PokemonAttackModel attack) {
        this.attack = attack;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PokemonModel)) {
            return false;
        }
        PokemonModel pokemonModel = (PokemonModel) o;
        return Objects.equals(id, pokemonModel.id) && Objects.equals(name, pokemonModel.name)
                && Objects.equals(type, pokemonModel.type) && Objects.equals(attack, pokemonModel.attack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, attack);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + ", type='" + getType() + "'"
                + ", attack='" + getAttack() + "'" + "}";
    }
}