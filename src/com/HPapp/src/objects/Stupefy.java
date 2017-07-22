package com.HPapp.src.objects;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import com.HPapp.src.GlobalPos;
import com.HPapp.src.input.Controller;

public class Stupefy extends GlobalPos{

	
	ImageIcon i;
	private String enemyImage = "/Images/stupefy.png";
	
	public Stupefy(int x,int y){
		super(x,y);
	}

	public void update(Stupefy e){
		y-=3;
		if( x > 1000 || x<0 || y<0 || y>667){
		Controller.removeStupefyP(e);
		}
	}
	
	public void updatee(Stupefy e){
		y+=3;
		if( x > 1000 || x<0 || y<0 || y>667){
			Controller.removeStupefyWE(e);
	}}
	
	public void draw(Graphics2D g2d){
		if(enemyImage!=null){	
			i = new ImageIcon(getClass().getResource(enemyImage));
			g2d.drawImage(i.getImage(),x,y,null); 
		
	}}

	public Rectangle getBounds() {
		
		return new Rectangle(x,y,20,82);
	}
}
