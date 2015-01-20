import java.util.*;
import java.io.*;

public class Route1 {
   
    private Scanner scan = new Scanner(System.in);
    private Random r = new Random();
    private Battle battle = new Battle();
    private int meters = 0;
    private String s;

    public String routine(Player player) {
	player.setLocation("Route 1");
	System.out.println("Do you want to WALK FORWARD (to PEWTER CITY) or WALK BACKWARDS (to PALLET TOWN)?");
	s = scan.nextLine();
	s = s.toLowerCase();
	if (s.equals("pokemon")) {
	    System.out.println(player.getPokemonStatus());
	    routine(player);
	}
	if (s.equals("walk forward")) {
	    meters =  meters + 100;
	    System.out.println("You walked 100 meters.");
	    if (meters >= 1000) {
		PewterCity pewtercity = new PewterCity();
		pewtercity.routine(player);
	    }
	    System.out.println("You are " + (1000 - meters) + " meters from PEWTER CITY. You are " + meters + " meters from PALLET TOWN.");
	    int rand = r.nextInt(4);
	    if (rand == 0) {
		Rattata rattata = new Rattata();
		battle.wildRoutine(player,rattata);	    
	    }
	    routine(player);
	}
	if (s.equals("walk backwards")) {
	    meters = meters - 100;
	    System.out.println("You walked 100 meters.");
	    if (meters <= 0) {
		System.out.println("You have reached PALLET TOWN.");
		HomeTown hometown = new HomeTown();
		hometown.walk(player,"home");
	    }
	    System.out.println("You are " + meters + " meters from PALLET TOWN. You are " + (1000 -meters) + " from PEWTER CITY");
	    int rand = r.nextInt(4);
	    if (rand == 0) {
		Rattata rattata = new Rattata();
		battle.wildRoutine(player,rattata);	    
	    }
	    routine(player);
	} else {
	    System.out.println("You can't walk in a " + s + " direction!");
	    routine(player);
	}
	return "";
    }
}
