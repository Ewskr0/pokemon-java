package com.ewannpv.pokemon.data.repositories;

import com.ewannpv.pokemon.data.models.PokemonTrainerModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;

public interface PokemonTrainerRepository extends PagingAndSortingRepository<PokemonTrainerModel, String> {

    List<PokemonTrainerModel> findByNameStartingWith(final String start);

    List<PokemonTrainerModel> findAll();
}
