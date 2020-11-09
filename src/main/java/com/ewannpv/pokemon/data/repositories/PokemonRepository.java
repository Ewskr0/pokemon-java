package com.ewannpv.pokemon.data.repositories;
 
import com.ewannpv.pokemon.data.models.PokemonModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;

public interface PokemonRepository extends PagingAndSortingRepository<PokemonModel, String> {

    List<PokemonModel> findByNameStartingWith(final String start);

    List<PokemonModel> findAll();

    List<PokemonModel> findByType(String type);

}
