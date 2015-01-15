import java.util.*;
import java.io.*;

public class Player {

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
    

    public BaseChar getPokemon0(){
	return pokemon[0];
    }

    public BaseChar getPokemon1(){
	return pokemon[1];
    }

    public BaseChar getPokemon2(){
	return pokemon[2];
    }

    public BaseChar getPokemon3(){
	return pokemon[3];
    }

    public BaseChar getPokemon4(){
	return pokemon[4];
    }
    
    public BaseChar getPokemon5(){
	return pokemon[5];
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


    public void setPokemon0(BaseChar poke){
	pokemon[0] = poke;
    }

    public void setPokemon1(BaseChar poke){
	pokemon[1] = poke;
    }

    public void setPokemon2(BaseChar poke){
	pokemon[2] = poke;
    }

    public void setPokemon3(BaseChar poke){
	pokemon[3] = poke;
    }

    public void setPokemon4(BaseChar poke){
	pokemon[4] = poke;
    }

    public void setPokemon5(BaseChar poke){
	pokemon[5] = poke;
    }



    public void setBadges0(String badgeName){
	badges[0] = badgeName;
    }

    public void setBadges1(String badgeName){
	badges[1] = badgeName;
    }

    public void setBadges2(String badgeName){
	badges[2] = badgeName;
    }

    public void setBadges3(String badgeName){
	badges[3] = badgeName;
    }


}
