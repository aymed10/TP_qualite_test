package pub;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PubTest {

    @Test
    void approvisionnerBar() {
        Pub pub = new Pub();
        Boisson coca = new Boisson("Coca");
        pub.cave.add(coca);

        pub.approvisionnerBar("Coca");

        assertFalse(pub.cave.rayons.contains(coca), "La boisson Coca doit être retirée de la cave après approvisionnement");
        assertTrue(pub.bar.boissonFroide.contains(coca), "La boisson Coca doit être ajoutée au bar");
    }

    @Test
    void main() {
        // Test que la méthode main s'exécute sans lancer d'exception
        assertDoesNotThrow(() -> Pub.main(new String[]{}), "La méthode main doit s'exécuter sans exception");
    }
}
