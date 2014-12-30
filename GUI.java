import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    private Container pane;
    private JLabel l;
    private JPanel canvas; 

    public GUI() {

	setTitle("Pacman");
	setSize(400,400);
	setLocation(100,100);
	setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = getContentPane();
	pane.setLayout(new FlowLayout());
	l = new JLabel("Pacman");
	pane.add(l);

	canvas = new JPanel();
	canvas.setPreferredSize(new Dimension(300,300));
	canvas.setBorder(BorderFactory.createLineBorder(Color.black,2));
	pane.add(canvas);
    }

    public static void main(String[] args) {
	GUI  g = new GUI();
	g.setVisible(true);
    }

}
