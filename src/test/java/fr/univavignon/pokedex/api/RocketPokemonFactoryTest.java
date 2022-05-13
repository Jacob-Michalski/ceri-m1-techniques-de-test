package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RocketPokemonFactoryTest {

    @Test
    void createPokemon() {
        IPokemonFactory pokemonFactory = new RocketPokemonFactory();
        assert(pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getIndex() == 0);
        assert(pokemonFactory.createPokemon(133, 2729, 202, 5000, 4).getIndex() == 133);
        assert(pokemonFactory.createPokemon(-1, 613, 64, 4000, 4) == null);
        assert(pokemonFactory.createPokemon(151, 613, 64, 4000, 4) == null);

    }
}