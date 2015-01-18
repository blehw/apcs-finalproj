import java.util.*;
import java.io.*;

public class Route1 {
    
    private Random r = new Random();
    private Battle battle = new Battle();
    private int meters = 0;
    private String s;

    public String routine(Scanner scan,  Player player) {
	System.out.println("Do you want to WALK FORWARD (to PEWTER CITY) or WALK BACKWARDS (to PALLET TOWN)?");
	s = scan.nextLine();
	s = s.toLowerCase();
	if (s.equals("walk forward")) {
	    meters =  meters 100;
	    System.out.println("You have walked " + meters + " meters.");
	    int rand = r.nextInt(2);
	    if (rand == 0) {
		Rattata rattata = new Rattata();
		battle.routine(player.getPokemon()[0],rattata);	    
	    }
	}
	return "";
    }
    
}
