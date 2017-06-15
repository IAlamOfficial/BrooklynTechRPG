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
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class HomeScreen extends FullFunctionScreen implements Runnable, KeyListener {
	
	private Graphic homebg;
	private CustomButton hsMenuScreenButton;//goes back to main menu
	private CustomButton hsClassRoomButton;//goes to classroom
	private CustomButton hsInventoryButton;//goes to inventory
	private CustomButton hsHallwayButton;//goes to player's home
	private TextArea textBox;
	private String text;
	private int numberOfEntriesHome;
	public HomeScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
	public void performInitialTasks() {
		// TODO Auto-generated method stub
		if(numberOfEntriesHome == 0){
			numberOfEntriesHome++;
		}else{
			textBox.setText("Money: $"+TechGame.player.getMoney());
		}
	}
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		text = "Welcome to your home, this is where you will be eating and sleeping.";
		homebg = new Graphic(0,0,"resources/home.png");
		homebg.setX((getWidth()-homebg.getWidth())/2);
		viewObjects.add(homebg);
		
		hsMenuScreenButton = new CustomButton(250, 60, 100, 30, "Menu", new Action() {
			@Override
			public void act() {
				TechGame.trpg.setScreen(TechGame.menuScreen);
			}
		}); 
				try {
			File fontFile = new File("resources/MyGirlIsRetroDEMO.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(20f);
		//	StyledComponent.setBaseFont(baseFont);//Changes font everywhere
			hsMenuScreenButton.setFont(baseFont);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		hsClassRoomButton = new CustomButton(360, 60, 115, 30, "Classroom", new Action() {
			@Override
			public void act() {
				TechGame.trpg.setScreen(TechGame.classroomScreen);
			}
		}); 
				try {
			File fontFile = new File("resources/MyGirlIsRetroDEMO.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(20f);
		//	StyledComponent.setBaseFont(baseFont);//Changes font everywhere
			hsClassRoomButton.setFont(baseFont);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		hsInventoryButton = new CustomButton(485, 60, 115, 30, "Inventory", new Action() {
			@Override
			public void act() {
				TechGame.trpg.setScreen(TechGame.invScreen);
			}
		}); 
				try {
			File fontFile = new File("resources/MyGirlIsRetroDEMO.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(20f);
		//	StyledComponent.setBaseFont(baseFont);//Changes font everywhere
			hsInventoryButton.setFont(baseFont);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		textBox = new TextArea(250, 100, 500, 100, text);
		//intro.setBorderThickness(3);
		textBox.showBorder(false);
		try {
			File fontFile = new File("resources/MyGirlIsRetroDEMO.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(15f);
		//	StyledComponent.setBaseFont(baseFont);//Changes font everywhere
			textBox.setFont(baseFont);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		hsHallwayButton = new CustomButton(610, 60, 100, 30, "Home", new Action() {
			@Override
			public void act() {
				TechGame.trpg.setScreen(TechGame.hallwayScreen);
			}
		}); 
				try {
			File fontFile = new File("resources/MyGirlIsRetroDEMO.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(20f);
		//	StyledComponent.setBaseFont(baseFont);//Changes font everywhere
			hsHallwayButton.setFont(baseFont);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
				
		
		viewObjects.add(hsMenuScreenButton);
		viewObjects.add(hsClassRoomButton);
		viewObjects.add(hsInventoryButton);
		viewObjects.add(hsHallwayButton);
		viewObjects.add(textBox);
	}

}
