package pets_amok;

import org.junit.jupiter.api.Test;

import java.text.CollationElementIterator;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

public class ShelterTest {



    @Test
    public void addPetToShelter() {
        VirtualPet testPet = new VirtualPet("Test");
        ShelterTest underTest = new ShelterTest();

        underTest.admit(testPet);

        Collection<VirtualPet> pets = underTest.retrieveAllPets();
        assertThat(pets)

    }

    private Collection<VirtualPet> retrieveAllPets() {
    }

    private void admit(VirtualPet testPet) {
    }

}