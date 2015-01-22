import java.util.*;

public class Rattata extends Normal{

    private Random r = new Random();
    
    public Rattata() {
	setName("RATTATA");
	setLevel(1);
	setMaxHealth(5 + r.nextInt(10));
	setHealth(getMaxHealth());
	setMaxSpeed(2 + r.nextInt(4));
	setSpeed(getMaxSpeed());
	setMaxDefense(2 + r.nextInt(4));
	setDefense(getMaxDefense());
        setMaxAttack(2 + r.nextInt(4));
	setAttack(getMaxAttack());
    }
    
}
