import java.util.*;

public class Recover extends Move{

    private Random r = new Random();

    public String recover(BaseChar self) {
	String s ="";
	if (r.nextInt(100) <= 95) {
	    int newHealth = self.getHealth() + (self.getHealth()/4);
	    self.setHealth(newHealth);
	    s = this + " used RECOVER!";
	} else {
	    s = this + " used RECOVER! But it failed!"; 
	}
	return s;
    }

}
