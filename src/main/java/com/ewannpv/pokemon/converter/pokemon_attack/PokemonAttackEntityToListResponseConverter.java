package com.ewannpv.pokemon.converter.pokemon_attack;

import com.ewannpv.pokemon.converter.Converter;
import com.ewannpv.pokemon.domain.entities.PokemonAttackEntity;
import com.ewannpv.pokemon.presentation.pokemon_attack_ressource.PokemonAttackListResponse;

import org.springframework.stereotype.Service;

@Service
public class PokemonAttackEntityToListResponseConverter implements Converter<PokemonAttackEntity,PokemonAttackListResponse> {

    @Override
    public PokemonAttackListResponse convert(final PokemonAttackEntity from) {
        return new PokemonAttackListResponse(from.id, from.name, from.cost, from.dmg); 
    }    
}
