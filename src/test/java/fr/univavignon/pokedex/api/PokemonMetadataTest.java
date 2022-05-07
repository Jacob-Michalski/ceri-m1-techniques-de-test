package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class PokemonMetadataTest {

    PokemonMetadata bulbizzare;

    @Before
    public void setup() {
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