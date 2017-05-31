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
import guiTeacher.components.TextArea;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import screens.CustomButton;
/**
 * @author Matthew Nguyen
 *
 */
public class HelpScreen extends FullFunctionScreen implements Runnable, KeyListener{

	private Graphic bitTech;
	private Graphic rectangleBlur;
	private TextLabel title;
	private CustomButton menuScreen;
	private TextArea description;
	
	public HelpScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		bitTech = new Graphic(0,0,"resources/BitTech.jpg");
		bitTech.setX((getWidth()-bitTech.getWidth())/2);
		viewObjects.add(bitTech);
		
		rectangleBlur = new Graphic(0,300,"resources/RectangleBlur.png");
		rectangleBlur.setX((getWidth()-rectangleBlur.getWidth())/2);
		viewObjects.add(rectangleBlur);
		
		title = new CenterTextLabel(0, 25, getWidth(), 50, "RPG   Help");
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
		
		
		
		menuScreen = new CustomButton(100, 150, 200, 100, "Return", new Action() {
			@Override
			public void act() {
				TechGame.trpg.setScreen(TechGame.menuScreen);
			}
		}); 
				try {
			File fontFile = new File("resources/MyGirlIsRetroDEMO.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(30f);
		//	StyledComponent.setBaseFont(baseFont);//Changes font everywhere
			menuScreen.setFont(baseFont);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		viewObjects.add(menuScreen);
		
		
		description = new TextArea(125, 320, 750, 400, "In this RPG, there are many items and stats that will help progress you through the game.  Stats can raise or fall and items can be bought or used.");
		description.setBorderThickness(3);
		description.showBorder(true);
		try {
			File fontFile = new File("resources/MyGirlIsRetroDEMO.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(20f);
		//	StyledComponent.setBaseFont(baseFont);//Changes font everywhere
			description.setFont(baseFont);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		viewObjects.add(description);
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}