package com.HPapp.src;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.HPapp.src.input.Controller;
import com.HPapp.src.input.KeyInput;
import com.HPapp.src.objects.Expell;
import com.HPapp.src.objects.Player;
import com.HPapp.src.objects.WandEnemy;

public class Game extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Boolean running = false;
	public static Boolean gameover = false;
	Timer timer;
	Player p;
	Controller c;
	WandEnemy we;
	private String bgImage = "/Images/harry-potter-deathly-hallows-symbol.jpg";

	public Game(){
		setFocusable(true);
		//requestFocus();
		running = true;
		timer = new Timer(10,this);
		timer.start();
		setFocusable(true);

		p = new Player(500,590);
		we = new WandEnemy(500,0);
		c = new Controller(p,we);
		//setFocusable(true);
		///requestFocus();
		try{
		addKeyListener(new KeyInput(p,c));
		System.out.println("Running");
		}
		catch(Exception e){
			System.out.println("Key listener not working");
			System.out.println(e);

		}
		System.out.println("GAME BEINGS");
		//setFocusable(true);
		requestFocus();
	}
	
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		//addKeyListener(new KeyInput(p,c)); 
		ImageIcon background = new ImageIcon(getClass().getResource(bgImage));
		g2d.drawImage(background.getImage(),0,0,null);
		if(running ==true){
		
		p.draw(g2d);
		we.draw(g2d);
		c.draw(g2d);
		c.printScores(g2d);}
		if(running == false)
			c.score( g2d);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if((Controller.Phealth>0 && Controller.WEhealth>0) && running== true && gameover==false){
		repaint();
		p.update();
		we.update(p);
		c.update();
		//mathematical bugs in shooting stupefy at 10 stamina
		//game over not getting printed
		//draw game over
		
		}
		if((Controller.Pstamina<=0 && Controller.WEstamina<=0)||Controller.Phealth<=0 || Controller.WEhealth<=0 )
			running = false;
		if(running == false && gameover == false)
			{repaint();
			
			gameover=true;
	}}
}
/*
1. we place wand and wandenemy on screen through game constructor
2.then we add action listener which waits for key events to move wand and wandenemy around
3.in paint we render the graphics onto the screen
4.then updates occur in actionperformed*/