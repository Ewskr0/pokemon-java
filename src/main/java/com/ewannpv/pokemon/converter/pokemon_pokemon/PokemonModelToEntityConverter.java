package com.ewannpv.pokemon.converter.pokemon_pokemon;

import com.ewannpv.pokemon.converter.Converter;
import com.ewannpv.pokemon.converter.pokemon_attack.PokemonAttackModelToEntityConverter;
import com.ewannpv.pokemon.data.models.PokemonModel;
import com.ewannpv.pokemon.domain.entities.PokemonAttackEntity;
import com.ewannpv.pokemon.domain.entities.PokemonEntity;

import org.springframework.stereotype.Service;

@Service
public class PokemonModelToEntityConverter implements Converter<PokemonModel, PokemonEntity> {

    private PokemonAttackModelToEntityConverter pokemonAttackModelToEntityConverter;

    @Override
    public PokemonEntity convert(PokemonModel from) {
        PokemonAttackEntity attackEntity = pokemonAttackModelToEntityConverter.convert(from.getAttack());
        return new PokemonEntity(from.getId(), from.getName(), from.getType(), attackEntity);
    }
}
