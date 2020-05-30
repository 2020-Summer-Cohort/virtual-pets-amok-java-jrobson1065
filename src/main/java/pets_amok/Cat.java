package pets_amok;

public class Cat extends VirtualPet implements Organic {

    private int hunger;
    private int cageCleanliness;
    private int waste;
    private int thirst;

    public Cat(String name, String description) {
        super(name, description);
        this.hunger = rand.nextInt(5) + 3;
        this.cageCleanliness = rand.nextInt(5) + 3;
        this.attention = rand.nextInt(5) + 3;
        this.thirst = rand.nextInt(5) + 3;
        this.health = 10 - (((((20 - hunger) - (10 -thirst)) / 2) + cageCleanliness) / 2);
        this.happiness = (health + attention) / 2;
        this.type = "Cat";
    }

    @Override
    public int tick() {
        hunger += 1;
        cageCleanliness -= 1;
        attention -= 1;
        return getWaste();
    }

    @Override
    public void walk() {
        System.out.println(getName() + " is a cat and was let outside to walk around.");
    }

    @Override
    public void feed() {
        System.out.println(getName() + " was feed and is happy now.");
        hunger -= 3;
        cageCleanliness -= 1;
    }

    @Override
    public void water() {
        thirst -= 3;
        cageCleanliness -= 1;
    }

    @Override
    public void cleanCage() {
        cageCleanliness += 3;
    }

    @Override
    public int getHunger() {
        return hunger;
    }

    @Override
    public int getThirst() {
        return thirst;
    }

    @Override
    public int getCageCleanliness() {
        return cageCleanliness;
    }

    @Override
    public int getWaste() {
        return waste;
    }
}
