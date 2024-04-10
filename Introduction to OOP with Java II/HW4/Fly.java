package HW4;
public class Fly {
    // 定义class的variable
    private double mass;
    private double speed;

    // 定义constructor chain
    public Fly() {
        this.mass = 5.0;
        this.speed = 10.0;
    }

    public Fly(double mass) {
        this.mass = mass;
        this.speed = 10.0;
    }

    public Fly(double mass, double speed) {
        this.mass = mass;
        this.speed = speed;
    }

    // 定义method
    // 定义getter
    public double getMass(){
        return this.mass;
    }

    public double getSpeed() {
        return this.speed;
    }

    // 定义setter
    public void setMass(double mass) {
        this.mass = mass;
    }

    public void setSpeed(double speed){
        this.speed = speed;
    }

    // 定义功能性method
    public String toString() {
        if (this.mass == 0) {
            return String.format("I'm dead, but I used to be a fly with a speed of %.2f.",this.speed);
        }  else {
            return String.format("I'm a speedy fly with %.2f speed and %.2f mass.",this.speed,this.mass);
        }
    }

    public void grow(int addMass){
        int originalMass = (int)this.mass;
        this.mass = originalMass + addMass;
        // 请注意这里的for loop的使用 有的时候addmass以后会使得mass大于20 而在mass大于20之前会遵循速度1单位的增加 然而在mass大于等于20之后会遵循0.5单位的减少 (时刻注意解题的理解语义)
        for (int i = originalMass; i < (int) mass; i++){
            if (i<20){
                this.speed ++;
            } else {
                this.speed -=0.5;
            }
        }
    }

    public boolean isDead() {
        if (this.mass == 0) {
            return true;
        } else{
            return false;
        }
    }


    // 定义主程序
    public static void main(String[] args) {
        Fly fly1 = new Fly();
        System.out.println(fly1.mass);
        System.out.println(fly1.toString());
        fly1.grow(5);
        System.out.println(fly1.mass);
        System.out.println(fly1.toString());
        fly1.grow(15);
        System.out.println(fly1.mass);
        System.out.println(fly1.toString());
    }

}