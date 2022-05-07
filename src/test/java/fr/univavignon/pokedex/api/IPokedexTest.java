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
    Pokemon pikachu;

    @Mock
    Pokemon bulbizzare;

    @Mock
    Comparator<Pokemon> order;

    IPokedex pokedex;

    @BeforeEach
    void setup() {
        pokedex = new Pokedex();
    }

    @Test
    void size() {
        assert(pokedex.size() == 0);
    }

    @Test
    void addPokemon() {
        int discoveredNb = pokedex.size();
        pokedex.addPokemon(pikachu);
        assert(pokedex.size() == discoveredNb+1);
    }

    @Test
    void getPokemon() {
        Mockito.when(pikachu.getHp()).thenReturn(42);
        int pokid = pokedex.addPokemon(pikachu);
        assert(pokid != 0);
        assertDoesNotThrow(() -> {
            assert(pokedex.getPokemon(pokid).getHp() == 42);
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
    void getPokemonsWithArgument() {
        Mockito.when(order.compare(pikachu, bulbizzare)).thenReturn(1);
        pokedex.addPokemon(pikachu);
        pokedex.addPokemon(bulbizzare);
        List<Pokemon> sorted = pokedex.getPokemons(order);
        assert(sorted != null);
        assert(sorted.get(0) == pikachu);
    }
}