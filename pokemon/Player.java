import java.util.*;
import java.io.*;

public class Player implements Serializable {

    private BaseChar[] pokemon = new BaseChar[6];
    private String location;
    private String name;
    private String[] badges = new String[4];
    private String[] bag = new String[20];
    private int[] bagNum = new int[20]
    private int money = 0;

    public Player() {
	location = "Pallet Town";
    }

    public String toString() {
	return name;
    }

    public void setName(String s) {
	name = s;
    }

    public String getLocation() {
	return location;
    }

    public BaseChar[] getPokemon(){
	return pokemon;
    }

    public String getPokemonStatus() {
	String s = "";
	for (int i=0;i<pokemon.length && pokemon[i] != null;i++) {
	    s += pokemon[i].status();
	}
	return s;
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
    
    public String[] getBag() {
	return bag;
    }

    private int[] getBagNum() {
	return bagNum;
    }

    public void setLocation(String loc){
	location = loc;
    }
    
    public void setPokemon(BaseChar poke, int pos){
	pokemon[pos] = poke;
    }

    public void setBadges(String badgeName, int pos){
	badges[pos] = badgeName;
    }

}
