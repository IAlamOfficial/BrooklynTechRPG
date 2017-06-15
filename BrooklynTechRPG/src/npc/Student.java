package npc;

import TechRPG.TechGame;

public class Student extends NPC {

	private String[] speech = {"Yo what's up?","How ya doing?","Hey.","What's good?","Get away from me please.","Go away.", "I don't want to be seen near you."};
	
	public Student(String name, int x, int y, String imageLocation){
		super(name, x, y, imageLocation);
		
	}
	
	public String getSpeech(){
		super.addTalkCount();
		int num = super.getTalkCount();
		if(num == 1){
			TechGame.getPlayer().setSocial(1);
			return "Hey my name is " + super.getName();
		}
		if(TechGame.getPlayer().getSocial() > 1.0){
			if(num < 10) return speech[(int) Math.random()*speech.length-3]; 
			else return speech[(int) Math.random()*2+5];
		}else{
			return speech[(int) Math.random()*2+6];
		}
	}

}
