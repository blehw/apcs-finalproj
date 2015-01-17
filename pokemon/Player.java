import java.util.*;
import java.io.*;

public class Player implements Serializable {

    private BaseChar[] pokemon = new BaseChar[6];
    private int location;
    private String name;
    private String[] badges = new String[4];

    public Player() {
	location = 0;
    }

    public String toString() {
	return name;
    }

    public void setName(String s) {
	name = s;
    }

    public String getLocation() {
	String s = "";
	if (location == 0){
	    s= "HomeTown";
	}
	if (location == 1){
	    s= "GymTown #1";
	}
	if (location == 2){
	    s= "GymTown #2";
	}
	if (location == 3){
	    s= "GymTown #3";
	}
	if (location == 4){
	    s= "ChampionTown";
	}
	return s;
    }

    public BaseChar[] getPokemon(){
	return pokemon;
    }
    
    public String[] getBadges(){
	return badges;
    }

    public String seeBadges(){
	String s;
	s = "You have the ";
	int i = 0;
	while (badges[i+1] != null){
	    s = s + badges[i] + ", ";
	    i++;
	}
	s = s + "and " + badges[i] + "badge.";
	return s;
    }

    public void setLocation(int loc){
	location = loc;
    }
    
    public void setPokemon(BaseChar poke, int pos){
	pokemon[pos] = poke;
    }

    public void setBadges(String badgeName, int pos){
	badges[pos] = badgeName;
    }

}
