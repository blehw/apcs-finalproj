import java.io.*;
import java.util.*;

public abstract class BaseChar implements Serializable {

    private int stage;
    private int level;
    private int experience;
    private int maxhealth;
    private int health;
    private int maxspeed;
    private int speed;
    private int maxdefense;
    private int defense;
    private int maxattack;
    private int attack;
    private String name;
    private String type;
    private String weakness;
    private String resistance;
    private String[] moves = new String[4];
    private int[] maxPP = new int[4];
    private int[] PP = new int[4];
    private Random r = new Random();

    public BaseChar() {
	level = 1;
	experience = 0;
	maxhealth = 20;
	health = maxhealth;
	maxspeed = r.nextInt(5)+5;
	speed = maxspeed;
	maxdefense = r.nextInt(5)+5;
	defense = maxdefense;
	maxattack = r.nextInt(5)+5;
	attack = maxattack;
	setMove(0,"TACKLE");
	setMaxPP(0,35);
	setPP(0,getMaxPP()[0]);
	setStage(1);
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

    public int getMaxSpeed() {
	return maxspeed;
    }

    public int getSpeed() {
	return speed;
    }

    public int getMaxDefense() {
	return maxdefense;
    }

    public int getDefense() {
	return defense;
    }

    public int getMaxAttack() {
	return maxattack;
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

    public int[] getMaxPP() {
	return maxPP;
    }

    public int[] getPP() {
	return PP;
    }

    public int getStage() {
	return stage;
    }

    public void setLevel(int value) {
	level = value;
    }

    public void setExperience(int value) {
	experience = value;
    }

    public void setMaxSpeed(int value) {
	maxspeed = value;
    }

    public void setSpeed(int value) {
	speed = value;
    }

    public void setMaxHealth(int value) {
	maxhealth = value;
    }

    public void setHealth(int value) {
	health = value;
    }

    public void setMaxDefense(int value) {
	maxdefense = value;
    }

    public void setDefense(int value) {
	defense = value;
    }

    public void setMaxAttack(int value) {
	maxattack = value;
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

    public void setMaxPP(int pos, int n) {
	maxPP[pos] = n;
    }

    public void setPP(int pos, int n) {
	 PP[pos] = n;
    }

    public void setStage(int s){
	stage = s;
    }

    public String status(){
	String s = name + "'s Status\n";
	s += "Health:  " + health + "/" + maxhealth + "\n";
	s += "Speed:   " + speed + "\n";
	s += "Defense: " + defense + "\n";
	s += "Attack:  " + attack + "\n";
	return s;
    }

    public int damage(BaseChar opponent, int base) {
	return ((2 * level + 10) * attack * base * (r.nextInt(16) + 85))
	    /(250 * defense * 100) + 2;
    }

    public String moveMaker(BaseChar opponent, String move, 
			    String type, int power, int acc) {
	//locating PP to attack
	int n = 0;
	while (n < this.nummoves() && !moves[n].equals(move)) {
	    n = n + 1;
	}
	//the attack
	String s ="";
	if (r.nextInt(100) <= acc && this.getPP()[n] > 0) {
	    int modifier = 1;
	    int crit = r.nextInt(10);
	    if (crit == 0) {
		modifier = modifier * 2;
	    }
	    if (opponent.getWeakness().equals(type)) {
		modifier = modifier * 2;
	    }
	    int newHealth = opponent.getHealth() -
		(damage(opponent,power) * modifier);
	    if (opponent.getResistance().equals(type)) {
		newHealth = opponent.getHealth() -
		    (damage(opponent,power) * modifier/2);
	    }
	    if (this.getType().equals(type)) {
		newHealth = opponent.getHealth() -
		    (damage(opponent,power) * modifier * 3/2);
	    }
	    opponent.setHealth(newHealth);
	    s = this + " used " + move + "!";
	    if (crit == 0) {
		s = s + "\nIt's a critical hit!";
	    }
	} else {
	    if (this.getPP()[n] == 0) {
		s = this + " has no more PP for " + move + "!";
	    } else {
		s = this + " used " + move + "! But it missed!";
	    }
	}
	//subtracting PP
	if (this.getPP()[n] > 0) {
	    int newPP = this.getPP()[n] - 1;
	    this.setPP(n,newPP);
	}
	return s;
    }

    public String tackle(BaseChar opponent) {
	return moveMaker(opponent,"TACKLE","Normal",35,95);
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

    public void learnMoves() {

    }

    public boolean useMove(String move, BaseChar opponent) {
	return false;
    }

    public String moveset() {
	String s = moves[0] + " " + PP[0] + "/" + maxPP[0];
	if (moves[1] != null) {
	    s = s + "\n" + moves[1] + " " + PP[1] + "/" + maxPP[1];
	}
	if (moves[2] != null) {
	    s = s + "\n" + moves[2] + " " + PP[2] + "/" + maxPP[2];
	}
	if (moves[3] != null) {
	    s = s + "\n" + moves[3] + " " + PP[3] + "/" + maxPP[3];
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
