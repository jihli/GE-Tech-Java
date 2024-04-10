package HW5;
/**
 * This class represents the Player class in the Amidst Us game.
 * It will represent a player in the game
 * 
 * @author CS 1331 TAs
 * @version 1.1
 */
public abstract class Player implements Comparable<Player> {
    private String name;
    private int susLevel;
    private boolean frozen;
    private static Player[] players;

    /**
     * Constructor for Player Objects. Be sure to use this constructor, as it
     * properly populates the players array.
     * The logic in this constructor ensures that players is always full, although
     * frozen players will still be in it.
     * NOTE: Use getPlayers() each time you need it, since the reference will change
     * with every new instance.
     */
    public Player(String name, int susLevel) {
        this.name = name;
        if (susLevel >= 0) {
            this.susLevel = susLevel;
        } else {
            this.susLevel = 0;
        }
        if (players == null) {
            players = new Player[1];
            players[0] = this;
        } else {
            int length = players.length + 1;
            Player[] temp = players;
            players = new Player[length];
            for (int i = 0; i < temp.length; i++) {
                players[i] = temp[i];
            }
            players[players.length - 1] = this;
        }
    }

    /**
     * This method is an abstract method called emergencyMeeting.
     * This method will be overridden by any child class and will be used to have an
     * emergency meeting.
     */
    public abstract void emergencyMeeting();

    /**
     * This method is the compareTo method from the Comparable interface.
     * It will compare two Player objects based on their susLevel
     */
    @Override
    public int compareTo(Player p) {
        return Integer.compare(this.susLevel, p.susLevel);
    }

    /**
     * This is the equals method which tells you if two Players are equal
     */
    public boolean equals(Object o) {
        if (o instanceof Player) {
            Player player = (Player) o;
            return this.name.equals(player.name) && this.frozen == player.frozen
                    && this.susLevel == player.susLevel;
        }
        return false;
    }

    /**
     * This method overrides the toString method to specify what will be returned
     */
    public String toString() {
        String frozenString = frozen ? "frozen" : "not frozen";
        return "My name is " + this.name + ", and I have a susLevel of "
                + this.susLevel + ". I am currently " + frozenString + ".";
    }

    /**
     * This method tells you whether the game is over or not.
     * You will call this method in your frozen and emergencyMeeting methods.
     */
    public boolean gameOver() {
        int impostorCount = 0;
        int crewmateCount = 0;
        for (Player p : players) {
            if (p instanceof Impostor && !p.frozen) {
                impostorCount++;
            } else if (p instanceof Crewmate && !p.frozen) {
                crewmateCount++;
            }
        }
        if (impostorCount == 0) {
            System.out.println("Crewmates Win!");
            return true;
        } else if (impostorCount >= crewmateCount) {
            System.out.println("Impostors Win!");
            return true;
        }
        return false;
    }

    /**
     * This is the getter for the instance variable name
     */
    public String getName() {
        return name;
    }

    /**
     * This is the getter for the susLevel
     */
    public int getSusLevel() {
        return susLevel;
    }

    /**
     * This is the setter for susLevel. SusLevel is always a positive value.
     */
    public void setSusLevel(int susLevel) {
        if (susLevel >= 0) {
            this.susLevel = susLevel;
        } else {
            this.susLevel = 0;
        }
    }

    /**
     * This is the getter for frozen;
     */
    public boolean isFrozen() {
        return frozen;
    }

    /**
     * this is the setter for frozen.
     */
    public void setFrozen(boolean frozen) {
        this.frozen = frozen;
    }

    /**
     * This is the getter for the players array
     */
    public static Player[] getPlayers() {
        return players;
    }

}
