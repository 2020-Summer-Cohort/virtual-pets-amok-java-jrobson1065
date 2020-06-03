package pets_amok;

import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Scanner;

// -While you did right by finishing the application rather than get stuck on tests, we want to see test coverage for the application,
// particularly for the Shelter class

// -Need to see user choices you have commented out working

// -Your VirtualPet class hierarchy could be improved. Whenever you see duplicate code like in your Cat and Dog classes, that's an opportunity
// to create a common parent class that contains your hunger, thirst, and boredom fields in addition to shared methods

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
            optionMenu();
            actions();
        }
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
        System.out.println("\t9 - Quit");
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
//            case 4:
//                playOptions();
//                break;
//            case 5:
//                oilOptions();
//                break;
//            case 6:
//                cleanCageOptions();
//                break;
//            case 7:
//                adoptOptions();
//                break;
//            case 8:
//                admitOptions();
//                break;
            case 9:
                System.exit(0);
        }
    }

    private static void showOrganicPets() {
        for (VirtualPet pet : pets)
            if(pet instanceof Organic) {
                System.out.println(pet.getName());
            }
    }

    private static void showRoboticPets() {
        for (VirtualPet pet : pets)
            if(pet instanceof Robotic) {
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

    private static void showPets() {
        for (VirtualPet pet : pets)
            if (pet instanceof Organic) {
                System.out.println(pet.getName() + " (" + pet.getType() + ")\n" +
                        "\tHealth: " + pet.getHealth() +
                        "\tHappiness: " + pet.getHappiness() +
                        "\tHunger: " + ((Organic) pet).getHunger() +
                        "\t\tThirst: " + ((Organic) pet).getThirst() +
                        "\t\tCage Cleanliness: " + ((Organic) pet).getHunger());
            } else if (pet instanceof Robotic) {
                System.out.println(pet.getName() + " (" + pet.getType() + ")\n" +
                        "\tHealth: " + pet.getHealth() +
                        "\tHappiness: " + pet.getHappiness() +
                        "\tOil Level: " + ((Robotic) pet).getOilLevel() +
                        "\tMaintenance Needs: " + ((Robotic) pet).getMaintenanceNeeds());
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
