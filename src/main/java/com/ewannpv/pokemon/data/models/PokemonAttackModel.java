package com.ewannpv.pokemon.data.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "attacks")
public class PokemonAttackModel {
    @Id
    private String id;
    private String name;
    private int cost;
    private int dmg;

    public PokemonAttackModel() {
    }

    public PokemonAttackModel(final String id, final String name, final int cost, final int dmg) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.dmg = dmg;
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

    public int getCost() {
        return this.cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getDmg() {
        return this.dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public PokemonAttackModel id(String id) {
        this.id = id;
        return this;
    }

    public PokemonAttackModel name(String name) {
        this.name = name;
        return this;
    }

    public PokemonAttackModel cost(int cost) {
        this.cost = cost;
        return this;
    }

    public PokemonAttackModel dmg(int dmg) {
        this.dmg = dmg;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PokemonAttackModel)) {
            return false;
        }
        PokemonAttackModel pokemonAttackModel = (PokemonAttackModel) o;
        return Objects.equals(id, pokemonAttackModel.id) && Objects.equals(name, pokemonAttackModel.name)
                && cost == pokemonAttackModel.cost && dmg == pokemonAttackModel.dmg;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cost, dmg);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + ", cost='" + getCost() + "'" + ", dmg='"
                + getDmg() + "'" + "}";
    }
}
