import java.awt.Color;

import javax.swing.*;
import java.awt.*;
class game{
	JFrame frame;
	public game(){
		frame = new JFrame();
		JButton jb1 = new JButton("Click");
		jb1.setBounds(130,100,100,40);
		frame.add(jb1);
		
		frame.setBounds(700,300,600,500);
		frame.setTitle("Number Guessing Game");
		
		ImageIcon icon = new ImageIcon("omkar.jpg");
		frame.setIconImage(icon.getImage());
		
		Container c = frame.getContentPane();
		c.setBackground(Color.BLUE);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
	}
	public static void main(String... args) {
		//JFrame frame = new JFrame("Number Guessing Gaming");
		new game();
		
	}
}