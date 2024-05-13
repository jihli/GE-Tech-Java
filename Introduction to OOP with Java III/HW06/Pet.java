package HW06;
/**
 * An abstract class for a Pet visiting a Clinic.
 */
public abstract class Pet {
    private String name;
    private double health;
    private int painLevel;

    /**
     * Constructor for a Pet object with a specified name, health, and pain level.
     * 
     * @param name      the pet's name
     * @param health    its health, which is a percentage value from 0.0 to 1.0
     * @param painLevel its level of pain from 1 to 10
     */
    public Pet(String name, double health, int painLevel) {
        this.name = name;
        if (health >= 1.0) {
            this.health = 1.0;
        } else if (health <= 0.0) {
            this.health = 0.0;
        } else {
            this.health = health;
        }
        if (painLevel >= 10) {
            this.painLevel = 10;
        } else if (painLevel <= 1) {
            this.painLevel = 1;
        } else {
            this.painLevel = painLevel;
        }
    }

    /**
     * Accessor for the name of the pet.
     * 
     * @return the name of the pet
     */
    public String getName() {
        return name;
    }

    /**
     * Accessor for the health of the pet.
     * 
     * @return the health of the pet
     */
    public double getHealth() {
        return health;
    }

    /**
     * Accessor for the level of pain the pet is in.
     * 
     * @return the pain level of the pet
     */
    public int getPainLevel() {
        return painLevel;
    }

    /**
     * Abstract method that provides a way for the pet to be treated.
     * 
     * @return the time in minutes it takes to treat the Pet
     */
    public abstract int treat();

    /**
     * The Pet introduces itself. Shouts if it is over a certain level of pain.
     */
    public void speak() {
        String output = String.format("Hello! My name is %s", name);
        output = (painLevel > 5) ? output.toUpperCase() : output;
        System.out.println(output);
    }

    /**
     * Protected method that heals the pet to full health with no pain.
     */
    protected void heal() {
        health = 1.0;
        painLevel = 1;
    }

    /**
     * An equals method that overrides the default equals method from Object.
     * Compares the name of the two pets.
     * 
     * @param o an object to compare with the Pet
     * @return whether the Pet and the object are equal
     */
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Pet)) {
            return false;
        }
        Pet pet2 = (Pet) o;
        return (pet2.name.equals(this.name));
    }
}
