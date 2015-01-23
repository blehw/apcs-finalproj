import java.util.*;
import java.io.*;

public class Player implements Serializable {

    private BaseChar[] pokemon = new BaseChar[6];
    private ArrayList<BaseChar> PC = new ArrayList<BaseChar>();
    private String location;
    private String name;
    private String[] badges = new String[4];
    private String[] bag = new String[20];
    private int[] bagNum = new int[20];
    private int money = 0;

    public Player() {
	location = "Pallet Town";
    }
    
    public Player(String s) {
	location = "Pallet Town";
	name = s;
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

    public ArrayList<BaseChar> getPC() {
	return PC;
    }

    public String getPokemonStatus() {
	String s = "\n";
	for (int i=0;i<pokemon.length && pokemon[i] != null;i++) {
	    s += (i+1) +  ": " + pokemon[i].status() + "\n";
	}
	s = s.substring(0,s.length()-1);
	return s;
    }

    public String getPCPokemonStatus() {
	String s = "\n";
	for (int i=0;i<PC.size() && PC.get(i) != null;i++) {
	    s += (i+1) +  ": " + PC.get(i).status() + "\n";
	}
	s = s.substring(0,s.length()-1);
	return s;
    }
    
    public String[] getBadges(){
	return badges;
    }

    public String seeBadges(){
	String s;
	s = "You have the ";
	if (badges[0] == null) {
	    return "You have no badges yet.";
	} else {
	    int i = 0;
	    while (badges[i] != null){
		s = s + badges[i] + ".\n";
		i++;
	    }
	}
	return s;
    }
    
    public String[] getBag() {
	return bag;
    }

    public int[] getBagNum() {
	return bagNum;
    }

    public int getMoney() {
	return money;
    }

    public void setLocation(String loc){
	location = loc;
    }

    public void addPC(BaseChar pokemon) {
	PC.add(pokemon);
    }

    public void setPC(BaseChar pokemon,int n) {
	PC.set(n,pokemon);
    }
    
    public void setPokemon(BaseChar poke, int pos){
	pokemon[pos] = poke;
    }

    public void setBadges(String badgeName, int pos){
	badges[pos] = badgeName;
    }

    public void setBag(String item, int pos) {
	bag[pos] = item;
    }

    public void setBagNum(int num, int pos) {
	bagNum[pos] = num;
    }

    public void setMoney(int num) {
	money = num;
    }

}
