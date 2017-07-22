package com.HPapp.src.input;

import java.awt.event.*;


import com.HPapp.src.objects.Player;
import com.HPapp.src.objects.WandEnemy;
 
public class KeyInput extends KeyAdapter{
	Player p;
	WandEnemy we;
	Controller c;
	
	public KeyInput(Player p,Controller c){
		this.p = p;
		this.c=c;
		//System.out.println("key");
		//this.we=we;
	}
	
	public void keyReleased(KeyEvent e){
		p.keyReleased(e);
		
		//we.keyReleased(e);
		//System.out.println("relased");
	}
	
	public void keyPressed(KeyEvent e){
		p.keyPressed(e);
		c.keyPressed(e);
		//System.out.println("pressed");
		//we.keyPressed(e);
	}
}
//common class handling key events of all objects of game
