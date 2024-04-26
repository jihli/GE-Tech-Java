public class Dog extends Pet {
    private double droolRate;

    public Dog(String name, double health, int painLevel, double droolRate) {
        super(name, health, painLevel);
        this.droolRate = droolRate <= 0 ? 0.5 : droolRate;
    }

    public Dog(String name, double health, int painLevel) {
        this(name, health, painLevel, 5.0); // Default droolRate set to 5.0
    }

    public double getDroolRate() {
        return droolRate;
    }

    @Override
    public int treat() {
        heal(); // Call the heal method from Pet class
        double treatmentTime;
        if (droolRate < 3.5) {
            treatmentTime = (getPainLevel() * 2) / getHealth();
        } else if (droolRate <= 7.5) {
            treatmentTime = getPainLevel() / getHealth();
        } else {
            treatmentTime = getPainLevel() / (getHealth() * 2);
        }
        return (int) Math.ceil(treatmentTime); // Rounds up to the nearest whole minute
    }

    @Override
    public void speak() {
        super.speak(); // Calls the speak method from Pet class
        StringBuilder barks = new StringBuilder();
        for (int i = 0; i < getPainLevel(); i++) {
            barks.append("bark ");
        }
        if (getPainLevel() > 5) {
            System.out.println(barks.toString().trim().toUpperCase()); // UPPERCASE if painLevel > 5
        } else {
            System.out.println(barks.toString().trim());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false; // First check the base Pet equality
        if (!(o instanceof Dog)) return false;
        Dog dog = (Dog) o;
        return Double.compare(dog.droolRate, droolRate) == 0;
    }

    @Override
    public int hashCode() {
        return super.hashCode() * 31 + Double.hashCode(droolRate);
    }
}
