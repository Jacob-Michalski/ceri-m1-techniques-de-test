package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class IPokemonTrainerFactoryTest {

    @Mock
    Team team;

    @Mock
    IPokedexFactory pokedexFactory;

    @Test
    void createTrainer() {
        IPokemonTrainerFactory pokemonTrainerFactory = new PokemonTrainerFactory();
        assert(pokemonTrainerFactory.createTrainer("Sacha", team, pokedexFactory).getName().equals("Sacha"));

    }

}