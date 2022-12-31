import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class testTest extends JFrame {
	boolean flag = false;

	testTest() {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame jf = new JFrame("pop us jframe");
		// JOptionPane.showMessageDialog(jf, "My name is Ashutosh Rathore");
		/*
		 * String str = JOptionPane.showInputDialog(jf, "Enter your name");
		 * JOptionPane.showMessageDialog(jf, str);
		 */
		/*
		 * int result = JOptionPane.showConfirmDialog(jf,
		 * "press the button according to your convinience");
		 * 
		 * if(result == 0) { System.out.println("you pressed yes"); } else if(result ==
		 * 1) { System.out.println("you pressed no"); } else {
		 * System.out.println("you pressed exit"); }
		 */

		JDialog jd = new JDialog(jf);
		jd.setLayout(new FlowLayout());
		jd.setBounds(500, 300, 400, 300);
		JLabel jl = new JLabel("my jlabel : - ");
		JButton jb = new JButton("click");
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				jd.setVisible(false);
			}
		});
	
	;
		 
		jd.add(jl);
		jd.add(jb);
		jd.setVisible(true);
		jf.setVisible(true); 
		jf.setBounds(500,300,1200,500);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
