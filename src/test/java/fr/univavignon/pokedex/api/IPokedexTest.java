package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IPokedexTest {

    IPokemonFactory pokemonFactory;

    Comparator<Pokemon> order = PokemonComparators.NAME;

    IPokedex pokedex;

    Pokemon bulbizzare;

    Pokemon aquali;

    @BeforeEach
    void setup() {
        pokemonFactory = new PokemonFactory();
        pokedex = new Pokedex(PokemonMetadataProvider.getPokemonMetadataProvider(), pokemonFactory);
        bulbizzare = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        aquali = pokemonFactory.createPokemon(133, 2729, 202, 5000, 4);
    }

    @Test
    void size() {
        assert(pokedex.size() == 0);
    }

    @Test
    void addPokemon() {
        int discoveredNb = pokedex.size();
        pokedex.addPokemon(bulbizzare);
        assert(pokedex.size() == discoveredNb+1);
    }

    @Test
    void getPokemon() {
        int pokid = pokedex.addPokemon(bulbizzare);
        assert(pokid == 0);
        assertDoesNotThrow(() -> {
            assert(pokedex.getPokemon(pokid).getHp() == 64);
        });
    }

    @Test
    void getPokemons() {
        List<Pokemon> discovered = pokedex.getPokemons();
        int discoveredNb = pokedex.size();
        assert(discovered != null);
        assertDoesNotThrow(() -> {
            assert(discovered.size() == discoveredNb);
        });
    }

    @Test
    void getPokemonsOrdered() {
        pokedex.addPokemon(bulbizzare);
        pokedex.addPokemon(aquali);
        List<Pokemon> sorted = pokedex.getPokemons(order);
        assert(sorted != null);
        assert(sorted.get(0) == aquali);
    }

    @Test
    void createPokemon() {
        assert(pokedex.createPokemon(0, 613, 64, 4000, 4).getIndex() == 0);
        assert(pokedex.createPokemon(133, 2729, 202, 5000, 4).getIndex() == 133);
        assert(pokedex.createPokemon(-1, 613, 64, 4000, 4) == null);
        assert(pokedex.createPokemon(151, 613, 64, 4000, 4) == null);
    }

    @Test
    void getPokemonMetadata() {
        assertDoesNotThrow(() -> {
            assert(pokedex.getPokemonMetadata(0).getIndex() == 0);
            assert(pokedex.getPokemonMetadata(133).getIndex() == 133);
        });
        assertThrows(PokedexException.class, () -> {
            pokedex.getPokemonMetadata(-1);
            pokedex.getPokemonMetadata(151);
        });
    }
}