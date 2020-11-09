package com.ewannpv.pokemon.domain.servicies;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.ewannpv.pokemon.converter.pokemon_attack.PokemonAttackModelToEntityConverter;
import com.ewannpv.pokemon.data.models.PokemonAttackModel;
import com.ewannpv.pokemon.data.repositories.PokemonAttackRepository;
import com.ewannpv.pokemon.domain.entities.PokemonAttackEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokemonAttackService {

    private final PokemonAttackRepository pokemonAttackRepository;
    private final PokemonAttackModelToEntityConverter pokemonAttackModelToEntityConverter;

    @Autowired

    public PokemonAttackService(final PokemonAttackRepository pokemonAttackRepository,
            final PokemonAttackModelToEntityConverter pokemonAttackModelToEntityConverter) {
        this.pokemonAttackRepository = pokemonAttackRepository;
        this.pokemonAttackModelToEntityConverter = pokemonAttackModelToEntityConverter;
    }

    @Transactional
    public void createAttack(final String id, final String name, int cost, int dmg) {
        final PokemonAttackModel attack = new PokemonAttackModel(id, name, cost, dmg);
        pokemonAttackRepository.save(attack);
    }

    public List<PokemonAttackEntity> findByNameStartingWith(final String start) {
        final List<PokemonAttackModel> attackModelList = pokemonAttackRepository.findByNameStartingWith(start);
        return attackModelList.stream().map(pokemonAttackModelToEntityConverter::convert).collect(Collectors.toList());
    }

    public List<PokemonAttackEntity> findAll() {
        final List<PokemonAttackModel> attackModelList = pokemonAttackRepository.findAll();
        return attackModelList.stream().map(pokemonAttackModelToEntityConverter::convert).collect(Collectors.toList());
    }
}
