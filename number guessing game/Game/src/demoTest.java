import java.awt.event.*;
import java.awt.*;
import java.lang.Math;
import java.util.Random;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.Border;

public class demoTest extends JFrame {
	JFrame frame;
	JButton jbPlay;
	static JLabel jlInstructionSet, jlScore;
	static int score = 50;
	static int randomNumber; // it get the random number 
	static int counter = 0; // it is for count of attempts
	static String str; // it take the string in return format and display the conclusion
	static int decreaser = 5;
	static int winner = 30;
	static boolean flag = false;
	public static String roundsContent = "<h1>Round 1 </h><p>Please read the instruction carefully...</p><br><br><p>1 :- You have only 5 attempts.<br><br><p>2 :- Each wrong try deduct your 5 points, So guess the number &nbsp &nbsp &nbsp &nbsp in Minumum try. </p><br><p>3 :- You need more than 30 point for clear this round. </p><br><br><p>4 :- We give you 50 points.</p></br><br><p>5 :- Your correct answer will give you 5 points.</p><br></body></head></html>"; // round instruction variable

	demoTest(){
		demoTest.randomNumber = randomNumber();
		System.out.println(randomNumber);
		
		JLabel jlGuess = new JLabel("Guess the Number...");
		jlGuess.setBounds(240,10,300,50);
		jlGuess.setForeground(Color.cyan);
		jlGuess.setFont(new Font("Algerian", Font.PLAIN, 23));
		add(jlGuess);
		
		JTextField jtfNumber = new JTextField();
		jtfNumber.setBounds(140,80, 300, 30);
		jtfNumber.setEnabled(false);
		add(jtfNumber);
		
		JLabel jlInstruction = new JLabel("Click on Play to Start the new Game...");
		jlInstruction.setBounds(180,130,600,50);
		jlInstruction.setFont(new Font("Arial",Font.PLAIN,18));
		jlInstruction.setForeground(Color.WHITE);
		add(jlInstruction);
		
		// EXit Game
		JButton jbExit = new JButton("Exit Game");
		jbExit.setBounds(360,250,180,30);
		jbExit.setFont(new Font("Algerian", Font.PLAIN, 18));
		jbExit.setBackground(Color.RED);
		jbExit.setForeground(Color.WHITE);
		add(jbExit);
		jbExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT);
				System.out.println("You closed the game");
			}
		});
		
		JLabel jlCounter = new JLabel("Your attempts!");
		jlCounter.setBounds(110,350,450,30);
		jlCounter.setFont(new Font("Algerian", Font.PLAIN, 25));
		jlCounter.setForeground(Color.WHITE);
		add(jlCounter);
		
		jlInstructionSet = new JLabel("<html><head><body>" + demoTest.roundsContent,SwingConstants.CENTER);
		jlInstructionSet.setBounds(580,0,600,500);
		jlInstructionSet.setBackground(Color.YELLOW);
		jlInstructionSet.setFont(new Font("Algerian", Font.PLAIN, 18));
		jlInstructionSet.setForeground(Color.GREEN);
		add(jlInstructionSet);
		
		jlScore = new JLabel(" Your Score is 50");
		Border orange = BorderFactory.createLineBorder(Color.orange);
		jlScore.setBounds(780,20,200,50);
		jlScore.setFont(new Font("Verdana", Font.PLAIN, 22));
		jlScore.setBackground(Color.GREEN);
		jlScore.setForeground(Color.ORANGE);
		jlScore.setBorder(orange);
		add(jlScore);
		
		// Guess Button 
		JButton jbGuess = new JButton("Guess");
		jbGuess.setBounds(450,80, 100, 30);
		jbGuess.setBackground(Color.blue);
		jbGuess.setFont(new Font("Algerian", Font.PLAIN, 18));
		jbGuess.setForeground(Color.WHITE);
		jbGuess.setEnabled(false);
		add(jbGuess);
		jbGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(demoTest.counter <= 4) {
					int guessNumber = Integer.parseInt(jtfNumber.getText());
					jtfNumber.setText("");
					boolean flag = compareNumber(guessNumber, randomNumber);
					if(flag == true) {
						demoTest.score += demoTest.decreaser;
						jlInstruction.setText(str);
						demoTest.randomNumber = randomNumber();
						jlScore.setText("Your score is " + demoTest.score);
					}
					else {
						demoTest.score -= demoTest.decreaser;
						jlInstruction.setText(str);
						jlScore.setText("Your score is " + demoTest.score);
					}
					demoTest.counter++;
					jlCounter.setText("Your " + demoTest.counter + " attempt.");
				}
				else {
					if(demoTest.score <= demoTest.winner) {
						JOptionPane.showMessageDialog(frame,"Game Over : Please click on play button again");
						jtfNumber.setVisible(false);
						jbGuess.setVisible(false);
						jbPlay.setVisible(true);
						jlInstruction.setText("Click on play to start the game.");
					}
					else {
						JDialog jd = new JDialog(frame,"Are you ready for next round ?");
						JLabel jl = new JLabel("Are you ready for next round ?");
						jl.setBounds(10,20,250,30);
						jl.setFont(new Font("Arial", Font.PLAIN, 18));
						jd.add(jl);
						
						JButton jbOkay = new JButton("Okay");
						jbOkay.setBounds(10,80,80,50);
						jd.add(jbOkay);
						jbOkay.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								setEnabled(true);
								demoTest.flag = true;
								jd.setVisible(false);
								jtfNumber.setText("");
								roundTwo r2 = new roundTwo();
								jlInstructionSet.setText("<html><head><body>" + demoTest.roundsContent);
								String scoreValue = Integer.toString(demoTest.score);
								jlScore.setText("Your Score " + scoreValue);
								jlCounter.setText("Your attempts!");
							}
						});
						
						JButton jbCancel = new JButton("Cancel");
						jbCancel.setBounds(100,80,80,50);
						jd.add(jbCancel);
						jbCancel.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								System.exit(ABORT);
							}
						});
						
						jd.setLayout(null);
						jd.setVisible(true);
						jd.setBounds(500,300,350,200);
						setEnabled(false);
					}
				}
			}
		});
		
		jbPlay = new JButton("Play Game");
		jbPlay.setBounds(160,250,180,30);
		jbPlay.setFont(new Font("Algerian", Font.PLAIN, 18));
		jbPlay.setBackground(Color.GREEN);
		jbPlay.setForeground(Color.BLACK);
		add(jbPlay);
		jbPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtfNumber.setEnabled(true);
				jbGuess.setEnabled(true);
				jbPlay.setEnabled(false);
				jlInstruction.setText("Guess a number between 1 to 100");
			}
		});
		
		Container c = getContentPane();
		c.setBackground(Color.DARK_GRAY);
				
		setTitle("Number Guessing Game");
		setLayout(null);
		setVisible(true);
		setBounds(500,300,1200,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}
	
	public static void main(String[] args) {
		new demoTest();
	}
	
	public static int randomNumber() {
		Random random = new Random();
		int number = random.nextInt(1,100);
		return number;
	}
	
	public static boolean compareNumber(int guessNumber, int numberGenerated) {
		if(guessNumber > numberGenerated) {
			demoTest.str = "<html><div>Your entered number is Greater</div><div> Hint: Please choose smaller number</div></html>";
			return false;
		}
		else if(guessNumber < numberGenerated) {
			demoTest.str = "<html><div>Your entered number is Smaller</div><div> Hint: Please choose Greater number</div></html>";
			return false;
		}
		else {
			demoTest.str = "<html><div>Your entered number is Correct</div></html>";
			return true;
		}
	}
	
	public static void nextRoundTwo() {
		roundTwo r2 = new roundTwo();
	}
	
}

class roundTwo{
	roundTwo(){
		demoTest.score = 30;
		demoTest.roundsContent = "<h1>Round 2</h1><p>Please read the instruction carefully...</p><br><br><p>1 :- You have only 5 attempts.<br><br><p>2 :- Each wrong try deduct your 5 points, So guess the number &nbsp &nbsp &nbsp &nbsp in Minumum try. </p><br><p>3 :- You need more than 30 point for clear this round. </p><br><br><p>4 :- We give you 50 points.</p></br><br><p>5 :- Your correct answer will give you 5 points.</p><br></body></head></html>";
		demoTest.counter = 0;
		demoTest.winner = 10;
		System.out.println("demoTest.score " + demoTest.score + "demoTest.roundsContent " + demoTest.roundsContent + "demoTest.counter " + demoTest.counter + "demoTest.winner " + demoTest.winner);
	}
}

