import java.io.*;
import java.util.*;

public class PewterCity {

    private String s;
    int meters = 0;
    private Battle battle = new Battle();
    Scanner scan = new Scanner(System.in);
    Random r = new Random();

    //Checks whether you can buy this many items/ whether it's a number  
    public boolean canBuy(String str){
      return str.matches("-?\\d");
      
    }

    public String routine(Player player) {
	player.setLocation("Pewter City");	
	System.out.println("You have reached PEWTER CITY");
	walk(player,"street");
	return "";
    }

    public String pokemoncenter(Player player) {
	System.out.println("NURSE: Hello! Welcome to the POKEMON CENTER. We restore your POKEMON to full health, free of charge. Our health care system sure is great. Here, let me take care of your POKEMON.");
	for (int i=0;i<player.getPokemon().length &&
		 player.getPokemon()[i] != null;i++) {
	    player.getPokemon()[i].setHealth(player.getPokemon()[i].getMaxHealth());
	    player.getPokemon()[i].setPP(0,player.getPokemon()[i].getMaxPP()[0]);
	    if (player.getPokemon()[i].getMaxPP()[1] != 0) {
		player.getPokemon()[i].setPP(1,player.getPokemon()[i].getMaxPP()[1]);
	    }
	    if (player.getPokemon()[i].getMaxPP()[2] != 0) {
		player.getPokemon()[i].setPP(1,player.getPokemon()[i].getMaxPP()[2]);
	    }
	    if (player.getPokemon()[i].getMaxPP()[3] != 0) {
		player.getPokemon()[i].setPP(1,player.getPokemon()[i].getMaxPP()[3]);
	    }
	}
	System.out.println("~healing music~");
	System.out.println("NURSE: All healed up!");
	walk(player,"pokemon center");
	return "";
    }

    public String pokemart(Player player) {
	System.out.println("CASHIER: Welcome to the POKEMART! We sell all kinds of goods here. What would you like to purchase?");
	System.out.println(player + "'s money: $" + player.getMoney());  
	System.out.println("POKEBALL $50");
	s = scan.nextLine();
	s = s.toLowerCase();
	if (s.equals("pokeball")) {
	    System.out.println("And how many POKEBALLS would you like to purchase?");
	    s = scan.nextLine();
	    s = s.toLowerCase();
	    while(canBuy(s) != true){
		System.out.println("CASHIER: You can't buy " + s + " items." +
				   "\n" + "How many POKEBALLS would you like to purchase?");
		s = scan.nextLine();
		s = s.toLowerCase();
	    }
	    int p = Integer.parseInt(s);
	    if (player.getMoney() >= 50 * p) {
		//add confirmation
		player.setBag("POKEBALL",0);
		player.setBagNum(player.getBagNum()[0] + p,0);
		player.setMoney(player.getMoney() - (p * 50));
		System.out.println("CASHIER: Thank you for your purchase!");
	    }
	}
	walk(player,"pokemart");
	return "";
    }

