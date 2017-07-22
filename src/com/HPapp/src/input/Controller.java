package com.HPapp.src.input;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import javax.swing.ImageIcon;

import com.HPapp.src.objects.Expell;
import com.HPapp.src.objects.Player;
import com.HPapp.src.objects.Protego;
import com.HPapp.src.objects.Stupefy;
import com.HPapp.src.objects.WandEnemy;

public class Controller {

	static LinkedList<Expell> ep = new LinkedList<Expell>();
	static LinkedList<Expell> ewe = new LinkedList<Expell>();
	
	public static int Phealth = 50;
	public static int WEhealth = 50;
	public static int Pstamina = 100;
	public static int WEstamina  = 100;
	
	
	Expell TempExpellEnemyP,TempExpellEnemy;
	WandEnemy we;
	Player p;
	private int expelliarmus=0;
	public static Boolean WEexpellStatus = true;
	public static Boolean PexpellStatus = true;
	public static Boolean WEstupefyStatus = true;
	public static Boolean PstupefyStatus = true;
	//public static Boolean WEprotegoStatus = true;
	//public static Boolean PprotegoStatus = true;

	static LinkedList<Protego> pp = new LinkedList<Protego>();
	static LinkedList<Protego> pwe = new LinkedList<Protego>();
	
	Protego TempProtegoEnemyP,TempProtegoEnemy;
	private int protego=0;
	
	static LinkedList<Stupefy> sp = new LinkedList<Stupefy>();
	static LinkedList<Stupefy> swe = new LinkedList<Stupefy>();
	
	Stupefy TempStupefyEnemyP,TempStupefyEnemy;
	private int stupefy=0;
	
	public Controller(Player p, WandEnemy we){
		this.p=p;
		this.we = we;
	}
	
	public void draw(Graphics2D g2d){
		for(int i=0; i<ep.size(); i++){
			TempExpellEnemyP = ep.get(i);
			TempExpellEnemyP.draw(g2d);
			}
		for(int i=0; i<ewe.size(); i++){
			TempExpellEnemy = ewe.get(i);
			TempExpellEnemy.draw(g2d);
			//System.out.println("drawn");
			}
		
		
		for(int i=0; i<pp.size(); i++){
			TempProtegoEnemyP = pp.get(i);
			TempProtegoEnemyP.draw(g2d);
			}
		for(int i=0; i<pwe.size(); i++){
			TempProtegoEnemy = pwe.get(i);
			TempProtegoEnemy.draw(g2d);
			//System.out.println("drawn");
			}
		
		
		for(int i=0; i<sp.size(); i++){
			TempStupefyEnemyP = sp.get(i);
			TempStupefyEnemyP.draw(g2d);
			}
		for(int i=0; i<swe.size(); i++){
			TempStupefyEnemy = swe.get(i);
			TempStupefyEnemy.draw(g2d);
			//System.out.println("drawn");
			}
		}
		
	public void update(){
		for(int i=0; i<ep.size(); i++){
			TempExpellEnemyP = ep.get(i);
			TempExpellEnemyP.update(ep.get(i));
		}
		for(int i=0; i<ewe.size(); i++){
			TempExpellEnemy = ewe.get(i);
			TempExpellEnemy.updatee(ewe.get(i));
			//System.out.println(ewe.size());
		}
		
		
		for(int i=0; i<pp.size(); i++){
			TempProtegoEnemyP = pp.get(i);
			TempProtegoEnemyP.update(pp.get(i));
		}
		for(int i=0; i<pwe.size(); i++){
			TempProtegoEnemy = pwe.get(i);
			TempProtegoEnemy.updatee(pwe.get(i));
			//System.out.println(ewe.size());
		}
		
		
		for(int i=0; i<sp.size(); i++){
			TempStupefyEnemyP = sp.get(i);
			TempStupefyEnemyP.update(sp.get(i));
		}
		for(int i=0; i<swe.size(); i++){
			TempStupefyEnemy = swe.get(i);
			TempStupefyEnemy.updatee(swe.get(i));
			//System.out.println(ewe.size());
		}
		expelliarmus++;
		protego++;
		stupefy++;
		moveExpell(); //method for wandenemeys expelliarmus
		moveStupefy();	
		}
	
	private void moveExpell() {
		//System.out.println(expelliarmus);
		
		if((expelliarmus%257==0)&&((((we.velX<0)&&(p.velX>0))||((we.velX>0)&&(p.velX<0))))&&(WEexpellStatus == true)&& (WEstupefyStatus==true)&& WEstamina>5){
			//addEnemy(new Expell(we.x,we.y));
			ewe.add(new Expell(we.x,we.y));
			WEstamina-=10;
			System.out.println("WEstamina="+WEstamina);
		}

		
	}
	
	private void moveStupefy() {
		//System.out.println(expelliarmus);
		
		if((stupefy%587==0)&&((((we.velX<0)&&(p.velX>0))||((we.velX>0)&&(p.velX<0))))&&(WEexpellStatus == true)&& (WEstupefyStatus==true)&& WEstamina>10){
			//addEnemy(new Expell(we.x,we.y));
			swe.add(new Stupefy(we.x,we.y));
			WEstamina-=20;
			System.out.println("WEstamina="+WEstamina);
		}

		
	}
	
