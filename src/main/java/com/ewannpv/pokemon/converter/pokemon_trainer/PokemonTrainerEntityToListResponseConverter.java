package com.ewannpv.pokemon.converter.pokemon_trainer;

import java.util.Collections;
import java.util.List;

import com.ewannpv.pokemon.converter.Converter;
import com.ewannpv.pokemon.converter.pokemon_pokemon.PokemonEntityToListResponseConverter;
import com.ewannpv.pokemon.domain.entities.PokemonEntity;
import com.ewannpv.pokemon.domain.entities.PokemonTrainerEntity;
import com.ewannpv.pokemon.presentation.pokemon_ressource.PokemonListResponse;
import com.ewannpv.pokemon.presentation.pokemon_trainer_ressource.PokemonTrainerListResponse;

import org.springframework.stereotype.Service;

@Service
public class PokemonTrainerEntityToListResponseConverter implements Converter<PokemonTrainerEntity,PokemonTrainerListResponse> {

    private PokemonEntityToListResponseConverter pokemonEntityToListResponseConverter;

    List<PokemonListResponse> convertPokemons(List<PokemonEntity> pokemonsEntity) {

        List<PokemonListResponse> pokemonsListResponse = Collections.<PokemonListResponse>emptyList();

        for (PokemonEntity pokemon : pokemonsEntity) {
            pokemonsListResponse.add(pokemonEntityToListResponseConverter.convert(pokemon));
        }
        return pokemonsListResponse;

    }

    @Override
    public PokemonTrainerListResponse convert(PokemonTrainerEntity from) {
        List<PokemonListResponse> pokemonsListResponse = convertPokemons(from.pokemons);
        return new PokemonTrainerListResponse(from.id, from.name, pokemonsListResponse);
    }
}
