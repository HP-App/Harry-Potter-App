package com.HPapp.src.objects;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import javax.swing.ImageIcon;

import com.HPapp.src.GlobalPos;
import com.HPapp.src.input.Controller;

public class WandEnemy extends GlobalPos {

	public int velX=2;
	Controller c;
	//Boolean WEstupefyStatus = true;
	//Boolean expellStatus = true;
	private String playerImage = "/Images/wand2.png";
	private LinkedList<Expell> e = Controller.getExpellBoundsP();
	private LinkedList<Stupefy> s = Controller.getStupefyBoundsP();
	long time;
	Boolean collision = false;
	long Etime,Stime;
	Boolean Ecollision = false,Pcollision = false;
	
	public WandEnemy(int x,int y){
		super(x,y); 
	}
	
	public void update(Player p){
		if(Controller.WEstupefyStatus==true)
			{x+=velX;}
		
		//System.out.println("wand");
		//System.out.println(x);
		if (p.x==x)
			velX*=2;
		if (x<0)
			velX=1; 
			
		if (x>960)
			velX=-1;
		collision();
		if(Ecollision == true && Controller.WEexpellStatus == false){
			Etime++;
			//System.out.println("dsafdsfdfdsgfdsgfdgfdtime");
			}
		if(Pcollision == true && Controller.WEstupefyStatus == false){
			Stime++;
			//System.out.println("dsafdsfdfdsgfdsgfdgfdtime");
			}
		if(Etime==1000){
			Controller.WEexpellStatus = true;
			//Controller.PstupefyStatus = true;
			Ecollision = false;
			//Controller.Phealth-=10;
			Etime=0;
			System.out.println("WE can shoot");}
		if(Stime==1000){
			//Controller.PexpellStatus = true;
			Controller.WEstupefyStatus = true;
			//Controller.Phealth-=20;
			Pcollision = false;
			Stime=0;
			System.out.println("WE can move");}
}
	
	
	public void draw(Graphics2D g2d){
		ImageIcon i = new ImageIcon(getClass().getResource(playerImage));
		g2d.drawImage(i.getImage(),x,y,null);
		//System.out.println("draw");
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,40,51);}
	
	
	public void collision(){
		for(int j = 0;j < e.size(); j++){
			Rectangle r1 = getBounds();  //WandEenemy 
			Expell TempE = e.get(j);     //Player ka expelliarmus
			Rectangle r2 = TempE.getBounds();
			//System.out.println(e.size());
			if(r1.intersects(r2)){
				//if(collision!=true){
				//collision=true;
				//time=0;
				if(Ecollision == false)
					Controller.WEhealth-=10;
				Ecollision=true;
				System.out.println("Enemy collided with user expelliarmus");
				System.out.println("WEhealth="+Controller.WEhealth);
				Controller.WEexpellStatus = false;
				Controller.removeExpellP(e.get(j));
				
		}
	}
		for(int j1 = 0;j1 < s.size(); j1++){
			Rectangle r1 = getBounds();
			Stupefy TempS = s.get(j1);
			Rectangle r2 = TempS.getBounds();
			if(r1.intersects(r2)){
				//Pcollision=true;
				if(Pcollision==false)
					Controller.WEhealth-=20;
				Pcollision=true;
				System.out.println("Wand collided with user supefy");
				System.out.println("WEhealth="+Controller.WEhealth);
				Controller.removeStupefyP(s.get(j1));
				Controller.WEstupefyStatus = false;
		}	}
	}

	}
//same as player class