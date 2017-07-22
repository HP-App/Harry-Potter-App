package com.HPapp.src.objects;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

import javax.swing.ImageIcon;

import com.HPapp.src.GlobalPos;
import com.HPapp.src.input.Controller;

public class Protego extends GlobalPos{

	private LinkedList<Expell> ep = Controller.getExpellBoundsP();
	private LinkedList<Stupefy> sp = Controller.getStupefyBoundsP();
	static LinkedList<Protego> pp = Controller.getProtegoBoundsP();
	private LinkedList<Expell> ewe = Controller.getExpellBounds();
	private LinkedList<Stupefy> swe = Controller.getStupefyBounds();
	static LinkedList<Protego> pwe = Controller.getProtegoBounds();
	
	ImageIcon i;
	private String enemyImage = "/Images/protego1.png";
	private int PprotegoCollision = 0;		
	private int WEprotegoCollision = 0;		
	public Protego(int x,int y){
		super(x,y);
	}

	
	
	
	public void update(Protego p){
		//y-=3;
		/*if( x > 1000 || x<0 || y<0 || y>667){
			
			//i.setImage(null);
			enemyImage = null;
		}*/
		if(PprotegoCollision == 3){
			Controller.removeProtegoP(p);}
		Pcollision();
		
	}
	
	private void Pcollision() {
		for(int j = 0; j<ewe.size(); j++){
			Rectangle r1 = getBounds();
			Expell TempP = ewe.get(j);
			Rectangle r2 = TempP.getBounds();
			if(r1.intersects(r2)){
				Controller.removeExpellWE(ewe.get(j));
				//System.out.println("PROTEGO UPDATE");
				PprotegoCollision++;
				
		}}
		for(int j = 0; j<swe.size(); j++){
			Rectangle r1 = getBounds();
			Stupefy TempP = swe.get(j);
			Rectangle r2 = TempP.getBounds();
			if(r1.intersects(r2)){
				Controller.removeStupefyWE(swe.get(j));
				PprotegoCollision++;		
				
		}}
		
	}
	
	private void WEcollision() {
		for(int j = 0; j<ep.size(); j++){
			Rectangle r1 = getBounds();
			Expell TempP = ep.get(j);
			Rectangle r2 = TempP.getBounds();
			if(r1.intersects(r2)){
				Controller.removeExpellP(ep.get(j));
				WEprotegoCollision++;
				
		}}
		for(int j = 0; j<sp.size(); j++){
			Rectangle r1 = getBounds();
			Stupefy TempP = sp.get(j);
			Rectangle r2 = TempP.getBounds();
			if(r1.intersects(r2)){
				Controller.removeStupefyP(sp.get(j));
				WEprotegoCollision++;
				
		}}
		
	}



               
	public void updatee(Protego p){
		//y+=3;
		/*if( x > 1000 || x<0 || y<0 || y>667){
			
			//i.setImage(null);
			enemyImage = null;
		}*/
		if(WEprotegoCollision == 3){
		Controller.removeProtegoWE(p);}
		WEcollision();
		//System.out.println("PROTEGO");
	}
	
	public void draw(Graphics2D g2d){
		if(enemyImage!=null){	
			i = new ImageIcon(getClass().getResource(enemyImage));
			g2d.drawImage(i.getImage(),x,y,null); 
		
	}}

	public Rectangle getBounds() {
		
		return new Rectangle(x,y,150,84);
	}
}
