/**
 * A Cat class that inherits traits from the Pet class
 */
public class Cat extends Pet {
    private int miceCaught;

    /**
     * Creates a Cat with a specified name, health, painLevel, and miceCaught
     *
     * @param name the name of the Cat
     * @param health the health of the Cat
     * @param painLevel the pain level of the Cat is in
     * @param miceCaught the number of mice caught
     */
    public Cat(String name, double health, int painLevel, int miceCaught) {
        super(name, health, painLevel);
        this.miceCaught = (miceCaught < 0) ? 0 : miceCaught;
    }

    /**
     * Creates a Cat with a specified name, health, and painLevel
     * Sets miceCaught to the default value of 0
     *
     * @param name the name of the Cat
     * @param health the health of the Cat
     * @param painLevel the pain level of the Cat is in
     */
    public Cat(String name, double health, int painLevel) {
        this(name, health, painLevel, 0);
    }

    /**
     * Accessor for the number of mice the Cat has caught
     *
     * @return the integer number of mice caught
     */
    public int getMiceCaught() {
        return miceCaught;
    }

    /**
     * A method that heals the Cat to full health
     *
     * @return the treatment time in minutes to treat the Cat
     */
    public int treat() {
        int treatmentTime;
        if (miceCaught < 4) {
            treatmentTime = (int) Math.ceil(getPainLevel()*2 / getHealth());
        } else if (miceCaught <= 7) {
            treatmentTime = (int) Math.ceil(getPainLevel() / (getHealth()));
        } else {
            treatmentTime = (int) Math.ceil(getPainLevel() / (getHealth() * 2));
        }
        heal();
        return treatmentTime;
    }

    /**
     * The Cat introduces itself. Shouts if it is in great pain.
     */
    public void speak() {
        super.speak();
        String sound = (getPainLevel() > 5) ? "MEOW " : "meow ";
        String output = "";
        for (int i = 1; i <= getMiceCaught(); i++) {
            output += sound;
        }
        System.out.println(output.trim());
    }

    /**
     * Determines whether two Cats are equal through name and miceCaught
     *
     * @param o an Object to compare with the Cat
     * @return a boolean representing if the two Objects are equal
     */
    public boolean equals(Object o) {
        return super.equals(o) && ((Cat) o).miceCaught == this.miceCaught;
    }
}
