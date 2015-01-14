import java.util.*;
import java.io.*;

public class Player {

    private BaseChar[] pokemon = new BaseChar[6];
    private int location;
    private String name;
    private String[] badges = new String badges[4];

    public Player() {
	location = 0;
    }

    public String toString() {
	return name;
    }

    public String getLocation() {
	if (location == 0){
	    return "HomeTown";
	}
	if (location == 1){
	    return "GymTown #1";
	}
	if (location == 2){
	    return "GymTown #2";
	}
	if (location == 3){
	    return "GymTown #3";
	}
	if (location == 4){
	    return "ChampionTown";
	}
    }
    

    public getPokemon0(){
	return pokemon[0];
    }

    public getPokemon1(){
	return pokemon[1];
    }

    public getPokemon2(){
	return pokemon[2];
    }

    public getPokemon3(){
	return pokemon[3];
    }

    public getPokemon4(){
	return pokemon[4];
    }
    
    public getPokemon5(){
	return pokemon[5];
    }

    public getBadges(){
	String s;
	s = "You have the "
	for (int i=0; badges[i+1] != null; i++){
	    s = s + badges[i] + ", ";
	}
	s = s + "and " + badges[i] + "badge.";
    }

    
    public setLocation(int loc){
	location = loc;
    }


    public setPokemon0(BaseChar poke){
	pokemon[0] = poke;
    }

    public setPokemon1(BaseChar poke){
	pokemon[1] = poke;
    }

    public setPokemon2(BaseChar poke){
	pokemon[2] = poke;
    }

    public setPokemon3(BaseChar poke){
	pokemon[3] = poke;
    }

    public setPokemon4(BaseChar poke){
	pokemon[4] = poke;
    }

    public setPokemon5(BaseChar poke){
	pokemon[5] = poke;
    }

    public setBadges0(String badgeName){
	badges[0] = badgeName;
    }

    public setBadges1(String badgeName){
	badges[1] = badgeName;
    }

    public setBadges2(String badgeName){
	badges[2] = badgeName;
    }

    public setBadges3(String badgeName){
	badges[3] = badgeName;
    }


}
