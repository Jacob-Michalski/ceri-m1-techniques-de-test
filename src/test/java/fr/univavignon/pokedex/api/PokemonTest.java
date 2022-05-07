package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.testng.annotations.BeforeClass;

import static org.junit.jupiter.api.Assertions.*;

class PokemonTest {

    Pokemon bulbizzare;

    @BeforeClass
    void setup() {
        bulbizzare = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
    }

    @Test
    void getCp() {
        assert(bulbizzare.getCp() == 613);
    }

    @Test
    void getHp() {
        assert(bulbizzare.getHp() == 64);
    }

    @Test
    void getDust() {
        assert(bulbizzare.getDust() == 4000);
    }

    @Test
    void getCandy() {
        assert(bulbizzare.getCandy() == 4);
    }

    @Test
    void getIv() {
        assert(bulbizzare.getIv() == 0.56);
    }
}