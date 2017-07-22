package com.HPapp.src;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.HPapp.src.MainClass;
import com.HPapp.src.input.KeyInput;
import com.HPapp.src.quiz.Quiz;

public class MainClass {
	public static JFrame frame = new JFrame();
	public static JPanel panel = new JPanel();
	public static JPanel main = new JPanel();
	//public static JPanel quiz = new JPanel();
	//public static JPanel duel = new JPanel();
	public static CardLayout card = new CardLayout();
	public static JButton buttonQuiz = new JButton("Quiz");
	public static JButton buttonDuel = new JButton("Let's Duel");
	public static Game game;
	public static Quiz quiz;
	
	
	public MainClass(){
		panel.setLayout(card);
		main.setLayout(new FlowLayout());
		main.add(buttonQuiz);
		main.add(buttonDuel);
		//quiz.setSize(1000,667);
		
		//duel.add(new Game()); add later
		//panel.add(quiz,"Quiz");
		//panel.add(game,"Duel");
		panel.add(main,"Main");
		card.show(panel,"Main");
	}
	
	public static void main(String[] args) {
		///Game game = new Game();

		new MainClass();
		frame.pack();
		//panel.setLayout(card);
		frame.setTitle("Main");
		
		frame.setSize(1000,667);
		frame.setResizable(false);
		//frame.pack(); //Jo canvas ka size hai uske size ke according fram ko size karo
		///frame.add(game);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		///main.add(buttonQuiz);
		///main.add(buttonDuel);
		
		frame.add(panel);
		frame.setVisible(true);
		frame.requestFocus();
		///frame.setVisible(true);
		buttonDuel.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent event){
				//frame.remove(buttonQuiz);
				//frame.remove(buttonDuel);
				/*
				frame.setTitle("Let's Duel");
				frame.remove(panel);
				Game game = new Game();
				
				frame.pack();
				frame.setTitle("Main");
				frame.setSize(1000,667);
				frame.setResizable(false);
				frame.add(game);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);*/
				//duel.add(new Game()); 
				frame.setTitle("Let's Duel");
				game = new Game();
				panel.add(game,"Duel");
				//game.addKeyListener(new KeyInput(p,c));
				//frame.requestFocus();
				card.show(panel,"Duel");
				
				
			}
			
		});


		buttonQuiz.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent event){
				/*
				frame.remove(buttonQuiz);
				frame.remove(buttonDuel);
				frame.setTitle("Quiz");
				//Quiz quiz = new Quiz();
				frame.setSize(1000,667);
				frame.setResizable(false);
				//frame.add(quiz);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				//frame.add(quiz);*/
				frame.setTitle("Quiz");
				quiz = new Quiz();
				panel.add(quiz,"Quiz");
				card.show(panel,"Quiz");
			}
			
		});
	
		
	}
}
