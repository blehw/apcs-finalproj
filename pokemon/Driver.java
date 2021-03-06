import java.util.*;
import java.io.*;

public class Driver implements Serializable {
        
    public static void main(String[] args) {

	Player player = new Player();
	Player rival = new Player();
	HomeTown hometown = new HomeTown();
	Scanner scan = new Scanner(System.in);

	try {
	    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("save.dat"));
	    player = (Player)ois.readObject();
	    ois.close();
	    if (player.getLocation().equals("Pallet Town")) {
		System.out.println(hometown.walk(player,"home"));
	    }
	    if (player.getLocation().equals("Pewter City")) {
		PewterCity pewtercity = new PewterCity();
		System.out.println(pewtercity.walk(player,"pokemon center"));
	    }	    
	    if (player.getLocation().equals("Cerulean City")) {
		CeruleanCity ceruleancity = new CeruleanCity();
		System.out.println(ceruleancity.walk(player,"pokemon center"));
	    }
	    if (player.getLocation().equals("Azalea Town")) {
		AzaleaTown azaleatown = new AzaleaTown();
		System.out.println(azaleatown.walk(player,"pokemon center"));
	    }
        } catch (IOException e) {
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
	    
	
	
	} catch (ClassNotFoundException p) {
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
    
}
