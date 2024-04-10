package HW5;
import java.util.Arrays;

public class RedAstronaut extends Player implements Impostor {
    private String skill;

    public RedAstronaut(String name, int susLevel, String skill) {
        super(name, susLevel);
        this.skill = skill;
    }

    public RedAstronaut(String name) {
        this(name, 15, "experienced");
        // 请注意这里我是不可以写 this.name = name 的
        // 因为name不是RedAstronaut的variable而是Player的 所以this.skill是可以的 但是this.name不可以
    }

    public String getSkill() {
        return this.skill;
    }

    @Override
    public void emergencyMeeting() {
        if (this.isFrozen() == true) {
            return;
        }
        Player[] players = Player.getPlayers();
        Arrays.sort(players, (p1, p2) -> p2.getSusLevel() - p1.getSusLevel()); // 按照susLevel进行降序排列

        Player mostSuspect = null;
        boolean foundTie = false;
        for (int i = 0; (i < players.length - 1) && (!players[i].isFrozen()); i++) { //这里开始遍历players array
            if (players[i] != this) { //这里明确这个元素不能是自己
                if (players[i].getSusLevel() == players[i + 1].getSusLevel()) {  //这里是开始判断是否有tie的情况
                    foundTie = true;
                    break;
                } else if (mostSuspect == null) { //当没有tie的情况时 就设置mostSuspect
                    mostSuspect = players[i];
                    break;
                }
            }
        }

        if (!foundTie && mostSuspect != null){ //这里完成了对mostSuspect的freeze
            mostSuspect.setFrozen(true);
        }
        this.gameOver();
    }

    @Override
    public void freeze(Player P){
        if (this.isFrozen() || P.isFrozen() ||P instanceof Impostor || this == P) return;
        if (this.getSusLevel() < P.getSusLevel()) {
            P.setFrozen(true);
        } else {
            this.setSusLevel(this.getSusLevel()*2);
        }
        this.gameOver();
        }
    
    @Override
    public void sabotage(Player P){
        if (P instanceof Impostor || this.isFrozen() || P.isFrozen()) return;
        if (this.getSusLevel() < 20) {
            P.setSusLevel((int)  (P.getSusLevel() *1.50));
        } else {
            P.setSusLevel((int)  (P.getSusLevel() *1.25));
        }
    }

    @Override 
    public boolean equals (Object o){
        if(this == o) return true;//这里判断是否指向同一个内存
        if (o == null || getClass() != o.getClass()) return false; //这里是判断是否为空 并且是否是同一类型
        RedAstronaut that = (RedAstronaut) o;
        return (this.getName() == that.getName())&& (this.isFrozen() == that.isFrozen())&& (this.getSusLevel() == that.getSusLevel())&&(this.getSkill() == that.getSkill()) ;
    }

    @Override 
    public String toString() {
        String base = super.toString() + " I am an " + this.skill + " player.";
        return this.getSusLevel() >15 ? base.toUpperCase() : base;
    }

    }