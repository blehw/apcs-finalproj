public class BaseGhost {

    private int speed;
    /*
      0 = normal
      1 = scared
      2 = eaten
    */
    private int state;
    private int[] location;
    
    public BaseGhost() {
	speed = 1;
	state = 0;
	location[0] = 0;
	location[1] = 0;
    }

    public void move() {
	location[0] = location[0] + 1;
    }
}
