package HW4;
public class Pond {
    public static void main(String[] args) {
        Frog.setSpecies("1331 Frogs");

        Frog peepo = new Frog("Peepo");
        Frog pepe = new Frog("Pepe", 10, 15);
        Frog peepaw = new Frog("Peepaw", 4.6, 5);
        Frog yourFrog = new Frog("YourFrogName", 12, 10); // 自定义青蛙

        Fly fly1 = new Fly(1, 3);
        Fly fly2 = new Fly(6);
        Fly fly3 = new Fly(2, 5); // 自定义苍蝇

        System.out.println(peepo);
        peepo.eat(fly2);
        System.out.println(fly2);
        peepo.grow(8);
        peepo.eat(fly2);
        System.out.println(fly2);
        System.out.println(peepo);
        System.out.println(yourFrog);
        peepaw.grow(4);
        System.out.println(peepaw);
        System.out.println(pepe);
    }
}
