package npc;

import TechRPG.TechGame;
import guiTeacher.GUIApplication;
import player.Player;
import screens.InventoryScreen;
import screens.MenuScreen;

public class DemoForNPC extends GUIApplication {

	public DemoForNPC(int width, int height) {
		super(width, height);
		setVisible(true);
	}
	public static DemoForNPC trpg;
	public static NPCTestScreen menuScreen;
	public static Player player;

	
	@Override
	public void initScreen() {
		player = new Player();
		menuScreen = new NPCTestScreen(getWidth(),getHeight());
		setScreen(menuScreen);
		

		
	}
 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		trpg = new DemoForNPC(1000,760);
		Thread game = new Thread(trpg);
		game.start();
	}

}
