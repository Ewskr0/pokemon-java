package com.ewannpv.pokemon.converter.pokemon_trainer;

import com.ewannpv.pokemon.converter.Converter;
import com.ewannpv.pokemon.converter.pokemon_pokemon.PokemonModelToEntityConverter;
import com.ewannpv.pokemon.data.models.PokemonModel;
import com.ewannpv.pokemon.data.models.PokemonTrainerModel;
import com.ewannpv.pokemon.domain.entities.PokemonEntity;
import com.ewannpv.pokemon.domain.entities.PokemonTrainerEntity;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Collections;

@Service
public class PokemonTrainerModelToEntityConverter implements Converter<PokemonTrainerModel, PokemonTrainerEntity> {

    private PokemonModelToEntityConverter pokemonModelToEntityConverter;

    List<PokemonEntity> convertPokemons(List<PokemonModel> pokemonsModel) {

        List<PokemonEntity> pokemonsEntity = Collections.<PokemonEntity>emptyList();

        for (PokemonModel pokemon : pokemonsModel) {
            pokemonsEntity.add(pokemonModelToEntityConverter.convert(pokemon));
        }
        return pokemonsEntity;

    }

    @Override
    public PokemonTrainerEntity convert(PokemonTrainerModel from) {
        return new PokemonTrainerEntity(from.getId(), from.getName(), convertPokemons(from.getPokemons()));
    }

}
