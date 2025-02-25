package pub;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoissonTest {

    @Test
    void testToString() {
        // Test for a non-alcoholic drink
        Boisson eau = new Boisson("Eau");
        String resultEau = eau.toString();
        assertEquals("Eau", resultEau, "Le toString doit retourner simplement le nom pour une boisson non alcoolisée");

        // Test for an alcoholic drink
        Boisson whisky = new Boisson("Whisky", 40.0f);
        String resultWhisky = whisky.toString();
        assertEquals("Whisky (l'abus d'alcool est dangereux pour la sante)", resultWhisky, "Le toString doit inclure l'avertissement pour une boisson alcoolisée");
    }
}