    public String training(Player player) {
	System.out.println("Do you want to WALK FORWARDS or WALK BACKWARDS (to PEWTER CITY)?");
	s = scan.nextLine();
	s = s.toLowerCase();
	if (s.equals("walk forwards")) {
	    if (meters >= 300) {
		System.out.println("OUCH. There is a large, rocky mountain in your way. How did you miss that?");
	    } else {
		meters = meters + 50;
		System.out.println("You walked 50 meters.");
		System.out.println("You are " + meters + " meters from PEWTER CITY.");
		int rand = r.nextInt(6);
		if (rand <= 1) {
		    Geodude geodude = new Geodude();
		    battle.wildRoutine(player,geodude);
		}
		if (rand == 2) {
		    Player hiker = new Player("RANDOM HIKER GUY");
		    Geodude geodude = new Geodude();
		    //Stats for Geodude
		    geodude.setLevel(4);
		    geodude.setMaxHealth(18 + r.nextInt(5));
		    geodude.setHealth(geodude.getMaxHealth());
		    geodude.setMaxSpeed(5 + r.nextInt(5));
		    geodude.setSpeed(geodude.getMaxSpeed());
		    geodude.setMaxDefense(5 + r.nextInt(5));
		    geodude.setDefense(geodude.getMaxDefense());
		    geodude.setMaxAttack(5 + r.nextInt(5));
		    geodude.setAttack(geodude.getMaxAttack());
		    geodude.setMove(1,"ROCK THROW");
		    geodude.setPP(1,15);
		    geodude.setMaxPP(1,15);
		    hiker.setPokemon(geodude,0);
		    System.out.println(hiker + ": Make sure you stay hydrated in these mountains...Let's battle to see how you're doing!");
		    battle.trainerRoutine(player,hiker);
		    if (player.getPokemon()[0].getHealth() > 0) {
			System.out.println(hiker + ": Guess I didn't drink enough water...");
			player.setMoney(player.getMoney() + 250);
		    }
		}
		if (rand == 3) {
		    Player hiker = new Player("RANDOM CLIMBER WOMAN");
		    Geodude geodude = new Geodude();
		    //Stats for Geodude
		    geodude.setLevel(3);
		    geodude.setMaxHealth(17 + r.nextInt(5));
		    geodude.setHealth(geodude.getMaxHealth());
		    geodude.setMaxSpeed(4 + r.nextInt(5));
		    geodude.setSpeed(geodude.getMaxSpeed());
		    geodude.setMaxDefense(4 + r.nextInt(5));
		    geodude.setDefense(geodude.getMaxDefense());
		    geodude.setMaxAttack(4 + r.nextInt(5));
		    geodude.setAttack(geodude.getMaxAttack());
		    geodude.setMove(1,"ROCK THROW");
		    geodude.setPP(1,15);
		    geodude.setMaxPP(1,15);
		    hiker.setPokemon(geodude,0);
		    System.out.println(hiker + ": Scaling these rocks tires me out...but I've still got enough energy for a battle!");
		    battle.trainerRoutine(player,hiker);
		    if (player.getPokemon()[0].getHealth() > 0) {
			System.out.println(hiker + ": Well, back to the cliffs...");
			player.setMoney(player.getMoney() + 250);
		    }
		}
	    }
	    training(player);
	}
	if (s.equals("walk backwards")) {
	    meters = meters - 50;
	    System.out.println("You walked 50 meters.");
	    if (meters <= 0) {
		System.out.println("You have reached PEWTER CITY.");
		walk(player,"street");
	    } else {
		System.out.println("You are " + meters + " meters from PEWTER CITY.");
		int rand = r.nextInt(6);
		if (rand <= 1) {
		    Geodude geodude = new Geodude();
		    battle.wildRoutine(player,geodude);
		}
		if (rand == 2) {
		    Player hiker = new Player("RANDOM HIKER GUY");
		    Geodude geodude = new Geodude();
		    hiker.setPokemon(geodude,0);
		    System.out.println(hiker + ": Make sure you stay hydrated in these mountains...Let's battle to see how you're doing!");
		    battle.trainerRoutine(player,hiker);
		    if (player.getPokemon()[0].getHealth() > 0) {
			System.out.println(hiker + ": Guess I didn't drink enough water...");
			player.setMoney(player.getMoney() + 250);
		    }
		}
		if (rand == 3) {
		    Player hiker = new Player("RANDOM CLIMBER WOMAN");
		    Geodude geodude = new Geodude();
		    hiker.setPokemon(geodude,0);
		    System.out.println(hiker + ": Scaling these rocks tires me out...but I've still got enough energy for a battle!");
		    battle.trainerRoutine(player,hiker);
		    if (player.getPokemon()[0].getHealth() > 0) {
			System.out.println(hiker + ": Well, back to the cliffs...");
			player.setMoney(player.getMoney() + 250);
		    }
		}
		training(player);
	    }
	}
        if (s.equals("pokemon")) {
	    System.out.println(player.getPokemonStatus());
	    training(player);
	}
	if (s.equals("exit game")) {
	    System.exit(0);
	}
	if (s.equals(player.toString().toLowerCase())) {
	    System.out.println("MONEY: $" + player.getMoney() + "\n");
	    System.out.println(player.seeBadges());
	    System.out.println("BAG: ");
	    for (int i=0;i<player.getBag().length &&
		     player.getBag()[i] != null;i++) {
		System.out.println(player.getBag()[i] + " " + 
				   player.getBagNum()[i]);
	    }
	    if (player.getBag()[0] == null) {
		System.out.println("Your bag is empty!");
	    }
	    training(player);
	}
	if (s.contains("switch") && s.length() == 10) {
	    String switch1 = s.substring(7,8);
	    String switch2 = s.substring(9,10);
	    int a = Integer.parseInt(switch1);
	    int b = Integer.parseInt(switch2);
	    if ((switch1.equals("1") ||
		 switch1.equals("2") ||
		 switch1.equals("3") ||
		 switch1.equals("4") ||
		 switch1.equals("5") ||
		 switch1.equals("6") ||
		 switch2.equals("1") ||
		 switch2.equals("2") ||
		 switch2.equals("3") ||
		 switch2.equals("4") ||
		 switch2.equals("5") ||
		 switch2.equals("6")) &&
		!(switch1.equals(switch2)) &&
		!(player.getPokemon()[a-1] == null) &&
		!(player.getPokemon()[b-1] == null)) {  
		int s1 = Integer.parseInt(switch1) - 1;
		int s2 = Integer.parseInt(switch2) - 1;
		BaseChar poke1 = player.getPokemon()[s1];
		BaseChar poke2 = player.getPokemon()[s2];
		player.setPokemon(poke1,s2);
		player.setPokemon(poke2,s1);
		System.out.println(player.getPokemonStatus());
	        training(player);
	    } else {
		System.out.println("You can't switch those POKEMON!");
	        training(player);
	    }
	} else {
	    System.out.println("You can't walk in a " + s + " direction!");
	    training(player);
	}
	return "";
    }

