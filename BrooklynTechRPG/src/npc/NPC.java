package npc;

import java.awt.Image;

import javax.swing.ImageIcon;

import guiTeacher.components.ClickableGraphic;

public class NPC extends ClickableGraphic{
	
	private String name;
	private int talkCount;
	private String [] speech = {"Hello.", "Hi.", "What's up?", "Can you stop bothering me?", "I'm not talking to you anymore."};
	private int xPos;
	private int yPos;
	private Image image;
	
	
	
	public NPC(String name, int x, int y, String imageLocation){
		super(x, y, imageLocation);
		this.name = name;
		talkCount = 0;
		initNPC(x, y,imageLocation);
	}
	
	private void initNPC(int x, int y, String imageLocation) {
		ImageIcon player = new ImageIcon(imageLocation);
		image = player.getImage();
		xPos = x;
		yPos = y;
		
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
	
}
