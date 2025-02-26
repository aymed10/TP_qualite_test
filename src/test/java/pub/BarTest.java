package pub;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BarTest {

    @Test
    void add() {
        Bar bar = new Bar();
        Boisson biere = new Boisson("Bière", 5.0f);
        Boisson coca = new Boisson("Coca");

        bar.add(biere);
        bar.add(coca);

        // Expect Bière (alcoholic) goes to boissonAlcoolisee
        assertTrue(bar.getBoissonAlcoolisee().contains(biere), "La bière doit être dans les boissons alcoolisées");
        // Expect Coca (non-alcoholic) goes to boissonFroide
        assertTrue(bar.getBoissonFroide().contains(coca), "Le Coca doit être dans les boissons froides");
    }

    @Test
    void testAdd() {
        Bar bar = new Bar();
        Cocktail mojito = new Cocktail("Mojito");
        // Mark Mojito as alcoholic
        mojito.setAlcoolise(true);
        Cocktail virginMojito = new Cocktail("Virgin Mojito");
        // By default, virginMojito is non-alcoholic

        bar.add(mojito);
        bar.add(virginMojito);

        assertTrue(bar.getCocktailAvecAlcoole().contains(mojito), "Le Mojito doit être dans les cocktails avec alcool");
        assertTrue(bar.getCocktailSansAlcoole().contains(virginMojito), "Le Virgin Mojito doit être dans les cocktails sans alcool");
    }

    @Test
    void serv() {
        Bar bar = new Bar();
        Boisson the = new Boisson("Thé");
        bar.getBoissonChaude().add(the);

        Object result = bar.serv("Thé");

        assertNotNull(result, "Le service doit renvoyer un objet non nul");
        assertTrue(result instanceof Boisson, "Le service doit retourner un objet de type Boisson");
        assertEquals("Thé", ((Boisson) result).getNom(), "Le nom de la boisson doit être 'Thé'");
        assertFalse(bar.getBoissonChaude().contains(the), "Le thé doit être supprimé de la liste");
    }

    @Test
    void testServBoissonChaude() {
        Bar bar = new Bar();
        Boisson cafe = new Boisson("Cafe");
        bar.getBoissonChaude().add(cafe);

        Object served = bar.serv("Cafe");
        assertNotNull(served, "Should serve Cafe from boissonChaude");
        assertEquals("Cafe", ((Boisson) served).getNom());
        assertFalse(bar.getBoissonChaude().contains(cafe), "Cafe should be removed from boissonChaude");
    }

    @Test
    void testServCocktailSansAlcoole() {
        Bar bar = new Bar();
        Cocktail virginMojito = new Cocktail("Virgin Mojito");
        bar.getCocktailSansAlcoole().add(virginMojito);

        Object served = bar.serv("Virgin Mojito");
        assertNotNull(served, "Should serve Virgin Mojito from cocktailSansAlcoole");
        assertEquals("Virgin Mojito", ((Cocktail) served).getNom());
        assertFalse(bar.getCocktailSansAlcoole().contains(virginMojito), "Virgin Mojito should be removed from cocktailSansAlcoole");
    }

    @Test
    void testServCocktailAvecAlcoole() {
        Bar bar = new Bar();
        Cocktail margarita = new Cocktail("Margarita");
        margarita.setAlcoolise(true);
        bar.getCocktailAvecAlcoole().add(margarita);

        Object served = bar.serv("Margarita");
        assertNotNull(served, "Should serve Margarita from cocktailAvecAlcoole");
        assertEquals("Margarita", ((Cocktail) served).getNom());
        assertFalse(bar.getCocktailAvecAlcoole().contains(margarita), "Margarita should be removed from cocktailAvecAlcoole");
    }

    @Test
    void testServNoMatch() {
        Bar bar = new Bar();
        Object served = bar.serv("NonExistingDrink");
        assertNull(served, "Should return null for non-existing drink");
    }

    @Test
    void testToString() {
        Bar bar = new Bar();
        bar.add(new Boisson("Eau"));
        bar.add(new Boisson("Whisky", 40.0f));
        bar.add(new Cocktail("Virgin Mojito"));
        bar.add(new Cocktail("Margarita"));

        String result = bar.toString();

        assertTrue(result.contains("Eau"), "Le toString doit contenir 'Eau'");
        assertTrue(result.contains("Whisky"), "Le toString doit contenir 'Whisky'");
        assertTrue(result.contains("Virgin Mojito"), "Le toString doit contenir 'Virgin Mojito'");
        assertTrue(result.contains("Margarita"), "Le toString doit contenir 'Margarita'");
    }
}
