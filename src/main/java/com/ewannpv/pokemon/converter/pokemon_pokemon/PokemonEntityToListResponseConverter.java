package com.ewannpv.pokemon.converter.pokemon_pokemon;

import org.springframework.stereotype.Service;
import com.ewannpv.pokemon.converter.Converter;
import com.ewannpv.pokemon.converter.pokemon_attack.PokemonAttackEntityToListResponseConverter;
import com.ewannpv.pokemon.domain.entities.PokemonEntity;
import com.ewannpv.pokemon.presentation.pokemon_attack_ressource.PokemonAttackListResponse;
import com.ewannpv.pokemon.presentation.pokemon_ressource.PokemonListResponse;

@Service
public class PokemonEntityToListResponseConverter  implements Converter<PokemonEntity, PokemonListResponse> {

    private PokemonAttackEntityToListResponseConverter pokemonAttackEntityToListResonseConverter;

    @Override
    public PokemonListResponse convert(PokemonEntity from) {
        PokemonAttackListResponse attack = pokemonAttackEntityToListResonseConverter.convert(from.attack);
        return new PokemonListResponse(from.id, from.name, from.type,attack);
    }
    
}
