package pets_amok;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VirtualPetTest {

    @Test
    public void testName() {
        VirtualPet underTest = new VirtualPet("Bob","Description") {
            @Override
            public void tick() {}

            @Override
            public void walk() {}

            @Override
            public void play() {}
        };
        String name = underTest.getName();
        assertEquals("Bob", name);
    }

    @Test
    public void testDescription() {
        VirtualPet underTest = new VirtualPet("Bob","Description") {
            @Override
            public void tick() {}

            @Override
            public void walk() {}

            @Override
            public void play() {}
        };
        String description = underTest.getDescription();
        assertEquals("Description", description);
    }

    @Test
    public void testHappiness() {
        VirtualPet underTest = new VirtualPet("name","description") {
            @Override
            public void tick() {}

            @Override
            public void walk() {}

            @Override
            public void play() {}
        };
        int happiness = underTest.getHappiness();
        assertEquals(0,happiness);
    }

    @Test
    public void testHealth() {
        VirtualPet underTest = new VirtualPet("name","description") {
            @Override
            public void tick() {}

            @Override
            public void walk() {}

            @Override
            public void play() {}
        };
        int happiness = underTest.getHealth();
        assertEquals(0,happiness);
    }

    @Test
    public void testType() {
        VirtualPet underTest = new VirtualPet("name","description") {
            @Override
            public void tick() {}

            @Override
            public void walk() {}

            @Override
            public void play() {}
        };
        String type = underTest.getType();
        assertEquals(null,type);
    }

}
