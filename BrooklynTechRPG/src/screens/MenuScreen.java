package screens;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

import TechRPG.TechGame;
import guiTeacher.components.Action;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import screens.CustomButton;
/**
 * @author Matthew Nguyen
 *
 */
public class MenuScreen extends FullFunctionScreen implements Runnable, KeyListener{

	private Graphic bitTech;
	private TextLabel title;
	private CustomButton gameScreen;
	private CustomButton helpScreen;
	private CustomButton testScreen;
	
	public MenuScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		bitTech = new Graphic(0,0,"resources/BitTech.jpg");
		bitTech.setX((getWidth()-bitTech.getWidth())/2);
		viewObjects.add(bitTech);
		
		
		
		title = new CenterTextLabel(0, 25, getWidth(), 50, "Brooklyn   Tech   The   RPG");
				try {
			File fontFile = new File("resources/MyGirlIsRetroDEMO.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(48f);
//			StyledComponent.setBaseFont(baseFont);//Changes font everywhere
			title.setFont(baseFont);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		viewObjects.add(title);
		
		
		
		gameScreen = new CustomButton(100, 150, 200, 100, "Start Game", new Action() {
			@Override
			public void act() {
				TechGame.trpg.setScreen(TechGame.hallwayScreen);
			}
		}); 
				try {
			File fontFile = new File("resources/MyGirlIsRetroDEMO.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(30f);
		//	StyledComponent.setBaseFont(baseFont);//Changes font everywhere
			gameScreen.setFont(baseFont);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		viewObjects.add(gameScreen);
		
		
		helpScreen = new CustomButton(800, 150, 150, 100, "Help", new Action() {
			@Override
			public void act() {
				TechGame.trpg.setScreen(TechGame.helpScreen);
			}
		});
		try {
			File fontFile = new File("resources/MyGirlIsRetroDEMO.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(30f);
			//	StyledComponent.setBaseFont(baseFont);//Changes font everywhere
			helpScreen.setFont(baseFont);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		viewObjects.add(helpScreen);
		
		
		
		testScreen = new CustomButton(500, 150, WIDTH, HEIGHT, "test", new Action() {
			@Override
			public void act() {
				TechGame.trpg.setScreen(TechGame.invScreen);
			}
		});
		viewObjects.add(testScreen);
		
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
