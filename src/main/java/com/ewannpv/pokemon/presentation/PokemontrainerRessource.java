package com.ewannpv.pokemon.presentation;

import java.util.List;
import java.util.stream.Collectors;

import com.ewannpv.pokemon.converter.pokemon_trainer.PokemonTrainerEntityToListResponseConverter;
import com.ewannpv.pokemon.domain.servicies.PokemonTrainerService;
import com.ewannpv.pokemon.presentation.pokemon_trainer_ressource.PokemonTrainerCreateRequest;
import com.ewannpv.pokemon.presentation.pokemon_trainer_ressource.PokemonTrainerListResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/trainer")
public class PokemontrainerRessource {

    private PokemonTrainerService pokemonTrainerService;
    private PokemonTrainerEntityToListResponseConverter pokemonTrainerEntityToListResponseConverter;

    @Autowired
    public PokemontrainerRessource(final PokemonTrainerService pokemonTrainerService,final PokemonTrainerEntityToListResponseConverter pokemonTrainerEntityToListResponseConverter) {
        this.pokemonTrainerService = pokemonTrainerService;
        this.pokemonTrainerEntityToListResponseConverter = pokemonTrainerEntityToListResponseConverter;
    }
    
    @GetMapping
    public ResponseEntity<List<PokemonTrainerListResponse>> list() {
        final var result = pokemonTrainerService.findAll()
                .stream()
                .map(pokemonTrainerEntityToListResponseConverter::convert)
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @GetMapping(path = "/{nameStart}")
    public ResponseEntity<List<PokemonTrainerListResponse>> listByNameStart(@PathVariable("nameStart") final String nameStart) {
        final var result = pokemonTrainerService.findByNameStartingWith(nameStart)
                .stream()
                .map(pokemonTrainerEntityToListResponseConverter::convert)
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @PostMapping()
    public void create(@RequestBody final PokemonTrainerCreateRequest createRequest) {
        pokemonTrainerService.createPokemonTrainer(createRequest.id, createRequest.name, null);
    }
}
