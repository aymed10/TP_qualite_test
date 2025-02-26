package pub;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PubTest {

    @Test
    void approvisionnerBar() {
        Pub pub = new Pub();
        Boisson coca = new Boisson("Coca");
        pub.getCave().add(coca);

        pub.approvisionnerBar("Coca");

        assertFalse(pub.getCave().getRayons().contains(coca), "La boisson Coca doit être retirée de la cave après approvisionnement");
        assertTrue(pub.getBar().getBoissonFroide().contains(coca), "La boisson Coca doit être ajoutée au bar");
    }

    @Test
    void main() {
        assertDoesNotThrow(() -> Pub.main(new String[]{}), "La méthode main doit s'exécuter sans exception");
    }
}
