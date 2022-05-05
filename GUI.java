import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.lang.Math;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;

public class GUI {
	public JLabel title;
	public JFrame frame;
	public static Random rand;
	public char[] res;
	private JTextField length;
	private JTextField Resultt;
	public GUI() {
		Random rand = new Random();
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Yu Gothic UI Light", Font.BOLD, 11));
		frame.setSize(800,600);
		frame.setTitle("PassWord Generator");
		frame.getContentPane().setBackground(Color.black);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Password Generator");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setForeground(new Color(50, 205, 50));
		lblNewLabel.setBounds(286, 11, 218, 42);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter length of your password: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(new Color(50, 205, 50));
		lblNewLabel_1.setBounds(98, 161, 257, 33);
		frame.getContentPane().add(lblNewLabel_1);
		
		length = new JTextField();
		length.setBounds(354, 156, 164, 48);
		frame.getContentPane().add(length);
		length.setColumns(10);
		
		Resultt = new JTextField();
		Resultt.setBackground(new Color(0, 0, 0));
		Resultt.setForeground(new Color(50, 205, 50));
		Resultt.setFont(new Font("Tahoma", Font.BOLD, 19));
		Resultt.setBounds(286, 338, 263, 42);
		frame.getContentPane().add(Resultt);
		Resultt.setColumns(10);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		JButton button = new JButton("Generate");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num = Integer.parseInt(length.getText());
				res = generate(num);
				System.out.println(res);
				String x = String.valueOf(res);
				Resultt.setText(x);
			try {
				FileWriter myWriter = new FileWriter("Password.txt");
				myWriter.write(res);
				myWriter.close();
			}catch (IOException e1){
				System.out.println("An error occurred.");
			    e1.printStackTrace();
			}
		}
				
			
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button.setBounds(381, 232, 110, 42);
		frame.getContentPane().add(button);
		
		
		
		JLabel title = new JLabel("Titile");
		title.setText("Password Generator");
		title.setForeground(Color.green);
	}
	
	 private static char[] generate(int length) {
	      String cap = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	      String lower = "abcdefghijklmnopqrstuvwxyz";
	      String special = "!@#$&*^+=";
	      String numbers = "1234567890";
	      String combined = cap + lower + special + numbers;
	      Random random = new Random();
	      char[] password = new char[length];

	     password[0] = cap.charAt(random.nextInt(cap.length()));
	     password[1] = numbers.charAt(random.nextInt(numbers.length()));
	     password[2] = special.charAt(random.nextInt(special.length()));
	     
	   
	      for(int i = 3; i< length ; i++) {
	         password[i] = combined.charAt(random.nextInt(combined.length()));
	      }
	      return password;
	   }
	}

