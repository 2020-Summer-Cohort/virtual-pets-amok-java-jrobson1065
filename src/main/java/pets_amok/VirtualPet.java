package pets_amok;

import java.util.Random;

public abstract class VirtualPet {
    public Random rand = new Random();
    protected int happiness;
    protected int health;
    protected int attention;
    private String name;
    private String description;
    protected String type;

    public VirtualPet(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public abstract void tick();
    public abstract void walk();
    public abstract void play();

    public int getHappiness(){
        return happiness;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }
}
