package player;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import items.Item;

public class Player {

	/*
	 * Player stats 
	 */

	private int level;
	private int knowledgePoints;
	private double money;
	private int energy;
	private int strength;
	private int time;
	private int rep;
	private double social;

	private int hw;
	public Item[] itm;
	
	

	public Player() {
		level = 0;
		knowledgePoints = 0;
		money = 10.0;
		energy = 25;
		strength = 5;
		time = 10;
		rep = 10;
		social = 1.0;
		initPlayer();

		//		itm = {new AlarmClock()};
	}

	public void update(Graphics2D g) {
		String[] playerMovement = {"resources/playerup","resources/playerdown",
				"resources/playerleft","resources/playerright"};
	}
	
	public void initPlayer(){
		ImageIcon player = new ImageIcon("resources/playerup");
	}

	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			dx = -1;
		}

		if (key == KeyEvent.VK_RIGHT) {
			dx = 1;
		}

		if (key == KeyEvent.VK_UP) {
			dy = -1;
		}

		if (key == KeyEvent.VK_DOWN) {
			dy = 1;
		}
	}

	public void keyReleased(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			dx = 0;
		}

		if (key == KeyEvent.VK_RIGHT) {
			dx = 0;
		}

		if (key == KeyEvent.VK_UP) {
			dy = 0;
		}

		if (key == KeyEvent.VK_DOWN) {
			dy = 0;
		}
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level += level;
		if(this.level<0) this.level = 0;
	}

	public int getKnowledgePoints() {
		return knowledgePoints;
	}

	public void setKnowledgePoints(int knowledgePoints) {
		this.knowledgePoints += knowledgePoints;
		if(this.knowledgePoints<0) this.knowledgePoints = 0;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money += money;
		if(this.money<0.0) this.money = 0.0;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy += energy;
		if(this.energy<0) this.energy = 0;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength += strength;
		if(this.strength<0) this.strength = 0;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time += time;
		if(this.time<0) this.time = 0;
	}

	public int getRep() {
		return rep;
	}

	public void setRep(int rep) {
		this.rep += rep;
		if(this.rep<0) this.rep = 0;
		if(this.rep>50) this.rep = 50;
	}

	public double getSocial() {
		return social;
	}

	public void setSocial(double social) {
		this.social += social;
		if(this.social<0.01) this.social = 0.01;
	}

	public int getHw() {
		return hw;
	}

	public void setHw(int hw) {
		this.hw += hw;
		if(this.hw<0) this.hw = 0;
		
	}



}
