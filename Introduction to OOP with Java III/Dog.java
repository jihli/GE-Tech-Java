/**
 * A Dog class that inherits traits from the Pet class
 */
public class Dog extends Pet {
    private double droolRate;

    /**
     * Constructor for a Dog with specified name, health, painLevel, and droolRate
     *
     * @param name the name of the Dog
     * @param health the health of the Dog
     * @param painLevel the pain level of the Dog
     * @param droolRate the droolRate of the Dog
     */
    public Dog(String name, double health, int painLevel, double droolRate) {
        super(name, health, painLevel);
        this.droolRate = (droolRate <= 0) ? 0.5 : droolRate;
    }

    /**
     * Constructor for a Dog with a specified name, health, and painLevel
     * Sets the droolRate to a default value of 5.0
     *
     * @param name the name of the Dog
     * @param health the health of the Dog
     * @param painLevel the pain level of the Dog
     */
    public Dog(String name, double health, int painLevel) {
        this(name, health, painLevel, 5.0);
    }

    /**
     * An accessor for the droolRate of the Dog
     *
     * @return the droolRate of the Dog
     */
    public double getDroolRate() {
        return droolRate;
    }

    /**
     * Method that treats the Dog to full health
     *
     * @return the time in minutes it takes to treat the Dog
     */
    public int treat() {
        int treatmentTime;
        if (droolRate < 3.5) {
            treatmentTime = (int) Math.ceil((getPainLevel() * 2) / getHealth());
        } else if (droolRate <= 7.5) {
            treatmentTime = (int) Math.ceil(getPainLevel() / getHealth());
        } else {
            treatmentTime = (int) Math.ceil(getPainLevel() / (getHealth() * 2));
        }
        heal();
        return treatmentTime;
    }

    /**
     * The Dog introduces itself. Shouts if its in great pain
     */
    public void speak() {
        super.speak();
        String sound = (getPainLevel() > 5) ? "BARK " : "bark ";
        String output = "";
        for (int i = 1; i <= getPainLevel(); i++) {
            output += sound;
        }
        System.out.println(output.trim());
    }

    /**
     * Determines whether two Dogs are equal through name and droolRate
     *
     * @param o an Object to compare with the Dog
     * @return whether the Dog and the object are equal
     */
    public boolean equals(Object o) {
        return super.equals(o) && ((Dog) o).droolRate == droolRate;
    }
}
