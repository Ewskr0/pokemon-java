package com.ewannpv.pokemon.presentation;

import java.util.List;
import java.util.stream.Collectors;

import com.ewannpv.pokemon.converter.pokemon_pokemon.PokemonEntityToListResponseConverter;
import com.ewannpv.pokemon.domain.servicies.PokemonService;
import com.ewannpv.pokemon.presentation.pokemon_ressource.PokemonCreateRequest;
import com.ewannpv.pokemon.presentation.pokemon_ressource.PokemonListResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/pokemon")
public class PokemonRessource {

    private final PokemonService pokemonService;
    private final PokemonEntityToListResponseConverter pokemonEntityToListResonseConverter;

    @Autowired
    public PokemonRessource(final PokemonService pokemonService,final PokemonEntityToListResponseConverter pokemonEntityToListResonseConverter) {
        this.pokemonService = pokemonService;
        this.pokemonEntityToListResonseConverter = pokemonEntityToListResonseConverter;
    }
    
    @GetMapping
    public ResponseEntity<List<PokemonListResponse>> list() {
        final var result = pokemonService.findAll()
                .stream()
                .map(pokemonEntityToListResonseConverter::convert)
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @GetMapping(path = "/{nameStart}")
    public ResponseEntity<List<PokemonListResponse>> listByNameStart(@PathVariable("nameStart") final String nameStart) {
        final var result = pokemonService.findByNameStartingWith(nameStart)
                .stream()
                .map(pokemonEntityToListResonseConverter::convert)
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @GetMapping(path = "/type/{nameStart}")
    public ResponseEntity<List<PokemonListResponse>> listByType(@PathVariable("type") final String type) {
        final var result = pokemonService.findByType(type)
                .stream()
                .map(pokemonEntityToListResonseConverter::convert)
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }
    
    @PostMapping()
    public void create(@RequestBody final PokemonCreateRequest createRequest) {
        pokemonService.createPokemon(createRequest.id, createRequest.name, createRequest.type, null);
    }
}
