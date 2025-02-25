package pub;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CaveTest {

    @Test
    void add() {
        Cave cave = new Cave();
        Boisson coca = new Boisson("Coca");
        cave.add(coca);

        assertTrue(cave.rayons.contains(coca), "La boisson Coca doit être ajoutée à la cave");
    }

    @Test
    void take() {
        Cave cave = new Cave();
        Boisson whisky = new Boisson("Whisky", 40.0f);
        cave.add(whisky);

        Boisson result = cave.take("Whisky");

        assertNotNull(result, "La boisson doit être retirée avec succès");
        assertEquals("Whisky", result.nom, "Le nom de la boisson retirée doit être Whisky");
        assertFalse(cave.rayons.contains(whisky), "La boisson Whisky ne doit plus être dans la cave");
    }

    @Test
    void testToString() {
        Cave cave = new Cave();
        cave.add(new Boisson("Eau"));
        cave.add(new Boisson("Bière", 5.0f));

        String result = cave.toString();

        assertTrue(result.contains("Eau"), "Le toString doit contenir 'Eau'");
        assertTrue(result.contains("Bière"), "Le toString doit contenir 'Bière'");
        assertTrue(result.contains("l'abus d'alcool est dangereux pour la sante"), "Le toString doit inclure l'avertissement pour les boissons alcoolisées");
    }
}
