/**
 * 
 */
package TechRPG;

import guiTeacher.GUIApplication;
import player.Player;
import screens.InventoryScreen;
import screens.MenuScreen;

/**
 * @author Ryan Situ
 *
 */
public class TechGame extends GUIApplication {
	
	private static InventoryScreen invScreen;
	private static MenuScreen menuScreen;
	private static Player player;

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
		invScreen = new InventoryScreen(getWidth(),getHeight());
		//setScreen(invScreen);
		menuScreen = new MenuScreen(getWidth(),getHeight());
		setScreen(menuScreen);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TechGame trpg = new TechGame(800,500);
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
