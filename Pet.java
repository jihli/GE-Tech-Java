public abstract class Pet {
    private String name;
    private double health;
    private int painLevel;

    public Pet(String name, double health, int painLevel) {
        this.name = name;
        this.health = Math.min(Math.max(health, 0.0), 1.0); // Ensures health is between 0.0 and 1.0
        this.painLevel = Math.min(Math.max(painLevel, 1), 10); // Ensures pain level is between 1 and 10
    }

    public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }

    public int getPainLevel() {
        return painLevel;
    }

    /**
     * Abstract method to calculate the time it takes to treat the pet.
     * 
     * @return the treatment time in minutes
     */
    public abstract int treat();

    public void speak() {
        String message = "Hello! My name is " + name;
        if (painLevel > 5) {
            message = message.toUpperCase();
        }
        System.out.println(message);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Pet))
            return false;
        Pet pet = (Pet) o;
        return name.equals(pet.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    protected void heal() {
        health = 1.0;
        painLevel = 1;
    }
}
