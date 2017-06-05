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
	private Item[] itm;

	private int xPos;
	private int yPos;
	private int dx;
	private int dy;

	public Player() {
		level = 0;
		knowledgePoints = 0;
		money = 10.0;
		energy = 0;
		strength = 9;
		time = 0;
		rep = 0;
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
	}

	public int getKnowledgePoints() {
		return knowledgePoints;
	}

	public void setKnowledgePoints(int knowledgePoints) {
		this.knowledgePoints += knowledgePoints;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money += money;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy += energy;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength += strength;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time += time;
	}

	public int getRep() {
		return rep;
	}

	public void setRep(int rep) {
		this.rep += rep;
	}

	public double getSocial() {
		return social;
	}

	public void setSocial(double social) {
		this.social += social;
	}



}
