package com.ewannpv.pokemon.data.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

import com.ewannpv.pokemon.data.models.PokemonAttackModel;

public interface PokemonAttackRepository extends PagingAndSortingRepository<PokemonAttackModel, String> {

    List<PokemonAttackModel> findByNameStartingWith(final String start);

    List<PokemonAttackModel> findAll();
}
