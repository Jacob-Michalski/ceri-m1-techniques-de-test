package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;
import org.testng.annotations.BeforeClass;

import static org.junit.jupiter.api.Assertions.*;

class PokemonMetadataTest {

    PokemonMetadata bulbizzare;

    @BeforeClass
    void setup() {
        bulbizzare = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
    }

    @Test
    void getIndex() {
        assert(bulbizzare.getIndex() == 0);
    }

    @Test
    void getName() {
        assert(bulbizzare.getName().equals("bulbizzare"));
    }

    @Test
    void getAttack() {
        assert(bulbizzare.getAttack() == 126);
    }

    @Test
    void getDefense() {
        assert(bulbizzare.getDefense() == 126);
    }

    @Test
    void getStamina() {
        assert(bulbizzare.getStamina() == 90);
    }
}