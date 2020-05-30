package pets_amok;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Shelter {
    private Map<String, VirtualPet> allPets = new HashMap<>();
    private Collection<VirtualPet> pets = allPets.values();

    public Shelter() {
    }

    public void addPet(VirtualPet pet) {
        allPets.put(pet.getName(), pet);
    }

    public void removePet(String name) {
        allPets.remove(name);
    }

    public Collection<VirtualPet> showAllPets() {
        return allPets.values();
    }

    public void tick() {
        for (VirtualPet pet : pets)
            pet.tick();
    }

    public void feedPet(String name) {
        VirtualPet pet = allPets.get(name);
        if (allPets.get(name) instanceof Organic) {
            ((Organic) pet).feed();
        }
    }

    public void feedAll() {
        for (VirtualPet pet : pets)
            if (pet instanceof Organic) {
                ((Organic) pet).feed();
            }
    }

    public void waterPet(String name) {
        VirtualPet pet = allPets.get(name);
        if (allPets.get(name) instanceof Organic) {
            ((Organic) pet).water();
        }
    }

    public void waterAll() {
        for (VirtualPet pet : pets)
            if (pet instanceof Organic) {
                ((Organic) pet).water();
            }
    }

    public void walkPet(String name) {
        allPets.get(name).walk();
    }

    public void walkAll() {
        for (VirtualPet pet : pets)
            pet.walk();
    }
}
