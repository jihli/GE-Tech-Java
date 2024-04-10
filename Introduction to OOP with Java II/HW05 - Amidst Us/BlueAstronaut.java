package HW5;
import java.util.Arrays;

public class BlueAstronaut extends Player implements Crewmate {
    private int numTasks;
    private int taskSpeed;

    public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed) {
        super(name, susLevel);
        this.numTasks = numTasks;
        this.taskSpeed = taskSpeed;
    }

    public BlueAstronaut(String name) {
        this(name, 15, 6, 10);
    }

    @Override
    public void emergencyMeeting() {
        if (this.isFrozen() == true)
            return;

        Player[] players = Player.getPlayers();
        Arrays.sort(players);
        Player mostSus = null;

        for (int i = players.length - 1; i >= 0; i--) {
            if (!players[i].isFrozen()) {
                if (mostSus == null || players[i].getSusLevel() > mostSus.getSusLevel()) {
                    mostSus = players[i];
                } else if (players[i].getSusLevel() == mostSus.getSusLevel() && players[i] != this) {
                    return;
                }
            }
        }

        if (mostSus != null && mostSus != this) {
            mostSus.setFrozen(true);
        }

        if (this.gameOver())
            return;
    }

    @Override
    public void completeTask() {
        if (this.isFrozen())
            return;

        if (this.numTasks > 20) {
            this.numTasks = Math.max(0, this.numTasks - 2);
        } else {
            this.numTasks = Math.max(0, this.numTasks - 1);

        }

        if (numTasks == 0) {
            System.out.println("I have completed all my tasks");
            this.setSusLevel(this.getSusLevel() / 2);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof BlueAstronaut) {
            BlueAstronaut other = (BlueAstronaut) o;
            return (this.getName() == other.getName() && this.isFrozen() == other.isFrozen()
                    && this.getSusLevel() == other.getSusLevel() && this.numTasks == other.numTasks
                    && this.taskSpeed == other.taskSpeed);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        String base = String.format(
                "My name is %s, and I have a suslevel of %d. I am currently %s. I have %d left over.",
                this.getName(),
                this.getSusLevel(),
                this.isFrozen() ? "frozen" : "not frozen",
                numTasks);

        return this.getSusLevel() > 15 ? base.toUpperCase() : base;
    }

}
