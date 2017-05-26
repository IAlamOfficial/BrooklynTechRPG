/**
 * 
 */
package TechRPG;

import guiTeacher.GUIApplication;
import player.Player;
import screens.HelpScreen;
import screens.InventoryScreen;
import screens.MenuScreen;

/**
 * @author Ryan Situ
 *
 */
public class TechGame extends GUIApplication {
	
	public static TechGame trpg;
	public static MenuScreen menuScreen;
	public static HelpScreen helpScreen;
	public static InventoryScreen invScreen;
	public static Player player;

	/**
	 * @param width
	 * @param height
	 */
	public TechGame(int width, int height) {
		super(width, height);
		setVisible(true);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see guiTeacher.GUIApplication#initScreen()
	 */
	@Override
	public void initScreen() {
		menuScreen = new MenuScreen(getWidth(),getHeight());
		setScreen(menuScreen);
		
		invScreen = new InventoryScreen(getWidth(),getHeight());
		//setScreen(invScreen);
		
		helpScreen = new HelpScreen(getWidth(),getHeight());
		//setScreen(helpScreen);
		
	}
 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		trpg = new TechGame(1000,760);
		Thread game = new Thread(trpg);
		game.start();
	}

	public static Player getPlayer() {
		return player;
	}

	public static void setPlayer(Player player) {
		TechGame.player = player;
	}

}
