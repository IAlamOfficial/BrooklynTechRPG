package player;

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
	private int social;
	
	public Player() {
		level = 0;
		knowledgePoints = 0;
		money = 0.0;
		energy = 0;
		strength = 0;
		time = 0;
		rep = 0;
		social = 0;
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

	public int getSocial() {
		return social;
	}

	public void setSocial(int social) {
		this.social += social;
	}

	

}
