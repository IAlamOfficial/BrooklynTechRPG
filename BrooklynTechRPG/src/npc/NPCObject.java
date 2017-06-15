package npc;

public class NPCObject extends NPC {

	public NPCObject(String name, int x, int y, String imageLocation){
		super(name, x, y, imageLocation);
		
	}
	public String getSpeech(){
		return "Why am I talking to an inanimate object?";
		
	}
}
