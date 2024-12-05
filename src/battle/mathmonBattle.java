package battle;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.mathmonGamePanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class mathmonBattle extends JFrame {
	public static final int CANVAS_WIDTH = 400;
	public static final int CANVAS_HEIGHT = 140;
	public int enemyHealth = 100;//temporary

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public int battleChoice = 0, questionCount = 0, randomNum, attackDamage; //0 if wala pa, 1 if fight, 2 if power up
	public String questions[] = new String[40], answers[] = new String[40], answerInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mathmonBattle frame = new mathmonBattle();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public mathmonBattle() throws IOException {
		importQuestions();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(0, 450, 786, 150);
		contentPane.add(buttonPanel);
		buttonPanel.setLayout(null);
		
		JButton btnAttack1 = new JButton("QUICK ATTACK");
		btnAttack1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				randomNum = 0 + (int) (Math.random() * (((9) - 0) + 1));
				answerInput = JOptionPane.showInputDialog(questions[randomNum]);
				attackInput(answerInput, randomNum);
				//System.out.println(answerInput + "\n" + answers[randomNum]);
				//System.out.println(questions[randomNum]/* + " " + randomNum*/);
				//System.out.println(answers[randomNum]);
				//answer form class
			}
		});
		btnAttack1.setFont(new Font("Arial", Font.PLAIN, 20));
		btnAttack1.setBounds(10, 10, 240, 60);
		buttonPanel.add(btnAttack1);
		
		JButton btnAttack2 = new JButton("HEADBUTT");
		btnAttack2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				randomNum = 10 + (int) (Math.random() * (((19) - 10) + 1));
				answerInput = JOptionPane.showInputDialog(questions[randomNum]);
				attackInput(answerInput, randomNum);
			}
		});
		btnAttack2.setFont(new Font("Arial", Font.PLAIN, 20));
		btnAttack2.setBounds(255, 10, 240, 60);
		buttonPanel.add(btnAttack2);
		
		JButton btnAttack3 = new JButton("MEGA PUNCH");
		btnAttack3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				randomNum = 20 + (int) (Math.random() * (((29) - 20) + 1));
				answerInput = JOptionPane.showInputDialog(questions[randomNum]);
				attackInput(answerInput, randomNum);
			}
		});
		btnAttack3.setFont(new Font("Arial", Font.PLAIN, 20));
		btnAttack3.setBounds(10, 75, 240, 60);
		buttonPanel.add(btnAttack3);
		
		JButton btnAttack4 = new JButton("HYPER BEAM");
		btnAttack4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				randomNum = 30 + (int) (Math.random() * (((39) - 30) + 1));
				answerInput = JOptionPane.showInputDialog(questions[randomNum]);
				attackInput(answerInput, randomNum);
			}
		});
		btnAttack4.setFont(new Font("Arial", Font.PLAIN, 20));
		btnAttack4.setBounds(255, 75, 240, 60);
		buttonPanel.add(btnAttack4);
		
		JButton btnFight = new JButton("FIGHT");
		btnFight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				battleChoice = 1;
				
			}
		});
		btnFight.setFont(new Font("Arial", Font.PLAIN, 20));
		btnFight.setBounds(505, 10, 130, 125);
		buttonPanel.add(btnFight);
		
		JButton btnPowerUp = new JButton("POWER UP");
		btnPowerUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				battleChoice = 2;
			}
		});
		btnPowerUp.setFont(new Font("Arial", Font.PLAIN, 20));
		btnPowerUp.setBounds(645, 10, 130, 125);
		buttonPanel.add(btnPowerUp);
		
		JButton btnSurge = new JButton("\nSURGE");
		btnSurge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSurge.setFont(new Font("Arial", Font.PLAIN, 20));
		btnSurge.setBounds(10, 10, 155, 125);
		buttonPanel.add(btnSurge);
		
		JButton btnTime = new JButton("TIME");
		btnTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTime.setFont(new Font("Arial", Font.PLAIN, 20));
		btnTime.setBounds(340, 10, 155, 125);
		buttonPanel.add(btnTime);
		
		JButton btnHeal = new JButton("HEAL");
		btnHeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHeal.setFont(new Font("Arial", Font.PLAIN, 20));
		btnHeal.setBounds(175, 10, 155, 125);
		buttonPanel.add(btnHeal);
		
		JPanel battlePanel = new JPanel();
		battlePanel.setBounds(0, 0, 800, 450);
		contentPane.add(battlePanel);
		battlePanel.setLayout(null);
		
		JLabel lblPlayer = new JLabel("");
		lblPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer.setIcon(new ImageIcon("C:\\Users\\vince\\Eclipse - Jaramilla\\mathmonGame\\res\\player\\girl_right_2.png"));
		lblPlayer.setBounds(200, 304, 181, 136);
		battlePanel.add(lblPlayer);

		JLabel lblEnemy = new JLabel("");
		lblEnemy.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnemy.setIcon(new ImageIcon("C:\\Users\\vince\\Eclipse - Jaramilla\\mathmonGame\\res\\objects\\imp.png"));
		lblEnemy.setBounds(575, 124, 181, 136);
		battlePanel.add(lblEnemy);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setVerticalAlignment(SwingConstants.CENTER);
		lblBackground.setIcon(new ImageIcon("C:\\Users\\vince\\Eclipse - Jaramilla\\mathmonGame\\res\\battle\\terrain.jpg"));
		lblBackground.setBounds(0, 0, 800, 450);
		battlePanel.add(lblBackground);
		
		Thread battleThread = new Thread() {
	         @Override
	         public void run() {
	            while (true) {
	               update(btnAttack1, btnAttack2, btnAttack3, btnAttack4, btnSurge, btnHeal, btnTime);   // update the (x, y) position
	               repaint();  // Refresh the JFrame. Called back paintComponent()
	               try {
	                  // Delay and give other thread a chance to run
	                  Thread.sleep(1000/60);  // milliseconds
	               } catch (InterruptedException ignore) {}
	            }
	         }
	      };
		battleThread.start();
	}
	
	public void update(JButton btn1, JButton btn2, JButton btn3, JButton btn4, JButton btn5, JButton btn6, JButton btn7) {
		if(battleChoice==0) {
	    	 btn1.setVisible(false);
	    	 btn2.setVisible(false);
	    	 btn3.setVisible(false);
	    	 btn4.setVisible(false);
	    	 btn5.setVisible(false);
	    	 btn6.setVisible(false);
	    	 btn7.setVisible(false);
	    }else if(battleChoice==1) {
	    	 btn1.setVisible(true);
	    	 btn2.setVisible(true);
	    	 btn3.setVisible(true);
	    	 btn4.setVisible(true);
	    	 btn5.setVisible(false);
	    	 btn6.setVisible(false);
	    	 btn7.setVisible(false);
	    }else if(battleChoice==2) {
	    	 btn1.setVisible(false);
	    	 btn2.setVisible(false);
	    	 btn3.setVisible(false);
	    	 btn4.setVisible(false);
	    	 btn5.setVisible(true);
	    	 btn6.setVisible(true);
	    	 btn7.setVisible(true);
	    }
	}
	
	public void importQuestions()  throws IOException {
		BufferedReader input1 = new BufferedReader (new FileReader("C:\\Users\\vince\\Eclipse - Jaramilla\\mathmonGame\\res\\battle\\questions.txt"));
		String question = input1.readLine();
		BufferedReader input2 = new BufferedReader (new FileReader("C:\\Users\\vince\\Eclipse - Jaramilla\\mathmonGame\\res\\battle\\answers.txt"));
		String answer = input2.readLine();
		
		while(questionCount<40) {
			questions[questionCount] = question;	
			answers[questionCount] = answer;	
			question = input1.readLine();
			answer = input2.readLine();
			questionCount++;
		}
		input1.close();
		input2.close();
	}
	
	public void attackInput(String answer, int random) {
		if(answer.equals(answers[random])) {
			if(random >= 0 && random <= 9) {
				attackDamage = 20;
			}else if(random >= 10 && random <= 19) {
				attackDamage = 30;
			}else if(random >= 20 && random <= 29) {
				attackDamage = 40;
			}else {
				attackDamage = 50;
			}
		}else {
			attackDamage = 0;
		}
		//System.out.println("You dealt " + attackDamage + " damage!\n The enemy has " + enemyHealth + " remaining.");
		enemyHealth -= attackDamage;
		System.out.println("You dealt " + attackDamage + " damage!\nThe enemy has " + enemyHealth + " HP remaining.");
	}
}
