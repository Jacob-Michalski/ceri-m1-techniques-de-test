package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IPokemonMetadataProviderTest {

    @Test
    void getPokemonMetadata() {
        IPokemonMetadataProvider pokemonMetadataProvider = PokemonMetadataProvider.getPokemonMetadataProvider();
        assertDoesNotThrow(() -> {
            assert(pokemonMetadataProvider.getPokemonMetadata(0).getIndex() == 0);
            assert(pokemonMetadataProvider.getPokemonMetadata(133).getIndex() == 133);
        });
        assertThrows(PokedexException.class, () -> {
            pokemonMetadataProvider.getPokemonMetadata(-1);
            pokemonMetadataProvider.getPokemonMetadata(151);
        });
    }
}