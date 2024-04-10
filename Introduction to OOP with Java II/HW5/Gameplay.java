package HW5;
public class Gameplay {

    public static void main(String[] args) {
        BlueAstronaut bob = new BlueAstronaut("Bob", 20, 6, 30);
        BlueAstronaut heath = new BlueAstronaut("Heath", 30, 3, 21);
        BlueAstronaut albert = new BlueAstronaut("Albert", 44, 2, 0);
        BlueAstronaut angel = new BlueAstronaut("Angel", 0, 1, 0);

        RedAstronaut liam = new RedAstronaut("Liam", 19, "experienced");
        RedAstronaut suspiciousPerson = new RedAstronaut("Suspicious Person", 100, "expert");

        liam.sabotage(bob);
        System.out.println(bob); // Bob's susLevel should be 30

        liam.freeze(suspiciousPerson);
        // Nothing should happen because suspiciousPerson is also an impostor

        liam.freeze(albert);
        // Albert should now be frozen
        System.out.println(albert.isFrozen()); // true

        albert.emergencyMeeting();
        // Nothing should happen because Albert is frozen

        suspiciousPerson.emergencyMeeting();
        // This will result in a tie between Bob and Heath, so nothing should happen

        bob.emergencyMeeting();
        // SuspiciousPerson should now be frozen
        System.out.println(suspiciousPerson.isFrozen()); // true

        heath.completeTask();
        System.out.println(heath); // Heath's numTasks should be 1

        heath.completeTask();
        // "I have completed all my tasks" should be printed to console
        // Heath's susLevel should be halved
        System.out.println(heath); // Heath's numTasks should be 0, susLevel should be 15

        heath.completeTask();
        // Nothing should happen because Heath has no tasks left

        liam.freeze(angel);
        // Angel should still not be frozen since Liam's susLevel is higher than Angel's
        System.out.println(angel.isFrozen()); // false
        System.out.println(liam); // Liam's susLevel should be 38

        liam.sabotage(bob);
        liam.sabotage(bob);
        // Bob's susLevel should increase to 46 after two sabotages
        System.out.println(bob); // Bob's susLevel should be 46

        liam.freeze(bob);
        // Bob should now be frozen
        System.out.println(bob.isFrozen()); // true

        // Scenario 1: Angel calls an emergency meeting
        angel.emergencyMeeting();
        // Liam should be frozen and "Crewmates win!" should be printed to console

        // Scenario 2: Liam continues to sabotage
        // (uncomment the following lines to run the scenario)
        // for (int i = 0; i < 5; i++) {
        //     liam.sabotage(heath);
        // }
        // liam.freeze(heath);
        // "Impostors win!" should be printed to console
    }
}
