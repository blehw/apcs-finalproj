import java.util.*;

public class BaseChar {

    private int level;
    private int experience;
    private int health;
    private int speed;
    private int defense;
    private int attack;
    private String name;
    private String type;
    private String weakness;
    private String resistance;
    private String[] moves = new String[4];
    private Random r = new Random();

    public BaseChar() {
	level = 1;
	experience = 0;
	health = 20;
	speed = r.nextInt(5)+5;
	defense = r.nextInt(5)+5;
	attack = r.nextInt(5)+5;
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

    public String getWeakness() {
	return weakness;
    }

    public String getResistance() {
	return resistance;
    }

    public String getMoves0() {
	return moves[0];
    }

    public String getMoves1() {
	return moves[1];
    }
    
    public String getMoves2() {
	return moves[2];
    }

    public String getMoves3() {
	return moves[3];
    }

    public String getType() {
	return type;
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

    public void setWeakness(String s) {
	weakness = s;
    }

    public void setResistance(String s) {
	resistance = s;
    }

    public void setName(String s) {
	name = s;
    }

     public void setMoves0(String move) {
	 moves[0] = move;
    }

    public void setMoves1(String move) {
	 moves[1] = move;
    }

    public void setMoves2(String move) {
	 moves[2] = move;
    }

    public void setMoves3(String move) {
	 moves[3] = move;
    }

    public void setType(String s) {
	type = s;
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
	    int newHealth = opponent.getHealth() - damage(opponent,50);;
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

    public String moveset() {
	String s = moves[0] + "\n" + moves[1];
	if (moves[2] != null) {
	    s = s + "\n" + moves[2];
	}
	if (moves[3] != null) {
	    s = s + "\n" + moves[3];
	}
	return s;	    
    }
	
    
}
