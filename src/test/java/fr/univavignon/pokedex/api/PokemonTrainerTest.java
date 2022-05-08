package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class PokemonTrainerTest {

    @Mock
    IPokemonMetadataProvider metadataProvider;
    @Mock
    IPokemonFactory pokemonFactory;
    PokemonTrainer sacha;

    @BeforeEach
    public void setup() {
        sacha = new PokemonTrainer("Sacha", Team.INSTINCT, new Pokedex(metadataProvider, pokemonFactory));
    }

    @Test
    void getName() {
        assert(sacha.getName().equals("Sacha"));
    }

    @Test
    void getTeam() {
        assert(sacha.getTeam() == Team.INSTINCT);
    }

    @Test
    void getPokedex() {
        assertInstanceOf(Pokedex.class, sacha.getPokedex());
    }
}