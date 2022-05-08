package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IPokedexTest {

    @Mock
    IPokemonMetadataProvider metadataProvider;

    @Mock
    IPokemonFactory pokemonFactory;

    Comparator<Pokemon> order = PokemonComparators.NAME;

    IPokedex pokedex;

    Pokemon bulbizzare;

    Pokemon aquali;

    @BeforeEach
    void setup() {
        pokedex = new Pokedex(metadataProvider, pokemonFactory);
        IPokemonFactory factory = new PokemonFactory();
        bulbizzare = factory.createPokemon(0, 613, 64, 4000, 4);
        aquali = factory.createPokemon(133, 2729, 202, 5000, 4);
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
}