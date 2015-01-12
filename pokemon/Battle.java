import java.util.*;
import java.io.*;


public class Battle {

    public static void main(String[] args) {
	Charmander opponent = new Charmander();
	Squirtle player = new Squirtle();
	Scanner scan = new Scanner(System.in);
	Random r = new Random();


	boolean fight = true;
	boolean turn = true;
	if(opponent.getSpeed() > player.getSpeed()){   
	    //whoever's speed is faster gets to go first
	    turn = false;  
	}
	System.out.println("Foe " + opponent + " wants to battle!");
	//BASIC fight sequence 
	
	while (fight){
	    

	    //opponents stats
	    System.out.println("Foe " + opponent.status() + "\n");
	    
	    //player's stats
	    System.out.println(player.status() + "\n");

	    //*********************THE PLAYER'S TURN*************************
	    while(fight && turn){
		//Selection of PLAYER's move
		System.out.println("What do you want to do? \n" +
				   player.moveset()
				   );
		
		String move;
		move = scan.nextLine();
		move = move.toLowerCase();
		move = move.replaceAll("\\s+","");
		if (move.equals("tackle")) {
		    player.tackle(opponent);
		}
		if (move.equals("recover")) {
		    player.recover();
		}
		turn = false;
		if(opponent.getHealth() <= 0){
		    System.out.println("Foe " + opponent + 
				       "has fainted! You win");
		    System.exit(0);
		    
		}
	    }
	    //*********************THE OPPONENT'S TURN************************
	    while(fight && !turn){
		//dumb opponent's move selection (random)
		int movesNum = 0;
		while (moves[movesNum] != null && movesNum != 4){
		    movesNum++;
		}
		int move = r.nextInt(movesNum);
		if(move == 0){
		    opponent.tackle(player);
		}
		if(move == 1){
		    opponent.recover();
		}
		if(player.getHealth() <= 0){
		    System.out.println(player + " has fainted, do you want to send out another pokemon?");
		    String newMon;
		    newMon = scan.nextLine();
		    //^^ This was done to later continue the game
		    System.exit(0);
		}
		turn = true;
		    
	    }
	}
    }
}

/*
  PROBLEMS WITH THIS SO FAR
  -No way to call an attack without knowing what is in "moves[1]", only way this code works, is if moves[0] is tackle, and moves[1] is recover (which I used, 
we'll have to fix that).
  
  -Code also doesn't work because it is imposible to get an xth element of 
  moves[]...
^^^^^it SHOULD work if this problem is solved, but there is no way I can think 
of testing that. The code DIFINITELY works without the CPU (opponent) move 
selection, I tested it
*/