    public String gym(Player player) {
	if (player.getBadges()[0] != null) {
	    System.out.println("BROCK: Stay sturdy in your training, " + player + "! That BOULDER BADGE is a symbol of your fortitude!" );
	    walk(player,"brock's gym");
	} else {
	    System.out.println("BROCK: Hello there! I'm BROCK, the leader of the PEWTER CITY GYM!");
	    System.out.println("BROCK: Rock POKEMON exemplify what we should strive to be: tough, determined, made of minerals and small sand particles - er, forget that last part.");
	    System.out.println("BROCK: Do you think you have what it takes to earn the BOULDER BADGE? Are you hardy enough to take me on?");
	    s = scan.nextLine();
	    s = s.toLowerCase();
	    if (s.equals("yes")) {
		System.out.println("BROCK: Alright then! Let's go! I'll pound you! - er, I mean - let's just battle.");
		Player brock = new Player("BROCK");
		Geodude geodude0 = new Geodude();
		Geodude geodude1 = new Geodude();
		geodude0.setLevel(5);
		geodude0.setMaxHealth(25);
		geodude0.setHealth(geodude0.getMaxHealth());
		geodude0.setMaxSpeed(10);
		geodude0.setSpeed(geodude0.getMaxSpeed());
		geodude0.setMaxDefense(10);
		geodude0.setDefense(geodude0.getMaxDefense());
		geodude0.setMaxAttack(10);
		geodude0.setAttack(geodude0.getMaxAttack());
		geodude0.setMove(1,"ROCK THROW");
		geodude0.setPP(1,15);
		geodude0.setMaxPP(1,15);
		geodude1.setLevel(5);
		geodude1.setMaxHealth(25);
		geodude1.setHealth(geodude1.getMaxHealth());
		geodude1.setMaxSpeed(10);
		geodude1.setSpeed(geodude1.getMaxSpeed());
		geodude1.setMaxDefense(10);
		geodude1.setDefense(geodude1.getMaxDefense());
		geodude1.setMaxAttack(10);
		geodude1.setAttack(geodude1.getMaxAttack());
		geodude1.setMove(1,"ROCK THROW");
		geodude1.setPP(1,15);
		geodude1.setMaxPP(1,15);
		brock.setPokemon(geodude0,0);
		brock.setPokemon(geodude1,1);
		battle.trainerRoutine(player,brock);
		if (player.getPokemon()[0].getHealth() > 0) {
		    System.out.println("BROCK: Wow, you beat me! You ready are strong. Here, take the BOULDER BADGE!");
		    player.setBadges("BOULDER BADGE",0);
		    System.out.println("BROCK: Don't stop training, kid! You'll go far.");
		}
		walk(player,"brock's gym");
	    } else {
		System.out.println("BROCK: I'll see you next time then, when you HARD-en up to it. Har har har!");
		walk(player,"brock's gym");
	    }
	}
	return "";
    }

