package npc;

public class Bully extends Student {

	private int strength;
	private boolean beaten;
	public Bully(String name, int x, int y, String imageLocation, int str){
		super(name, x, y, imageLocation);
		strength = str;
		beaten = false;
	}
	
	
	public String getSpeech(){
		if(beaten) return "Leave me alone T-T";
		else return "Beat it if you know what's good for you";
	}

	public boolean fight(int strength){
		if(strength > this.strength) beaten = true;
		return beaten;
		
	}
}