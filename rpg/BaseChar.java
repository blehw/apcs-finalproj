import java.util.*;

public class BaseChar {

    private int level;
    private int experience;
    private int health;
    private int speed;
    private int defense;
    private int attack;
    private String name;
    private Random r;

    public BaseChar() {
        r = new Random();
	level = 1;
	experience = 0;
	health = 20;
	speed = r.nexInt(5, 10);
	defense = r.nexInt(5, 10);
	attack = r.nexInt(5, 10);
	magic = r.nexInt(5, 10);
    }

    public int getLevel() {
	return level;
    }

    public int getExperience() {
	return experience;
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

    public int getAttack() {
	return attack;
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

    public void setAttack(int value) {
	this.attack = value;
    }

    public String status(){
	String s = name + "'s Status\n";
	s += "Health:  " + health + "\n";
	s += "Speed:   " + speed + "\n";
	s += "Defense: " + defense + "\n";
	s += "Attack:  " + attack + "\n";
	return s;
    }

    public int damage(BaseChar opponent, int base) {
	return ((((2* this.getLevel() + 10)/250) *
		(this.getAttack()/opponent.getDefense()) *
		 base) + 2);
    }

    public String tackle(BaseChar opponent) {
	String s ="";
	if (randomValue(0,100) <= 95) {
	    int newHealth = opponent.getHealth() - 50;
	    opponent.setHealth(newHealth);
	    s = this + " used TACKLE!";
	    
	} else {
	    s = this + " used TACKLE! But it missed!";
	}
	return s;
    }

    public String recover() {
	String s ="";
	if (random(0,100) <= 95) {
	    int newHealth = this.getHealth() + (this.getHealth()/4);
	    s = this + " used RECOVER!";
	} else {
	    s = this + " used RECOVER! But it failed!"; 
	}
	return s;
    }
    
}
