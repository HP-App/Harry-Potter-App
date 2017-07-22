package com.HPapp.src.objects;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import javax.swing.ImageIcon;

import com.HPapp.src.GlobalPos;
import com.HPapp.src.input.Controller;

public class Player extends GlobalPos {

	
	public int velX=0;
	Controller c;
	ImageIcon i; 
	private LinkedList<Expell> e = Controller.getExpellBounds();
	private LinkedList<Stupefy> s = Controller.getStupefyBounds();
	
	private String playerImage = "/Images/wand1.png";
	long Etime,Stime;
	Boolean Ecollision = false,Pcollision = false;
	public Player(int x,int y){
		super(x,y); 
		
	}
	
	public void update(){
		
		if(Controller.PstupefyStatus==true)
			{x+=velX;
			//System.out.println("PLAYER ENETRED");
			}
		//y+=velY;
		if (x<0)
			x=0;/*
		if (y<0)
			y=0;*/
		if (x>960)
			x=960;
		/*
		if (y>376)
			y=376;*/
		collision();
		if(Ecollision == true && Controller.PexpellStatus == false){
			Etime++;
			//System.out.println("dsafdsfdfdsgfdsgfdgfdtime");
			}
		if(Pcollision == true && Controller.PstupefyStatus == false){
			Stime++;
			//System.out.println("dsafdsfdfdsgfdsgfdgfdtime");
			}
		if(Etime==1000){
			Controller.PexpellStatus = true;
			//Controller.PstupefyStatus = true;
			Ecollision = false;
			//Controller.Phealth-=10;
			Etime=0;
			System.out.println("Player can shoot");}
		if(Stime==1000){
			//Controller.PexpellStatus = true;
			Controller.PstupefyStatus = true;
			//Controller.Phealth-=20;
			Pcollision = false;
			Stime=0;
			System.out.println("Player can move");}
		
	}
	
	public void collision(){
		for(int j = 0;j < e.size(); j++){
			Rectangle r1 = getBounds();
			Expell TempE = e.get(j);
			Rectangle r2 = TempE.getBounds();
			//System.out.println(e.size());
			if(r1.intersects(r2)){
				//if(collision!=true){
				//Ecollision=true;
				//time=0; //if another spell collides with player before first collision time is over
				//if(Controller.PstupefyStatus == false)
				if(Ecollision==false)
					Controller.Phealth-=10;
				Ecollision=true;
				System.out.println("User collided with wand enemy expelliarmus");
				System.out.println("Phealth="+Controller.Phealth);
				Controller.removeExpellWE(e.get(j));
				Controller.PexpellStatus = false;
				/*
				Thread t = new Thread(this);
				t.start();
				try {
					t.sleep(5000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				//Controller.PexpellStatus = true;
				//System.out.println(e.size());
			}}
			for(int j1 = 0;j1 < s.size(); j1++){
				Rectangle r1 = getBounds();
				Stupefy TempS = s.get(j1);
				Rectangle r2 = TempS.getBounds();
				if(r1.intersects(r2)){
					//Pcollision=true;
					if(Pcollision==false)
						Controller.Phealth-=20;
					Pcollision=true;
					System.out.println("User collided with wand enemy supefy");
					System.out.println("Phealth="+Controller.Phealth);
					Controller.removeStupefyWE(s.get(j1));
					Controller.PstupefyStatus = false;
			}	}
			
			}

	public Rectangle getBounds() {
		return new Rectangle(x,y,40,51);}
			
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_RIGHT){
			velX= 2;
			//System.out.println("ARROW");
		}
		
		if(key == KeyEvent.VK_LEFT){
			velX= -2;
			//System.out.println("w");
			//c = new Controller(p);
		}
			
	}

	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_RIGHT){
			velX= 0;
		}
		if(key == KeyEvent.VK_LEFT){
			velX= 0;
		}
	}
	
	public void draw(Graphics2D g2d){
		i = new ImageIcon(getClass().getResource(playerImage));
		g2d.drawImage(i.getImage(),x,y,null);
		//System.out.println("draw");
	}

	}
//based on key events player class changes the position of wand in every update