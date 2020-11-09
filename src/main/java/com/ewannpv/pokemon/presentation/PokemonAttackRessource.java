package com.ewannpv.pokemon.presentation;

import java.util.List;
import java.util.stream.Collectors;

import com.ewannpv.pokemon.converter.pokemon_attack.PokemonAttackEntityToListResponseConverter;
import com.ewannpv.pokemon.domain.servicies.PokemonAttackService;
import com.ewannpv.pokemon.presentation.pokemon_attack_ressource.PokemonAttackCreateRequest;
import com.ewannpv.pokemon.presentation.pokemon_attack_ressource.PokemonAttackListResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/attack")
public class PokemonAttackRessource {

    private final PokemonAttackService pokemonAttackService;
    private final PokemonAttackEntityToListResponseConverter pokemonAttackEntityToListResonseConverter;

    @Autowired
    public PokemonAttackRessource(final PokemonAttackService pokemonAttackService,
    final PokemonAttackEntityToListResponseConverter pokemonAttackEntityToListResonseConverter) {
        this.pokemonAttackService = pokemonAttackService;
        this.pokemonAttackEntityToListResonseConverter = pokemonAttackEntityToListResonseConverter;
    }
    
    @GetMapping
    public ResponseEntity<List<PokemonAttackListResponse>> list() {
        final var result = pokemonAttackService.findAll()
                .stream()
                .map(pokemonAttackEntityToListResonseConverter::convert)
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    
    @GetMapping(path = "/{nameStart}")
    public ResponseEntity<List<PokemonAttackListResponse>> listByNameStart(@PathVariable("nameStart") final String nameStart) {
        final var result = pokemonAttackService.findByNameStartingWith(nameStart)
                .stream()
                .map(pokemonAttackEntityToListResonseConverter::convert)
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @PostMapping()
    public void create(@RequestBody final PokemonAttackCreateRequest createRequest) {
        pokemonAttackService.createAttack(createRequest.id, createRequest.name, createRequest.cost, createRequest.dmg);
    }
    
}
