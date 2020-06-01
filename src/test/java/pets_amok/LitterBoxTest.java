package pets_amok;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LitterBoxTest {

    @Test
    public void litterBoxCleanliness() {
        LitterBox underTest = new LitterBox();
        int cleanliness = underTest.getCleanliness();
        assertEquals(10,cleanliness);
    }
}
