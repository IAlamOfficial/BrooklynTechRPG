package npc;

import java.awt.Image;

public class NPC {
	
	private String name;
	private int talkCount;
	private String [] speech = {"Hello.", "Hi.", "What's up?", "Can you stop bothering me?", "I'm not talking to you anymore."};
	private int xPos;
	private int yPos;
	private Image image;
	
	
	
	public NPC(String name){
		this.name = name;
		talkCount = 0;
	}
	
	public String getSpeech(){
		talkCount ++;
		if(talkCount == 1) return "Hi my name is " + getName();
		else if(talkCount < 10) return speech[(int) Math.random()*speech.length-2];
		else if(talkCount < 15) return speech[3];
		else return speech[4];
		
	}

	public int getTalkCount() {
		return talkCount;
	}

	public void addTalkCount(){
		talkCount ++;
	}
	
	public String getName() {
		return name;
	}

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
}
