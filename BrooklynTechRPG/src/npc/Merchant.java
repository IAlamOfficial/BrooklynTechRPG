package npc;

public class Merchant extends Student{

	public Merchant(String name, int x, int y, String imageLocation){
		super(name, x, y, imageLocation);
	}

	public String getSpeech(){
		return "What would you like to buy?";
		
	}
	//TODO IDK HOW WE CAN MAKE THE MERCHANT WORK
}
