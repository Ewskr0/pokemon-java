package com.ewannpv.pokemon.domain.servicies;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.ewannpv.pokemon.converter.pokemon_pokemon.PokemonModelToEntityConverter;
import com.ewannpv.pokemon.data.models.PokemonAttackModel;
import com.ewannpv.pokemon.data.models.PokemonModel;
import com.ewannpv.pokemon.data.repositories.PokemonRepository;
import com.ewannpv.pokemon.domain.entities.PokemonEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokemonService {
    private final PokemonRepository pokemonRepository;
    private final PokemonModelToEntityConverter pokemonModelToEntityConverter;

    @Autowired

    public PokemonService(final PokemonRepository pokemonRepository,
            final PokemonModelToEntityConverter pokemonModelToEntityConverter) {
        this.pokemonRepository = pokemonRepository;
        this.pokemonModelToEntityConverter = pokemonModelToEntityConverter;
    }

    @Transactional
    public void createPokemon(final String id, final String name, String type, PokemonAttackModel attack) {
        final PokemonModel pokemon = new PokemonModel(id, name, type, attack);
        pokemonRepository.save(pokemon);
    }

    public List<PokemonEntity> findByNameStartingWith(final String start) {
        final List<PokemonModel> pokemonModelList = pokemonRepository.findByNameStartingWith(start);
        return pokemonModelList.stream().map(pokemonModelToEntityConverter::convert).collect(Collectors.toList());
    }

    public List<PokemonEntity> findByType(final String type) {
        final List<PokemonModel> pokemonModelList = pokemonRepository.findByType(type);
        return pokemonModelList.stream().map(pokemonModelToEntityConverter::convert).collect(Collectors.toList());
    }

    public List<PokemonEntity> findAll() {
        final List<PokemonModel> attackModelList = pokemonRepository.findAll();
        return attackModelList.stream().map(pokemonModelToEntityConverter::convert).collect(Collectors.toList());
    }
}