    public boolean etc(Player player, String source, String s) {
	if (s.equals("pokemon")) {
	    System.out.println(player.getPokemonStatus());
	    walk(player,source);
	    return true;
	}
	if (s.equals("exit game")) {
	    System.exit(0);
	    return true;
	}
	if (s.equals(player.toString().toLowerCase())) {
	    System.out.println("MONEY: $" + player.getMoney() + "\n");
	    System.out.println(player.seeBadges());
	    System.out.println("BAG: ");
	    for (int i=0;i<player.getBag().length &&
		     player.getBag()[i] != null;i++) {
		System.out.println(player.getBag()[i] + " " + 
				   player.getBagNum()[i]);
	    }
	    if (player.getBag()[0] == null) {
		System.out.println("Your bag is empty!");
	    }
	    walk(player,source);
	    return true;
	}
	if (s.contains("switch") && s.length() == 10) {
	    String switch1 = s.substring(7,8);
	    String switch2 = s.substring(9,10);
	    int a = Integer.parseInt(switch1);
	    int b = Integer.parseInt(switch2);
	    if ((switch1.equals("1") ||
		 switch1.equals("2") ||
		 switch1.equals("3") ||
		 switch1.equals("4") ||
		 switch1.equals("5") ||
		 switch1.equals("6") ||
		 switch2.equals("1") ||
		 switch2.equals("2") ||
		 switch2.equals("3") ||
		 switch2.equals("4") ||
		 switch2.equals("5") ||
		 switch2.equals("6")) &&
		!(switch1.equals(switch2)) &&
		!(player.getPokemon()[a-1] == null) &&
		!(player.getPokemon()[b-1] == null)) {  
		int s1 = Integer.parseInt(switch1) - 1;
		int s2 = Integer.parseInt(switch2) - 1;
		BaseChar poke1 = player.getPokemon()[s1];
		BaseChar poke2 = player.getPokemon()[s2];
		player.setPokemon(poke1,s2);
		player.setPokemon(poke2,s1);
		System.out.println(player.getPokemonStatus());
		walk(player,source);
		return true;
	    } else {
		System.out.println("You can't switch those POKEMON!");
		walk(player,source);
		return true;
	    }
	} else {
	    return false;
	}
    }

