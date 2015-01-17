import java.io.*;
import java.util.*;

public abstract class BaseChar implements Serializable {

    private int level;
    private int experience;
    private int maxhealth;
    private int health;
    private int speed;
    private int defense;
    private int attack;
    private String name;
    private String type;
    private String weakness;
    private String resistance;
    private String[] moves = new String[4];
    private int[] PP = new int[4];
    private Random r = new Random();

    public BaseChar() {
	level = 1;
	experience = 0;
	maxhealth = 20;
	health = 20;
	speed = r.nextInt(5)+5;
	defense = r.nextInt(5)+5;
	attack = r.nextInt(5)+5;
	setMove(0,"TACKLE");
	setPP(0,35);
    }

    public String toString() {
	return name;
    }

    public int getLevel() {
	return level;
    }

    public int getExperience() {
	return experience;
    }

    public int getMaxHealth() {
	return maxhealth;
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

    public String getType() {
	return type;
    }

    public String getWeakness() {
	return weakness;
    }

    public String getResistance() {
	return resistance;
    }

    public String[] getMoves() {
	return moves;
    }

    public int[] getPP() {
	return PP;
    }

    public void setLevel(int value) {
	level = value;
    }

    public void setExperience(int value) {
	experience = value;
    }

    public void setHealth(int value) {
	health = value;
    }

    public void setSpeed(int value) {
	speed = value;
    }

    public void setDefense(int value) {
	defense = value;
    }

    public void setAttack(int value) {
	attack = value;
    }
    
    public void setType(String s) {
	type = s;
    }

    public void setWeakness(String s) {
	weakness = s;
    }

    public void setResistance(String s) {
	resistance = s;
    }

    public void setName(String s) {
	name = s;
    }

    public void setMove(int pos, String move) {
	moves[pos] = move;
    }

    public void setPP(int pos, int n) {
	 PP[pos] = n;
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
	//locating PP to attack
	int n = 0;
	while (n < this.nummoves() && moves[n] != "TACKLE") {
	    n = n + 1;
	}
	//the attack
	String s ="";
	if (r.nextInt(100) <= 95 && this.getPP()[n] > 0) {
	    int modifier = 1;
	    int crit = r.nextInt(10);
	    if (crit == 0) {
		modifier = modifier * 2;
	    }
	    int newHealth = opponent.getHealth() -
		(damage(opponent,50) * modifier);;
	    opponent.setHealth(newHealth);
	    s = this + " used TACKLE!";
	    if (crit == 0) {
		modifier = modifier * 2;
		s = s + "\nIt's a critical hit!";
	    }
	} else {
	    if (this.getPP()[n] == 0) {
		s = this + " has no more PP for TACKLE!";
	    } else {
		s = this + " used TACKLE! But it missed!";
	    }
	}
	//subtracting PP
	if (this.getPP()[n] > 0) {
	    int newPP = this.getPP()[n] - 1;
	    this.setPP(n,newPP);
	}
	return s;
    }

    /*
    public String recover() {
	//locating PP to attack
	int n = 0;
	while (n < this.nummoves() && moves[n] != "RECOVER") {
	    n = n + 1;
	}
	//the attack
	String s ="";
	if (r.nextInt(100) <= 95 && this.getPP()[n] > 0 &&
	    (this.getHealth() + (this.getHealth()/4)) <= this.getMaxHealth()) {
	    int newHealth = this.getHealth() + (this.getHealth()/4);
	    this.setHealth(newHealth);
	    s = this + " used RECOVER!";
	} else {
	    if (this.getPP()[n] == 0) {
		s = this + " has no more PP for RECOVER!";
	    } else {
		s = this + " used RECOVER! But it failed!";
	    }
	}
	//subtracting PP
	if (this.getPP()[n] > 0) {
	    int newPP = this.getPP()[n] - 1;
	    this.setPP(n,newPP);
	}
	return s;
    }
    */

    public String moveset() {
	String s = moves[0] + "  " + PP[0] + "\n";
	if (moves[1] != null) {
	    s = s + "\n" + moves[1] + PP[1];
	}
	if (moves[2] != null) {
	    s = s + "\n" + moves[2] + PP[2];
	}
	if (moves[3] != null) {
	    s = s + "\n" + moves[3] + PP[3];
	}
	return s;	    
    }

    public int nummoves() {
	int n = 1;
	if (moves[1] != null) {
	    n = n + 1;
	}
	if (moves[2] != null) {
	    n = n + 1;
	}
	if (moves[3] != null) {
	    n = n + 1;
	}
	return n;
    }
	
    
}
