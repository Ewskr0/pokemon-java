package com.ewannpv.pokemon.domain.servicies;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.ewannpv.pokemon.converter.pokemon_trainer.PokemonTrainerModelToEntityConverter;
import com.ewannpv.pokemon.data.models.PokemonModel;
import com.ewannpv.pokemon.data.models.PokemonTrainerModel;
import com.ewannpv.pokemon.data.repositories.PokemonTrainerRepository;
import com.ewannpv.pokemon.domain.entities.PokemonTrainerEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokemonTrainerService {

    private final PokemonTrainerRepository pokemonTrainerRepository;
    private final PokemonTrainerModelToEntityConverter pokemonTrainerModelToEntityConverter;

    @Autowired

    public PokemonTrainerService(final PokemonTrainerRepository pokemonTrainerRepository,
            final PokemonTrainerModelToEntityConverter pokemonTrainerModelToEntityConverter) {
        this.pokemonTrainerRepository = pokemonTrainerRepository;
        this.pokemonTrainerModelToEntityConverter = pokemonTrainerModelToEntityConverter;
    }

    @Transactional
    public void createPokemonTrainer(final String id, final String name, List<PokemonModel> pokemons) {
        final PokemonTrainerModel pokemonTrainer = new PokemonTrainerModel(id, name, pokemons);
        pokemonTrainerRepository.save(pokemonTrainer);
    }

    public List<PokemonTrainerEntity> findByNameStartingWith(final String start) {
        final List<PokemonTrainerModel> pokemonTrainerkModelList = pokemonTrainerRepository.findByNameStartingWith(start);
        return pokemonTrainerkModelList.stream().map(pokemonTrainerModelToEntityConverter::convert).collect(Collectors.toList());
    }

    public List<PokemonTrainerEntity> findAll() {
        final List<PokemonTrainerModel> pokemonTrainerkModelList = pokemonTrainerRepository.findAll();
        return pokemonTrainerkModelList.stream().map(pokemonTrainerModelToEntityConverter::convert).collect(Collectors.toList());
    }
}