    public String walk(Player player, String source) {
	if (source.equals("street")) {
	    System.out.println("Where do you want to go?");
	    System.out.println("POKEMON CENTER   POKEMART   BROCK'S GYM   PALLET TOWN   ROCKY ROCK TRAINING PLACE   CERULEAN CITY");
	    s = scan.nextLine();
	    s = s.toLowerCase();
	    if (s.equals("pokemon center")) {
		pokemoncenter(player);
	    }
	    if (s.equals("pokemart")) {
		pokemart(player);
	    }
	    if (s.equals("brock's gym")) {
		gym(player);
	    }
	    if (s.equals("pallet town")) {
		Route1 route1 = new Route1();
		route1.routinePewter(player);
	    }
	    if (s.equals("rocky rock training place")) {
		System.out.println("You enter the ROCKY ROCK TRAINING PLACE, an area with rocky terrain. A sign reads, ROCKY ROCK TRAINING PLACE: THE 72ND TOUGHEST PLACE ON EARTH.");
		training(player);
	    }
	    if (etc(player,source,s)) {
	    } else {
	    System.out.println("You can't go there!");
	    walk(player,source);
	    }
	}
	if (source.equals("brock's gym")) {
	    System.out.println("Where do you want to go?");
	    System.out.println("POKEMON CENTER   POKEMART   BROCK'S GYM   PALLET TOWN   ROCKY ROCK TRAINING PLACE   CERULEAN CITY");
	    s = scan.nextLine();
	    s = s.toLowerCase();
	    if (s.equals("pokemon center")) {
		pokemoncenter(player);
	    }
	    if (s.equals("pokemart")) {
		pokemart(player);
	    } 
	    if (s.equals("pallet town")) {
		Route1 route1 = new Route1();
		route1.routinePewter(player);
	    }
	    if (s.equals("rocky rock training place")) {
		System.out.println("You enter the ROCKY ROCK TRAINING PLACE, an area with rocky terrain. A sign reads, ROCKY ROCK TRAINING PLACE: THE 72ND TOUGHEST PLACE ON EARTH.");
		training(player);
	    }
	    if (etc(player,source,s)) {
	    } else {
	    System.out.println("You can't go there!");
	    walk(player,source);
	    }
	}
	if (source.equals("pokemon center")) {
	    System.out.println("Where do you want to go?");
	    System.out.println("PC   POKEMART   BROCK'S GYM   PALLET TOWN   ROCKY ROCK TRAINING PLACE   CERULEAN CITY   SAVE");
	    s = scan.nextLine();
	    s = s.toLowerCase();
	    if (s.equals("pc")) {
		if (player.getPCPokemonStatus().equals("")) {
		    System.out.println("There are no POKEMON in the PC!");
		    walk(player,source);
		} else {
		    System.out.println(player.getPCPokemonStatus());
		    walk(player,source);
		}
	    }
	    if (s.equals("pokemart")) {
		pokemart(player);
	    }
	    if (s.equals("brock's gym")) {
		gym(player);
	    }
	    if (s.equals("pallet town")) {
		Route1 route1 = new Route1();
		route1.routinePewter(player);
	    }
	    if (s.equals("rocky rock training place")) {
		System.out.println("You enter the ROCKY ROCK TRAINING PLACE, an area with rocky terrain. A sign reads, ROCKY ROCK TRAINING PLACE: THE 72ND TOUGHEST PLACE ON EARTH.");
		training(player);
	    }
	    if (s.equals("save")) {
		try {
		    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("save.dat"));
		    oos.writeObject(player);
		    oos.close();
		    System.out.println("GAME SAVED");
		    walk(player,source);
		} catch(Exception ex) {
		    ex.printStackTrace();
		}
	    }
	    if (s.contains("pc switch") && s.length() == 13) {
		String switch1 = s.substring(10,11);
		String switch2 = s.substring(12,13);
		int a = Integer.parseInt(switch1);
		int b = Integer.parseInt(switch2);
		if (switch1.equals("1") ||
		     switch1.equals("2") ||
		     switch1.equals("3") ||
		     switch1.equals("4") ||
		     switch1.equals("5") ||
		     switch1.equals("6") &&
		     !(player.getPokemon()[a-1] == null) &&
		     !(player.getPC().get(b-1) == null)) {  
		    int s1 = Integer.parseInt(switch1) - 1;
		    int s2 = Integer.parseInt(switch2) - 1;
		    BaseChar poke1 = player.getPokemon()[s1];
		    BaseChar poke2 = player.getPC().get(s2);
		    player.setPokemon(poke2,s1);
		    player.setPC(poke1,s2);
		    System.out.println(player.getPokemonStatus());
		    walk(player,source);
		} else {
		    System.out.println("You can't switch those POKEMON!");
		    walk(player,source);	  
		}
	    }
	    if (etc(player,source,s)) {
	    } else {
	    System.out.println("You can't go there!");
	    walk(player,source);
	    }
	}
	if (source.equals("pokemart")) {
	    System.out.println("Where do you want to go?");
	    System.out.println("POKEMON CENTER   BROCK'S GYM   PALLET TOWN   ROCKY ROCK TRAINING PLACE   CERULEAN CITY");
	    s = scan.nextLine();
	    s = s.toLowerCase();
	    if (s.equals("pokemon center")) {
		pokemoncenter(player);
	    }
	    if (s.equals("brock's gym")) {
		gym(player);
	    }
	    if (s.equals("pallet town")) {
		Route1 route1 = new Route1();
		route1.routinePewter(player);
	    }
	    if (s.equals("rocky rock training place")) {
		System.out.println("You enter the ROCKY ROCK TRAINING PLACE, an area with rocky terrain. A sign reads, ROCKY ROCK TRAINING PLACE: THE 72ND TOUGHEST PLACE ON EARTH.");
		training(player);
	    }
	    if (etc(player,source,s)) {
	    } else {
		System.out.println("You can't go there!");
		walk(player,source);
	    }
	}
	return "";
    }

}