	private void moveProtego() {
		if((protego%1000==0 && WEexpellStatus == true && WEstupefyStatus==true && WEstamina>0)){
			//addEnemy(new Expell(we.x,we.y));
			pwe.add(new Protego(we.x+40,we.y+51));
			WEstamina-=5;
			System.out.println("WEstamina="+WEstamina);
			
		}

		
	}

	public static LinkedList<Expell> getExpellBoundsP(){
		return ep;
	}
	
	public static LinkedList<Expell> getExpellBounds(){
		return ewe;
	}
	
	public static LinkedList<Protego> getProtegoBoundsP(){
		return pp;
	}
	
	public static LinkedList<Protego> getProtegoBounds(){
		return pwe;
	}
	
	public static LinkedList<Stupefy> getStupefyBoundsP(){
		return sp;
	}
	
	public static LinkedList<Stupefy> getStupefyBounds(){
		return swe;
	}
	
	public void addExpellP(Expell expell){
		ep.add(expell);
		//System.out.println("enemy added");
		Pstamina-=10;
		System.out.println("Pstamina="+Pstamina);
	}
	
	public static void removeExpellP(Expell expell){
		/*Expell Temp=e.get(i+1);
		enemy = Temp;
		
		for(int j = i+2;j<e.size();j++)
		{
			Temp = e.get(j);
			e.get(j-1)=Temp;
		}*/
		ep.remove(expell);
		System.out.println("Player Expell REMOVED ");
	}
	
	public static void removeExpellWE(Expell expell){
		
		ewe.remove(expell);
		System.out.println("Expell REMOVED ");
	}
	
	public void addStupefyP(Stupefy stupefy){
		
		sp.add(stupefy);
		//System.out.println("enemy added");
		Pstamina-=20;
		System.out.println("Pstamina="+Pstamina);
	}
	
	public static void removeStupefyP(Stupefy stupefy){
		sp.remove(stupefy);
		System.out.println("Player Stupefy REMOVED ");
	}
	
	public static void removeStupefyWE(Stupefy stupefy){
		
		swe.remove(stupefy);
		System.out.println("Stupefy REMOVED ");
	}
	public void keyPressed(KeyEvent e){ //to add objects from player side
		int key = e.getKeyCode();
		//System.out.println("wand pressed");
		
		if(key == KeyEvent.VK_W && PexpellStatus == true && PstupefyStatus==true && Pstamina>5){
			//System.out.println("wand pressed");
			addExpellP(new Expell(p.x,p.y));
			}
		if(key == KeyEvent.VK_R && PexpellStatus == true && PstupefyStatus==true && Pstamina>0){
			//System.out.println("wand pressed");
			addProtegoP(new Protego(p.x-40,p.y-51));
			}
		if(key == KeyEvent.VK_S && PexpellStatus == true && PstupefyStatus==true && Pstamina>10){
			//System.out.println("wand pressed");
			addStupefyP(new Stupefy(p.x,p.y));
			}
		//if(Pstamina<=0)
		//{System.out.println("Can't shoot. Stamina is zero");}
			
	}
	
	public void addProtegoP(Protego protego){
		pp.add(protego);
		//System.out.println("enemy added");
		Pstamina-=5;
		System.out.println("Pstamina="+Pstamina);
	}
	
	public static void removeProtegoP(Protego protego){
		pp.remove(protego);
		System.out.println("Player Protego REMOVED ");
	}
	
	public static void removeProtegoWE(Protego protego){
		
		pwe.remove(protego);
		System.out.println("Protego REMOVED ");
	}

	
	public void printScores(Graphics2D g2d){
		//i = new ImageIcon(getClass().getResource(playerImage));
		if(WEstamina<=0)
			WEstamina=0;
		if(Pstamina<=0)
			Pstamina=0;
		g2d.setColor(new Color(255,255,255));
		g2d.drawRect(1, 310, 100, 65);
		g2d.drawString("Phealth "+Phealth,5,325);
		g2d.drawString(" WEhealth "+WEhealth,5,340);
		g2d.drawString(" Pstamina "+Pstamina,5,355);
		g2d.drawString(" WEstamina "+WEstamina,5,370);
		
	}
	public void score(Graphics2D g2d) {
		if(WEstamina<=0)
			WEstamina=0;
		if(Pstamina<=0)
			Pstamina=0;
		System.out.println("GAME OVER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		g2d.setColor(Color.WHITE);
		g2d.drawString("GAME OVER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!",350,325);
		if(Phealth<=0){
			System.out.println("YOU LOSE");
			g2d.drawString("YOU LOSE",490,340);}
		if(WEhealth<=0){
			System.out.println("YOU WIN");
			g2d.drawString("YOU WIN",490,340);}
		if((Pstamina<=0&&WEstamina<=0)&&(Phealth>0 && WEhealth>0)){
			System.out.println("TIE");
			g2d.drawString("TIE",490,340);}
		System.out.println("SCORES");
		System.out.println("");
		System.out.println("Pstamina="+Pstamina);
		System.out.println("WEstamina="+WEstamina);
		System.out.println("Phealth="+Phealth);
		System.out.println("WEhealth="+WEhealth);
		g2d.drawString("Scores",490,355);
		g2d.drawString("Pstamina="+Pstamina,490,370);
		g2d.drawString("WEstamina="+WEstamina,490,385);
		g2d.drawString("Phealth="+Phealth,490,400);
		g2d.drawString("WEhealth="+WEhealth,490,415);
		
	}
	
	
		
			
	}
//to add array of spells