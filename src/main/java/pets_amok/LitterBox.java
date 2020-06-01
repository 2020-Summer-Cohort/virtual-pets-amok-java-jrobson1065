package pets_amok;

public class LitterBox {

    private int cleanliness;

    public LitterBox() {
        this.cleanliness = 10;
    }

    public int getCleanliness() {
        return cleanliness;
    }

    public void useLitterBox() {
        cleanliness -= 1;
    }

    public void cleanLitterBox() {
        cleanliness = 10;
    }
}
