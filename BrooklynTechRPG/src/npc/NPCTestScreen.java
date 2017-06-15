package npc;

import java.util.List;

import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import items.Coffee;

public class NPCTestScreen extends FullFunctionScreen{

	private Bully bully;
	private Merchant mer;
	private Coffee coffee;

	
	
	public NPCTestScreen(int width, int height) {
		super(width, height);
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		bully = new Bully("Bully", 10);
		mer = new Merchant("Merchant");
//		coffee = new Coffee(10,10,100,100);
		
		
		TextArea area = new TextArea(50,50,300,200,"");
		viewObjects.add(area);
		
		NPCEvent event = new NPCEvent(DemoForNPC.player, bully, area);
		NPCEvent event1 = new NPCEvent(DemoForNPC.player, mer, area, coffee);
		
		NPCController npcCon = new NPCController(getWidth(), getHeight(),event, DemoForNPC.player);
		NPCController npcCon1 = new NPCController(getWidth(), getHeight(),event1, DemoForNPC.player);
		
		viewObjects.add(DemoForNPC.player);
		viewObjects.add(npcCon);
		//viewObjects.add(npcCon1);
		
		Thread interact = new Thread(event);
		//Thread interact1 = new Thread(event1);
		
		interact.start();
		
		
	}

	
	
	
}
