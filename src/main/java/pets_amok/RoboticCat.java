package pets_amok;

public class RoboticCat extends VirtualPet implements Robotic{

    private int oilLevel;
    private int maintenanceNeeds;

    public RoboticCat(String name, String description) {
        super(name, description);
        this.oilLevel = rand.nextInt(5)+3;
        this.maintenanceNeeds = rand.nextInt(5)+3;
        this.attention = rand.nextInt(5)+3;
        this.health = 10 - (((10 - maintenanceNeeds) + oilLevel) / 2);
        this.happiness = (health + attention) / 2;
        this.type = "Robotic Cat";
    }

    @Override
    public void tick() {
        oilLevel -= 1;
        maintenanceNeeds += 1;
        attention -= 1;
    }

    @Override
    public void walk() {
        System.out.println(getName() + " is a robotic cat and wasn't put on a leash.");
        attention += 3;
        maintenanceNeeds += 1;
    }

    @Override
    public void oil() {
        System.out.println(getName() + "'s oil was filled and now feels great.");
        maintenanceNeeds -= 2;
        oilLevel += 3;
    }

    @Override
    public void play() {
        attention += 3;
        oilLevel -= 1;
        maintenanceNeeds += 1;
    }

    @Override
    public int getOilLevel() {
        return oilLevel;
    }

    @Override
    public int getMaintenanceNeeds() {
        return maintenanceNeeds;
    }
}
