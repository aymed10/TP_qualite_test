package pub;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CocktailTest {

    @Test
    void add() {
        Cocktail cocktail = new Cocktail("Mojito");
        cocktail.add("Menthe", 30.0);
        cocktail.add("Eau gazeuse", 70.0);

        String result = cocktail.toString();

        assertTrue(result.contains("Menthe 30.0%"), "Le toString doit contenir 'Menthe 30.0%'");
        assertTrue(result.contains("Eau gazeuse 70.0%"), "Le toString doit contenir 'Eau gazeuse 70.0%'");
    }

    @Test
    void alcoolFree() {
        Cocktail cocktailSansAlcool = new Cocktail("Virgin Mojito");
        assertTrue(cocktailSansAlcool.alcoolFree(), "Le cocktail doit être sans alcool par défaut");

        Cocktail cocktailAvecAlcool = new Cocktail("Mojito");
        cocktailAvecAlcool.setAlcoolise(true); // Use setter
        assertFalse(cocktailAvecAlcool.alcoolFree(), "Le cocktail doit être alcoolisé après modification");
    }

    @Test
    void testToString() {
        Cocktail cocktail = new Cocktail("Pina Colada");
        cocktail.add("Ananas", 50.0);
        cocktail.add("Lait de coco", 30.0);
        cocktail.add("Rhum", 20.0);

        String result = cocktail.toString();

        assertTrue(result.contains("Ananas 50.0%"), "Le toString doit contenir 'Ananas 50.0%'");
        assertTrue(result.contains("Lait de coco 30.0%"), "Le toString doit contenir 'Lait de coco 30.0%'");
        assertTrue(result.contains("Rhum 20.0%"), "Le toString doit contenir 'Rhum 20.0%'");
    }
}
