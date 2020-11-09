package com.ewannpv.pokemon.data.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pokemonTrainers")
public class PokemonTrainerModel {

    @Id
    private String id;
    private String name;
    private List<PokemonModel> pokemons;

    public PokemonTrainerModel() {
    }

    public PokemonTrainerModel(String id, String name, List<PokemonModel> pokemons) {
        this.id = id;
        this.name = name;
        this.pokemons = pokemons;
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

    public List<PokemonModel> getPokemons() {
        return this.pokemons;
    }

    public void setPokemons(List<PokemonModel> pokemons) {
        this.pokemons = pokemons;
    }

    public PokemonTrainerModel id(String id) {
        this.id = id;
        return this;
    }

    public PokemonTrainerModel name(String name) {
        this.name = name;
        return this;
    }

    public PokemonTrainerModel pokemons(List<PokemonModel> pokemons) {
        this.pokemons = pokemons;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PokemonTrainerModel)) {
            return false;
        }
        PokemonTrainerModel pokemonTrainerModel = (PokemonTrainerModel) o;
        return Objects.equals(id, pokemonTrainerModel.id) && Objects.equals(name, pokemonTrainerModel.name)
                && Objects.equals(pokemons, pokemonTrainerModel.pokemons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, pokemons);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + ", pokemons='" + getPokemons() + "'"
                + "}";
    }
}