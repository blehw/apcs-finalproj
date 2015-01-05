import java.io.*;
import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    private Container pane;
    private JLabel l;
    private ImageIcon map1;
    private JLabel map2;
    private JPanel canvas;
    private ImageIcon pac1;
    private JLabel pac2;
    private JPanel pac3;

    public GUI() {

	setTitle("Pacman");
	setSize(1000,1000);
	setLocation(100,100);
	setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = getContentPane();
	pane.setLayout(new FlowLayout());

	l = new JLabel("Pacman");
	pane.add(l);

        map1 = new ImageIcon("images/level1.png");
	map2 = new JLabel("", map1, JLabel.CENTER);
	canvas = new JPanel(new BorderLayout());
	canvas.add( map2, BorderLayout.CENTER );
	pane.add(canvas);

	pac1 = new ImageIcon("images/pacman.png");
	pac2 = new JLabel("", pac1, JLabel.CENTER);
	pac3 = new JPanel(new BorderLayout());
	pac3.add( pac2, BorderLayout.CENTER );
	pane.add(pac3);
	
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
