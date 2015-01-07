import java.util.*;

public class BaseChar {

    private int level;
    private int experience;
    private int health;
    private int speed;
    private int defense;
    private int attack;
    private String name;
    private Random r = new Random();

    public BaseChar() {
	level = 1;
	experience = 0;
	health = 20;
	speed = r.nextInt(5)+5;
	defense = r.nextInt(5)+5;
	attack = r.nextInt(5)+5;
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
	if (r.nextInt(100) <= 95) {
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
	if (r.nextInt(100) <= 95) {
	    int newHealth = this.getHealth() + (this.getHealth()/4);
	    s = this + " used RECOVER!";
	} else {
	    s = this + " used RECOVER! But it failed!"; 
	}
	return s;
    }
    
}
