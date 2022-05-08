package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;

class IPokemonFactoryTest {

    @Test
    void createPokemon() {
        IPokemonFactory pokemonFactory = new PokemonFactory();
        assert(pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getIndex() == 0);
        assert(pokemonFactory.createPokemon(133, 2729, 202, 5000, 4).getIndex() == 133);
    }
}