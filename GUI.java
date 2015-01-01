import java.io.*;
import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    private Container pane;
    private JLabel l;

    public GUI() {

	setTitle("Pacman");
	setSize(800,800);
	setLocation(100,100);
	setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = getContentPane();
	pane.setLayout(new FlowLayout());

	l = new JLabel("Pacman");
	pane.add(l);

        ImageIcon image = new ImageIcon("images/level1.png");
	JLabel label = new JLabel("", image, JLabel.CENTER);
	JPanel panel = new JPanel(new BorderLayout());
	panel.add( label, BorderLayout.CENTER );
	pane.add(panel);
	

	/*
	canvas = new JPanel();
	canvas.setPreferredSize(new Dimension(300,300));
	canvas.setBorder(BorderFactory.createLineBorder(Color.black,2));
	pane.add(canvas);
	*/
    }

    public static void main(String[] args) {
	GUI  g = new GUI();
	g.setVisible(true);
    }

}
