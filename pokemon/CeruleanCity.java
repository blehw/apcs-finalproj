import java.io.*;
import java.util.*;

public class CeruleanCity {

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
	player.setLocation("Cerulean City");	
	System.out.println("You have reached CERULEAN CITY");
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
	System.out.println("Do you want to WALK FORWARDS or WALK BACKWARDS (to CERULEAN CITY)?");
	s = scan.nextLine();
	s = s.toLowerCase();
	if (s.equals("walk forwards")) {
	    if (meters >= 300) {
		System.out.println("WOAH! You narrowly avoid falling into a pond. Better turn back now.");
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
		    Player swimmer = new Player("WATER-POLO PLAYER");
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
		    System.out.println(swimmer + ": I battle anyone named " + player + ". What's your name?");
		    battle.trainerRoutine(player,swimmer);
		    if (player.getPokemon()[0].getHealth() > 0) {
			System.out.println(swimmer + ": Maybe I should stick to water-polo...");
			player.setMoney(player.getMoney() + 250);
		    }
		}
		if (rand == 3) {
		    Player swimmer = new Player("RECREATION SEAHORSE ENTHUSIAST");
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
		    System.out.println(swimmer + ": How does a seahorse quickly get from one place to another? \n...\nHe scallops!");
		    battle.trainerRoutine(player,swimmer);
		    if (player.getPokemon()[0].getHealth() > 0) {
			System.out.println(swimmer + ": I guess I'll make like a seahorse and scallop away.");
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
		System.out.println("You have reached CERULEAN CITY.");
		walk(player,"street");
	    } else {
		System.out.println("You are " + meters + " meters from CERULEAN CITY.");
		int rand = r.nextInt(6);
		if (rand <= 1) {
		    Geodude geodude = new Geodude();
		    battle.wildRoutine(player,geodude);
		}
		if (rand == 2) {
		    Player swimmer = new Player("WATER-POLO PLAYER");
		    Staryu staryu = new Staryu();
		    //Stats for Geodude
		    staryu.setLevel(4);
		    staryu.setMaxHealth(18 + r.nextInt(5));
		    staryu.setHealth(geodude.getMaxHealth());
		    staryu.setMaxSpeed(5 + r.nextInt(5));
		    staryu.setSpeed(geodude.getMaxSpeed());
		    staryu.setMaxDefense(5 + r.nextInt(5));
		    staryu.setDefense(geodude.getMaxDefense());
		    staryu.setMaxAttack(5 + r.nextInt(5));
		    staryu.setAttack(geodude.getMaxAttack());
		    staryu.setMove(1,"ROCK THROW");
		    staryu.setPP(1,15);
		    staryu.setMaxPP(1,15);
		    swimmer.setPokemon(staryu,0);
		    System.out.println(swimmer + ": I battle anyone named " + player + ". What's your name?");
		    battle.trainerRoutine(player,swimmer);
		    if (player.getPokemon()[0].getHealth() > 0) {
			System.out.println(swimmer + ": Maybe I should stick to water-polo...");
			player.setMoney(player.getMoney() + 250);
		    }
		}
		if (rand == 3) {
		    Player swimmer = new Player("RECREATION SEAHORSE ENTHUSIAST");
		    Geodude geodude = new Geodude();
		    //Stats for Horsea
		    horsea.setLevel(8);
		    horsea.setMaxHealth(23 + r.nextInt(8));
		    horsea.setHealth(horsea.getMaxHealth());
		    horsea.setMaxSpeed(10 + r.nextInt(5));
		    horsea.setSpeed(horsea.getMaxSpeed());
		    horsea.setMaxDefense(10 + r.nextInt(5));
		    horsea.setDefense(horsea.getMaxDefense());
		    horsea.setMaxAttack(10 + r.nextInt(8));
		    horsea.setAttack(horsea.getMaxAttack());
		    horsea.setMove(1,"BUBBLE");
		    horsea.setPP(1,30);
		    horsea.setMaxPP(1,30);
		    horsea.setMove(2,"BRINE");
		    horsea.setPP(2,10);
		    horsea.setMaxPP(2,10);
		    swimmer.setPokemon(horsea,0);
		    System.out.println(swimmer + ": How does a seahorse quickly get from one place to another? \n...\nHe scallops!");
		    battle.trainerRoutine(player,swimmer);
		    if (player.getPokemon()[0].getHealth() > 0) {
			System.out.println(swimmer + ": I guess I'll make like a seahorse and scallop away.");
			player.setMoney(player.getMoney() + 250);
		    }
		}
	    }
	    training(player);
	
	    
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
	    int a = 1;
	    int b = 2;
	    try {
		a = Integer.parseInt(switch1);
		b = Integer.parseInt(switch2);
	    } catch (Exception e) {
		System.out.println("You can't switch those POKEMON!");
	        training(player);
	    }
	    if (((switch1.equals("1") ||
		 switch1.equals("2") ||
		 switch1.equals("3") ||
		 switch1.equals("4") ||
		 switch1.equals("5") ||
		 switch1.equals("6")) &&
		 (switch2.equals("1") ||
		 switch2.equals("2") ||
		 switch2.equals("3") ||
		 switch2.equals("4") ||
		 switch2.equals("5") ||
		  switch2.equals("6"))) &&
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

    //MISTY'S GYM
    public String gym(Player player) {
	if (player.getBadges()[0] != null) {
	    System.out.println( );
	    walk(player,"misty's gym");
	} else {
	    System.out.println("MISTY: Heyya! I'm MISTY, leader of the CERULEAN CITY GYM!");
	    System.out.println("MISTY: I train my water type POKEMON to be the best. We have practice and self-reflecting sessions every morning.");
	    System.out.println("MISTY: Do you want to test the water type POKEMON's powers?");
	    s = scan.nextLine();
	    s = s.toLowerCase();
	    if (s.equals("yes")) {
		System.out.println("MISTY: Awesome! Let's sea how this goes.");
		Player misty = new Player("MISTY");
		Horsea horsea = new Horsea();
		Staryu staryu = new Staryu();
		horsea.setLevel(10);
		horsea.setMaxHealth(40);
		horsea.setHealth(horsea.getMaxHealth());
		horsea.setMaxSpeed(20);
		horsea.setSpeed(horsea.getMaxSpeed());
		horsea.setMaxDefense(20);
		horsea.setDefense(horsea.getMaxDefense());
		horsea.setMaxAttack(15);
		horsea.setAttack(horsea.getMaxAttack());
		horsea.setMove(1,"BUBBLE");
		horsea.setPP(1,30);
		horsea.setMaxPP(1,30);
		horsea.setMove(2,"BRINE");
		horsea.setPP(2,10);
		horsea.setMaxPP(2,10);
		staryu.setLevel(11);
		staryu.setMaxHealth(45);
		staryu.setHealth(staryu.getMaxHealth());
		staryu.setMaxSpeed(22);
		staryu.setSpeed(staryu.getMaxSpeed());
		staryu.setMaxDefense(15);
		staryu.setDefense(staryu.getMaxDefense());
		staryu.setMaxAttack(20);
		staryu.setAttack(staryu.getMaxAttack());
		staryu.setMove(1,"WATER GUN");
		staryu.setPP(1,25);
		staryu.setMaxPP(1,25);
		staryu.setMove(2, "GYRO BALL");
		staryu.setPP(2, 20);
		staryu.setMaxPP(2, 20);
		staryu.setMove(3, "BUBBLE BEAM");
		staryu.setPP(3, 20);
		staryu.setMaxPP(3, 20);
		misty.setPokemon(horsea,0);
		misty.setPokemon(staryu,1);
		battle.trainerRoutine(player,misty);
		if (player.getPokemon()[0].getHealth() > 0) {
		    player.setMoney(player.getMoney() + 1000);
		    System.out.println(player + " got $1000 for winning!");
		    System.out.println("MISTY: Woah, that really put a dampener on things. This here CASCADE BADGE is proof of your amazing flow!");
		    player.setBadges("CASCADE",1);
		    System.out.println("MISTY: Good luck on your journey, I hope you collect all the badges!");
		}
		walk(player,"misty's gym");
	    } else {
		System.out.println("MISTY: Sure, I'll give you some time to self-reflect.");
		walk(player,"misty's gym");
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
	    int a = 1;
	    int b = 2;
	    try {
		a = Integer.parseInt(switch1);
		b = Integer.parseInt(switch2);
	    } catch (Exception e) {
		System.out.println("You can't switch those POKEMON!");
	        walk(player,source);
	    }
	    if (((switch1.equals("1") ||
		 switch1.equals("2") ||
		 switch1.equals("3") ||
		 switch1.equals("4") ||
		 switch1.equals("5") ||
		 switch1.equals("6") ||
		 switch2.equals("1")) &&
		 (switch2.equals("2") ||
		 switch2.equals("3") ||
		 switch2.equals("4") ||
		 switch2.equals("5") ||
		  switch2.equals("6"))) &&
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
	    System.out.println("POKEMON CENTER   POKEMART   MISTY'S GYM   PEWTER CITY   POOLSIDE TRAINING PLACE   NEXT CITY");
	    s = scan.nextLine();
	    s = s.toLowerCase();
	    if (s.equals("pokemon center")) {
		pokemoncenter(player);
	    }
	    if (s.equals("pokemart")) {
		pokemart(player);
	    }
	    if (s.equals("misty's gym")) {
		gym(player);
	    }
	    if (s.equals("pewter city")) {
		Route1 route1 = new Route1();
		route1.routinePewter(player);
	    }
	    if (s.equals("poolside training place")) {
		System.out.println("You enter the POOLSIDE TRAINING PLACE.");
		training(player);
	    }
	    if (etc(player,source,s)) {
	    } else {
	    System.out.println("You can't go there!");
	    walk(player,source);
	    }
	}
	if (source.equals("misty's gym")) {
	    System.out.println("Where do you want to go?");
	    System.out.println("POKEMON CENTER   POKEMART   MISTY'S GYM   PEWTER CITY   ROCKY ROCK TRAINING PLACE   CERULEAN CITY");
	    s = scan.nextLine();
	    s = s.toLowerCase();
	    if (s.equals("pokemon center")) {
		pokemoncenter(player);
	    }
	    if (s.equals("pokemart")) {
		pokemart(player);
	    } 
	    if (s.equals("pewter city")) {
		Route1 route1 = new Route1();
		route1.routinePewter(player);
	    }
	    if (s.equals("poolside training place")) {
		System.out.println("You enter the POOLSIDE TRAINING PLACE.");
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
	    System.out.println("PC   POKEMART   MISTY'S GYM   PEWTER CITY   POOLSIDE TRAINING PLACE   NEXT CITY   SAVE");
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
	    if (s.equals("misty's gym")) {
		gym(player);
	    }
	    if (s.equals("pewter city")) {
		Route1 route1 = new Route1();
		route1.routinePewter(player);
	    }
	    if (s.equals("poolside training place")) {
		System.out.println("You enter the POOLSIDE TRAINING PLACE.");
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
		int a = 1;
		int b = 2;
		try { 
		    a = Integer.parseInt(switch1);
		    b = Integer.parseInt(switch2);
		} catch (Exception e) {
		    System.out.println("You can't switch those POKEMON!");
		    walk(player,source);
		}
		if (player.getPC().size() >= b) {
		    if ((switch1.equals("1") ||
			 switch1.equals("2") ||
			 switch1.equals("3") ||
			 switch1.equals("4") ||
			 switch1.equals("5") ||
			 switch1.equals("6")) &&
			!(player.getPokemon()[a-1] == null) &&
			!(player.getPC().get(b-1) == null) &&
			player.getPC().size()>=b) {  
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
	    System.out.println("POKEMON CENTER   MISTY'S GYM   PEWTER CITY   ROCKY ROCK TRAINING PLACE   NEXT CITY");
	    s = scan.nextLine();
	    s = s.toLowerCase();
	    if (s.equals("pokemon center")) {
		pokemoncenter(player);
	    }
	    if (s.equals("misty's gym")) {
		gym(player);
	    }
	    if (s.equals("pewter city")) {
		Route1 route1 = new Route1();
		route1.routinePewter(player);
	    }
	    if (s.equals("poolside training place")) {
		System.out.println("You enter the POOLSIDE TRAINING PLACE.");
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