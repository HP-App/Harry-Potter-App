package com.HPapp.src.objects;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

import com.HPapp.src.GlobalPos;
import com.HPapp.src.input.Controller;

public class Expell extends GlobalPos{

	
	ImageIcon i;
	private String enemyImage = "/Images/expel.png";
	
	public Expell(int x,int y){
		super(x,y);
	}

	public void update(Expell e){
		y-=3;
		if( x > 1000 || x<0 || y<0 || y>667){
			
			//i.setImage(null);
			//enemyImage = null;
			Controller.removeExpellP(e);
			
		}
		
	}
	
	public void updatee(Expell e){
		y+=3;
		if( x > 1000 || x<0 || y<0 || y>667){
			
			//i.setImage(null);
			//enemyImage = null;
			Controller.removeExpellWE(e);
		}
		
	}
	
	public void draw(Graphics2D g2d){
		if(enemyImage!=null){	
			i = new ImageIcon(getClass().getResource(enemyImage));
			g2d.drawImage(i.getImage(),x,y,null);
		
	}}

	public Rectangle getBounds() {
		
		return new Rectangle(x,y,40,48);
	}
}
//adds and moves spells 
//har expell object ka behaviour idhar defined hai