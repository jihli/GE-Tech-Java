import java.util.Random;

public class Die {
    public static final int SIDES = 6;
    private int faceValue;
    private Random rand;

    // constructor
    public Die() {
        faceValue = 1;
        rand = new Random();
    }

    // method
    public int roll() {
        faceValue = rand.nextInt(SIDES) + 1;
        return faceValue;
    }

    // getter
    public int getFaceValue() {
        return faceValue;
    }

    public String toString() {
        return "Die with face value: " + faceValue;
    }

    // main method
    public static void main(String[] args) {
        Die die1 = new Die();

        System.out.println(die1.toString());
        System.out.println(die1.roll());
        System.out.println(die1.roll());
    }
}
