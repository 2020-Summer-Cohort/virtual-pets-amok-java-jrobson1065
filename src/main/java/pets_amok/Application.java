package pets_amok;

import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    private static Shelter shelter = new Shelter();
    private static Collection<VirtualPet> pets = shelter.showAllPets();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        welcome();
        generatePets();
        showPets();
        input.nextLine();
        gameLoop();
    }

    private static void gameLoop() {
        while (true) {
            for (VirtualPet pet : pets) {
                if (pet.getHealth() == 0) {
                    runGameOver();
                }
                if (pet instanceof Organic) {
                    if (((Organic) pet).getNeedToGoToBathroom() > 3) {
                        ((Organic) pet).usesBathroomInCage();
                    }
                }
            }
            optionMenu();
            actions();
        }
    }

    private static void runGameOver() {
        System.out.println("Your pets weren't all taken care of. You lose.");
        System.exit(0);
    }

    private static void actions() {
        try {
            int response = input.nextInt();
            input.nextLine();
            options(response);
            shelter.tick();
            showPets();
        } catch (InputMismatchException exception) {
            invalidEntry();
            input.nextLine();
        }
    }

    private static void optionMenu() {
        System.out.println("What would you like to do?");
        System.out.println("\t1 - Feed");
        System.out.println("\t2 - Water");
        System.out.println("\t3 - Walk");
        System.out.println("\t4 - Play");
        System.out.println("\t5 - Oil");
        System.out.println("\t6 - Clean Cage");
        System.out.println("\t7 - Adopt a Pet");
        System.out.println("\t8 - Admit a Pet");
        System.out.println("\t9 - CHeck Litter Box");
        System.out.println("\t0 - Quit");
    }

    private static void invalidEntry() {
        System.out.println("Invalid Entry, please try again.");
    }

    private static void options(int response) {
        switch (response) {
            case 1:
                feedOptions();
                break;
            case 2:
                waterOptions();
                break;
            case 3:
                walkOptions();
                break;
            case 4:
                playOptions();
                break;
            case 5:
                oilOptions();
                break;
            case 6:
                cleanCageOptions();
                break;
            case 7:
                adoptOptions();
                break;
            case 8:
                admitOptions();
                break;
            case 9:
                shelter.checkLitterBox();
                break;
            case 0:
                System.exit(0);
        }
    }

    private static void showOrganicPets() {
        for (VirtualPet pet : pets)
            if (pet instanceof Organic) {
                System.out.println(pet.getName());
            }
    }

    private static void showRoboticPets() {
        for (VirtualPet pet : pets)
            if (pet instanceof Robotic) {
                System.out.println(pet.getName());
            }
    }

    private static void showAllPets() {
        for (VirtualPet pet : pets)
            System.out.println(pet.getName());
    }

    private static void feedOptions() {
        System.out.println("Enter name to feed a single pet or enter \"all\" to feed all.");
        showOrganicPets();
        String response = input.nextLine();
        if (response.equalsIgnoreCase("all")) {
            shelter.feedAll();
        } else {
            shelter.feedPet(response);
        }
    }

    private static void waterOptions() {
        System.out.println("Enter name to give water to a single pet or enter \"all\" to water all.");
        showOrganicPets();
        String response = input.nextLine();
        if (response.equalsIgnoreCase("all")) {
            shelter.waterAll();
        } else {
            shelter.waterPet(response);
        }
    }

    private static void walkOptions() {
        System.out.println("Enter name to walk a single pet or enter \"all\" to walk all.");
        showAllPets();
        String response = input.nextLine();
        if (response.equalsIgnoreCase("all")) {
            shelter.walkAll();
        } else {
            shelter.walkPet(response);
        }
    }

    private static void playOptions() {
        System.out.println("Enter name to play with a single pet or enter \"all\" to play with all.");
        showAllPets();
        String response = input.nextLine();
        if (response.equalsIgnoreCase("all")) {
            shelter.playAll();
        } else {
            shelter.playPet(response);
        }
    }

    private static void oilOptions() {
        System.out.println("Enter name to play with a single pet or enter \"all\" to play with all.");
        showRoboticPets();
        String response = input.nextLine();
        if (response.equalsIgnoreCase("all")) {
            shelter.oilAll();
        } else {
            shelter.oilPet(response);
        }
    }

    private static void cleanCageOptions() {
        System.out.println("Enter name to clean a single pet's cage or enter \"all\" to clean all.");
        showOrganicPets();
        String response = input.nextLine();
        if (response.equalsIgnoreCase("all")) {
            shelter.cleanAll();
        } else {
            shelter.cleanPet(response);
        }
    }

    private static void adoptOptions() {
        System.out.println("Enter name to adopt a single pet.");
        showAllPets();
        String response = input.nextLine();
        VirtualPet pet = shelter.returnPet(response);
        System.out.println("You adopted " + pet.getName() + ". " + pet.getDescription());
        shelter.removePet(response);
    }

    private static void admitOptions() {
        String name = askPetName();
        String description = askPetDescription();
        int type = askPetType(name);
        VirtualPet pet = new Cat(name, description);
        switch (type) {
            case 2:
                pet = new Dog(name, description);
                break;
            case 3:
                pet = new RoboticCat(name, description);
                break;
            case 4:
                pet = new RoboticDog(name, description);
        }
        System.out.println("You admitted " + name + ". ");
        shelter.addPet(pet);
    }

    private static int askPetType(String name) {
        System.out.println("What type of pet is " + name + "?");
        System.out.println("\t1 - Cat");
        System.out.println("\t2 - Dog");
        System.out.println("\t3 - Robotic Cat");
        System.out.println("\t4 - Robotic Dog");
        int type = input.nextInt();
        input.nextLine();
        return type;
    }

    private static String askPetDescription() {
        System.out.println("Please enter pet's description:");
        return input.nextLine();
    }

    private static String askPetName() {
        System.out.println("Please enter pet's name:");
        return input.nextLine();
    }

    private static void showPets() {
        int i = 1;
        for (VirtualPet pet : pets)
            if (pet instanceof Organic) {
                System.out.println("(" + i + ") " + pet.getName() + " (" + pet.getType() + ")\n" +
                        "\tHealth: " + pet.getHealth() +
                        "\tHappiness: " + pet.getHappiness() +
                        "\tHunger: " + ((Organic) pet).getHunger() +
                        "\t\tThirst: " + ((Organic) pet).getThirst() +
                        "\t\tCage Cleanliness: " + ((Organic) pet).getHunger() + "\n");
                i++;
            } else if (pet instanceof Robotic) {
                System.out.println("(" + i + ") " + pet.getName() + " (" + pet.getType() + ")\n" +
                        "\tHealth: " + pet.getHealth() +
                        "\tHappiness: " + pet.getHappiness() +
                        "\tOil Level: " + ((Robotic) pet).getOilLevel() +
                        "\tMaintenance Needs: " + ((Robotic) pet).getMaintenanceNeeds() + "\n");
                i++;
            }
    }

    private static void generatePets() {
        shelter.addPet(new Cat("Neko",
                "Neko is a cute cat."));
        shelter.addPet(new Dog("Rover",
                "Neko is a young puppy."));
        shelter.addPet(new RoboticDog("Termus",
                "Neko is a robotic dog."));
        shelter.addPet(new RoboticCat("Machina",
                "Neko is a robotic cat."));
    }

    private static void welcome() {
        System.out.println("Hi and welcome to the virtual pet shelter.");
    }


}
