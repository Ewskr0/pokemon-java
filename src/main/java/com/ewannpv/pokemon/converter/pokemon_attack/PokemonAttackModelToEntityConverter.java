package com.ewannpv.pokemon.converter.pokemon_attack;

import com.ewannpv.pokemon.converter.Converter;
import com.ewannpv.pokemon.data.models.PokemonAttackModel;
import com.ewannpv.pokemon.domain.entities.PokemonAttackEntity;

import org.springframework.stereotype.Service;

@Service
public class PokemonAttackModelToEntityConverter implements Converter<PokemonAttackModel, PokemonAttackEntity> {

    @Override
    public PokemonAttackEntity convert(PokemonAttackModel from) {
       return new PokemonAttackEntity(from.getId(), from.getName(), from.getCost(), from.getDmg());
    }
    
}
