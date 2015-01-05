import java.util.*;

public BaseChar {

    private int health;
    private int speed;
    private int defense;
    private int strength;
    private int magic;
    private String name;
    private Random r;

    public Basechar {
        r = new Random();
	health = 100;
	speed = randomValue(5, 10);
	defense = randomValue(5, 10);
	strength = randomValue(5, 10);
	magic = randomValue(5, 10);
    }

    public int getHealth() {
	return health;
    }

    public int getSpeed() {
	return speed;
    }

    public int getDefense() {
	return defense;
    }

    public int getStrength() {
	return strength;
    }

    public int getMagic() {
	return magic;
    }

    public void setHealth(int value) {
	this.health = value;
    }

    public void setSpeed(int value) {
	this.speed = value;
    }

    public void setDefense(int value) {
	this.defense = value;
    }

    public void setStrength(int value) {
	this.strength = value;
    }

    public void setMagic(int value) {
	this.magic = value;
    }

    public String status(){
	String s = name + "'s Status\n";
	s += "Health:  " + health + "\n";
	s += "Speed:   " + speed + "\n";
	s += "Defense: " + defense + "\n";
	s += "Strength:" + strength + "\n";
        s += "Magic:   " + magic;
	return s;
    }

    public String punch(BaseChar opponent) {
	if (randomValue(0,100) >= 95) {
	    int newHealth = o
	} else {
	    s = "You missed" + opponent;
	}
    }
  
    
}
