package HW4;
public class Frog {
    private String name;
    private int age;
    private double tongueSpeed;
    private boolean isFroglet;
    private static String species = "Rare Pepe";

    // 构建constructor
    public Frog(String name, int age, double tongueSpeed) {
        this.name = name;
        this.age = age;
        this.tongueSpeed = tongueSpeed;
        this.isFroglet = (this.age > 1 && this.age < 7);
    }

    public Frog(String name, double ageInYears, double tongueSpeed) {
        this(name, (int) (ageInYears * 12), tongueSpeed);
    }

    public Frog(String name) {
        this(name, 5, 5.0);
    }

    // 构建getter和setter
    public static String getSpecies() {
        return species;
    }

    public static void setSpecies(String newSpecies) {
        species = newSpecies;
    }

    public void setFroglet() {
        this.isFroglet = (this.age > 1 && this.age < 7);
    }

    // 构建method
    public void grow(int addMonths) {
        int originalAge = this.age;
        int newAge = originalAge + addMonths;
        for (int i = originalAge; i < newAge; i++) {
            if (i < 12) {
                this.age++;
                this.tongueSpeed++;
            } else if (i >= 30) {
                this.tongueSpeed = Math.max(this.tongueSpeed - 1, 5);
            }
        }
        setFroglet();
    }

    public void grow() {
        grow(1);
    }

    public void eat(Fly fly) {
        if (fly.isDead() == true) {
            return;
        }
        if (this.tongueSpeed > fly.getSpeed()) {
            if (fly.getMass() >= 0.5 * this.age) {
                grow();
                fly.setMass(0);
            }
        } else {
            fly.grow(1);
            ;
        }
    }

    public String toString() {
        if (this.isFroglet == true) {
            return String.format("My name is %s and I'm a rare froglet! I'm %d months old and my tongue has a speed of %.2f.",name,age,tongueSpeed);
        } else {
            return String.format("My name is %s and I'm a rare frog! I'm %d months old and my tongue has a speed of %.2f.",name,age,tongueSpeed);
        }

    }


}