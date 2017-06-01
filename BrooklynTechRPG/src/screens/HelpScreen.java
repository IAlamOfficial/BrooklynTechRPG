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
	private TextArea description1;
	private TextArea description2;
	private TextArea description3;
	
	public HelpScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		bitTech = new Graphic(0,0,"resources/BitTech.jpg");
		bitTech.setX((getWidth()-bitTech.getWidth())/2);
		viewObjects.add(bitTech);
		
		rectangleBlur = new Graphic(0,200,"resources/RectangleBlur.png");
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
		
		
		
		menuScreen = new CustomButton(100, 100, 200, 100, "Return", new Action() {
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
		
		
		description1 = new TextArea(125, 205, 750, 60, "In this RPG, there are many items and stats that will help progress you through the game.  Stats can raise or fall and items can be bought or used.");
		description1.setBorderThickness(3);
		description1.showBorder(true);
		try {
			File fontFile = new File("resources/MyGirlIsRetroDEMO.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(20f);
		//	StyledComponent.setBaseFont(baseFont);//Changes font everywhere
			description1.setFont(baseFont);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		viewObjects.add(description1);
		
		
		description2 = new TextArea(125, 265, 750, 140, "Items are used to raise your stats but can cost money: \n"
				+ "Homework Assignments :  Knowledge\nAlarm Clock :  Time\nStudy Guides :  Knowledge\nCoffee :  Time, Energy\nEnergy Drink :  Strength, Energy");
		description2.setBorderThickness(3);
		description2.showBorder(true);
		try {
			File fontFile = new File("resources/MyGirlIsRetroDEMO.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(15f);
		//	StyledComponent.setBaseFont(baseFont);//Changes font everywhere
			description2.setFont(baseFont);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		viewObjects.add(description2);
		
		description3 = new TextArea(125, 405, 750, 335, "Stats are what affect your interaction with others and are gained or lost doing different things:\n"
				+ "Knowledge :  Points needed to graduate\n"
				+ "     Gained by :  Homework, Extracurriculars                                                 Lost by :  Cutting class\n"
				+ "Money :  Used to purchase items\n"
				+ "     Gained by :  Daily Allowance, Defeating Bullies                              Lost by :  Homework Answers, Food, Test Answers\n"
				+ "Reputation :  Your standing with the faculty of the school\n"
				+ "     Gained by :  Going to class, Completing homework             Lost by :  Fighting Bullies\n"
				+ "Energy :  Used to complete any tasks\n"
				+ "     Gained by :  Sleeping, Eating, Completing homework         Lost by :  Attacking bullies\n"
				+ "Strength :  Used to take on bullies\n"
				+ "     Gained by :  Playing Sports                                                        Lost by :  Fighting Bullies\n"
				+ "Social :  Affects prices of favors and how you’re seen by others\n"
				+ "     Gained by :  Fighting bullies                                                      Lost by :  Inactive socially(media)\n"
				+ "Time :  Used to limit the actions of the player but also required for the player to do tasks\n"
				+ "     Gained by :  Coffee, Alarm clock                                         Lost by :  Doing Homework, Going to class, Completing tests");
		description3.setBorderThickness(3);
		description3.showBorder(true);
		try {
			File fontFile = new File("resources/MyGirlIsRetroDEMO.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(15f);
		//	StyledComponent.setBaseFont(baseFont);//Changes font everywhere
			description3.setFont(baseFont);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		viewObjects.add(description3);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}