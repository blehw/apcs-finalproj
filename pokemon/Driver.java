import java.util.*;
import java.io.*;

public class Driver implements Serializable {
        
    public static void main(String[] args) {

	Player player = new Player();
	HomeTown hometown = new HomeTown();
	Player rival = new Player();
	Scanner scan = new Scanner(System.in);

	if (scan.nextLine() == "SAVE") {
	    try {
	    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("save.dat"));
	    oos.writeObject(player);
	    oos.close();
	} catch(Exception ex) {
	    ex.printStackTrace();
	    }
	}    

	//intro courtesy of http://www.supercheats.com/gameboy/walkthroughs/pokemonred-walkthrough09.txt
	System.out.println("Hello there! Welcome to the world of POKEMON! My name is OAK! People call me the POKEMON PROF!");
	System.out.println("This world is inhabited by creatures called POKEMON! For some people, POKEMON are pets. Others use them for fights. Myself...I study POKEMON as a profession.");
	System.out.println("First, what is your name?");
	String name = scan.nextLine();
	player.setName(name);
	System.out.println("Right! So your name is " + player + "!");
	System.out.println("My grandson has been your rival since you were a baby.");
	System.out.println("...Erm, what is his name again?");
	String rname = scan.nextLine();
	rival.setName(rname);
	System.out.println("That's right! I remember now! His name is " + rival + "!");
	System.out.println(player + "! Your very own POKEMON legend is about to unfold! A world of dreams and adventures with POKEMON awaits! Let's go!");
	System.out.println(hometown.routine(player,rival));
	
			   
	
    }
    
}
