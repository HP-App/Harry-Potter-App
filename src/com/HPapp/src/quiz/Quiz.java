package com.HPapp.src.quiz;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Quiz extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static JPanel panel = new JPanel();
	public static JPanel main = new JPanel();
	public static JPanel Q1 = new JPanel();
	public static JPanel Q2 = new JPanel();
	public static JPanel Q3 = new JPanel();
	public static JPanel Q4 = new JPanel();
	public static JPanel Q5 = new JPanel();
	public static CardLayout card = new CardLayout();
	
	public static int answer;
	public static JButton start = new JButton("Start Quiz");
	public static JButton b1 = new JButton("Next");
	public static JButton b2 = new JButton("Next");
	public static JButton b3 = new JButton("Next");
	public static JButton b4 = new JButton("Next");
	public static JButton b5 = new JButton("Calculate Result");
	private JRadioButton q1a = new JRadioButton("642",true);
	private JRadioButton q1b = new JRadioButton("742",true);
	private JRadioButton q1c = new JRadioButton("700",true);
	private JRadioButton q1d = new JRadioButton("600",true);
	private JRadioButton q2a = new JRadioButton("62242",true);
	private JRadioButton q2b = new JRadioButton("64424",true);
	private JRadioButton q2c = new JRadioButton("64224",true);
	private JRadioButton q2d = new JRadioButton("62442",true);
	private JRadioButton q3a = new JRadioButton("Rapier",true);
	private JRadioButton q3b = new JRadioButton("Royal",true);
	private JRadioButton q3c = new JRadioButton("Regal",true);
	private JRadioButton q3d = new JRadioButton("River",true);
	private JRadioButton q4a = new JRadioButton("Granite",true);
	private JRadioButton q4b = new JRadioButton("Beozar",true);
	private JRadioButton q4c = new JRadioButton("Moonstone",true);
	private JRadioButton q4d = new JRadioButton("Aconite",true);
	private JRadioButton q5a = new JRadioButton("556",true);
	private JRadioButton q5b = new JRadioButton("566",true);
	private JRadioButton q5c = new JRadioButton("565",true);
	private JRadioButton q5d = new JRadioButton("665",true);
	private ButtonGroup group1= new ButtonGroup();
	private ButtonGroup group2= new ButtonGroup();
	private ButtonGroup group3= new ButtonGroup();
	private ButtonGroup group4= new ButtonGroup();
	private ButtonGroup group5= new ButtonGroup();
	private JLabel q1 = new JLabel("How many Quidditch fouls exist?");
	private JLabel q2 = new JLabel("What number do you need to enter in the telephone to enter the Minitery of Magic?");
	private JLabel q3 = new JLabel("What is Fred's code name on Potterwatch?");
	private JLabel q4 = new JLabel("Monkswood and Wolfsbane are the same plant also known as what?");
	private JLabel q5 = new JLabel("How old was Nicholas Flamel before he died?");
	
	public Quiz(){
		this.setLayout(card);
		
		design();
		
		this.add(main,"Main");
		this.add(Q1,"Q1");
		this.add(Q2,"Q2");
		this.add(Q3,"Q3");
		this.add(Q4,"Q4");
		this.add(Q5,"Q5");
		
		card.show(this,"Main");
	}
	
	
	
	public void design(){
		main.setLayout(new FlowLayout());
		Q1.setLayout(new FlowLayout());
		Q2.setLayout(new FlowLayout());
		Q3.setLayout(new FlowLayout());
		Q4.setLayout(new FlowLayout());
		Q5.setLayout(new FlowLayout());
		
		main.setBackground(new Color(120,80,100));
		
		Q1.setBackground(new Color(0,100,100));
		Q2.setBackground(new Color(120,0,0));
		Q3.setBackground(new Color(0,80,0));
		Q4.setBackground(new Color(0,0,0));
		Q5.setBackground(new Color(255,100,255));
		
		/*
		q1.setLocation(500,324);
		q2.setLocation(500,324);
		q3.setLocation(500,324);
		q4.setLocation(500,324);
		q5.setLocation(500,324);
		*/
		q1.setForeground(Color.WHITE);
		q2.setForeground(Color.WHITE);
		q3.setForeground(Color.WHITE);
		q4.setForeground(Color.WHITE);
		q5.setForeground(Color.WHITE);
		
		start.setSize(20, 10);
		main.add(start);
		group1.add(q1a);
		group1.add(q1b);
		group1.add(q1c);
		group1.add(q1d);
		
		group2.add(q2a);
		group2.add(q2b);
		group2.add(q2c);
		group2.add(q2d);
		
		group3.add(q3a);
		group3.add(q3b);
		group3.add(q3c);
		group3.add(q3d);
		
		group4.add(q4a);
		group4.add(q4b);
		group4.add(q4c);
		group4.add(q4d);
		
		group5.add(q5a);
		group5.add(q5b);
		group5.add(q5c);
		group5.add(q5d);
		
		
		Q1.add(q1);
		Q1.add(q1a);
		Q1.add(q1b);
		Q1.add(q1c);
		Q1.add(q1d);
		Q1.add(b1);
		
		
		Q5.add(q5);
		Q5.add(q5a);
		Q5.add(q5b);
		Q5.add(q5c);
		Q5.add(q5d);
		Q5.add(b5);
		
		
		Q4.add(q4);
		Q4.add(q4a);
		Q4.add(q4b);
		Q4.add(q4c);
		Q4.add(q4d);
		Q4.add(b4);
		
		
		Q3.add(q3);
		Q3.add(q3a);
		Q3.add(q3b);
		Q3.add(q3c);
		Q3.add(q3d);
		Q3.add(b3);
		
		
		Q2.add(q2);
		Q2.add(q2a);
		Q2.add(q2b);
		Q2.add(q2c);
		Q2.add(q2d);
		Q2.add(b2);
		
		start.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				//JOptionPane.showMessageDialog(null,"");
				
				//card.show(this,"Q1");
				Q1();

				}

		});
	
	
	b1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			//JOptionPane.showMessageDialog(null,"");
			
			//card.show(this,"Q1");
			Q2();

			}

	});
	b2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			//JOptionPane.showMessageDialog(null,"");
			
			//card.show(this,"Q1");
			Q3();

			}

	});
	b3.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			//JOptionPane.showMessageDialog(null,"");
			
			//card.show(this,"Q1");
			Q4();

			}

	});
	b4.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			//JOptionPane.showMessageDialog(null,"");
			
			//card.show(this,"Q1");
			Q5();

			}

	});
	b5.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			//JOptionPane.showMessageDialog(null,"");
			
			//card.show(this,"Q1");
			calculate();

			}

	});
}




	
	protected void Q1() {
		// TODO Auto-generated method stub
		card.show(this,"Q1");
	}
	protected void Q2() {
		// TODO Auto-generated method stub
		card.show(this,"Q2");
	}
	protected void Q3() {
		// TODO Auto-generated method stub
		card.show(this,"Q3");
	}
	protected void Q4() {
		// TODO Auto-generated method stub
		card.show(this,"Q4");
	}
	protected void Q5() {
		// TODO Auto-generated method stub
		card.show(this,"Q5");
	}

	public void calculate(){
		if(q1c.isSelected())
			answer++;
		if(q2d.isSelected())
			answer++;
		if(q3a.isSelected())
			answer++;
		if(q4d.isSelected())
			answer++;
		if(q5d.isSelected())
			answer++;
	
		JOptionPane.showMessageDialog(null,"You got "+answer+"/5 correct");
	}

}
