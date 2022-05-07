package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokemonTrainerTest {

    PokemonTrainer sacha;

    @Before
    public void setup() {
        sacha = new PokemonTrainer("Sacha", Team.INSTINCT, new Pokedex());
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