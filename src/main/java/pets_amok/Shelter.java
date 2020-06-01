package pets_amok;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Shelter {
    private Map<String, VirtualPet> allPets = new HashMap<>();
    private Collection<VirtualPet> pets = allPets.values();
    public LitterBox litterBox = new LitterBox();

    public Shelter() {
    }

    public void addPet(VirtualPet pet) {
        allPets.put(pet.getName(), pet);
    }

    public void removePet(String name) {
        allPets.remove(name);
    }

    public VirtualPet returnPet(String name) {
        return allPets.get(name);
    }

    public Collection<VirtualPet> showAllPets() {
        return allPets.values();
    }

    public void tick() {
        for (VirtualPet pet : pets) {
            pet.tick();
            if (pet instanceof Organic)
            System.out.println(pet.getName() + "'s waste level is: " + ((Organic) pet).getWaste());
        }
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
        for (VirtualPet pet : pets) {
            pet.walk();
            if (pet instanceof Cat) {
                litterBox.useLitterBox();
            }
        }
    }

    public void playPet(String name) {
        allPets.get(name).play();
    }

    public void playAll() {
        for (VirtualPet pet : pets)
            pet.play();
    }

    public void oilPet(String name) {
        VirtualPet pet = allPets.get(name);
        if (allPets.get(name) instanceof Robotic) {
            ((Robotic) pet).oil();
        }
    }

    public void oilAll() {
        for (VirtualPet pet : pets)
            if (pet instanceof Robotic) {
                ((Robotic) pet).oil();
            }
    }

    public void cleanPet(String name) {
        VirtualPet pet = allPets.get(name);
        if (allPets.get(name) instanceof Organic) {
            ((Organic) pet).cleanCage();
        }
    }

    public void cleanAll() {
        for (VirtualPet pet : pets)
            if (pet instanceof Organic) {
                ((Organic) pet).cleanCage();
            }
        litterBox.cleanLitterBox();
    }

    public void checkLitterBox() {
        System.out.println("The litter box's cleanliness level is at " + litterBox.getCleanliness());
    }
}
