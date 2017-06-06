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

public class HallwayScreen extends FullFunctionScreen implements Runnable, KeyListener {
	
	private Graphic hallwaybg;//screen 0
	private Graphic classroombg;//screen 1
	private int currentScreen;
	private int numberOfEntries;
	private TextArea textBox;
	private CustomButton hwMenuScreenButton;
	private CustomButton hwClassRoomButton;
	private CustomButton crMenuScreenButton;
	private CustomButton crHallwayButton;
	private String text;
			
	
	public HallwayScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		currentScreen = -1;
		if(numberOfEntries == 0){
			currentScreen = 0;
			text = "Welcome to Brooklyn Tech, this is where you will be spending the next 4 years of your life, learning many new things and making new friends.";
			numberOfEntries++;
		}else{
			text = "";
		}
		hallwaybg = new Graphic(0,0,"resources/hallwayimproved.png");
		hallwaybg.setX((getWidth()-hallwaybg.getWidth())/2);
		
		hwMenuScreenButton = new CustomButton(250, 60, 100, 30, "Return", new Action() {
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
			hwMenuScreenButton.setFont(baseFont);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		hwClassRoomButton = new CustomButton(360, 60, 115, 30, "Classroom", new Action() {
			@Override
			public void act() {
				currentScreen = 1;
				goToClassroom();
			}
		}); 
				try {
			File fontFile = new File("resources/MyGirlIsRetroDEMO.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(20f);
		//	StyledComponent.setBaseFont(baseFont);//Changes font everywhere
			hwClassRoomButton.setFont(baseFont);
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
		
		
		
		
		classroombg = new Graphic(0,0,"resources/classroom.png");
		classroombg.setX((getWidth()-classroombg.getWidth())/2);
		crMenuScreenButton = new CustomButton(450, 80, 100, 30, "Return", new Action() {
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
			crMenuScreenButton.setFont(baseFont);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		crHallwayButton = new CustomButton(825, 655, 115, 30, "Hallway", new Action() {
			@Override
			public void act() {
				currentScreen = 0;
				goToHallway(viewObjects);
			}
		}); 
				try {
			File fontFile = new File("resources/MyGirlIsRetroDEMO.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(20f);
		//	StyledComponent.setBaseFont(baseFont);//Changes font everywhere
			crHallwayButton.setFont(baseFont);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(currentScreen == 0){
			viewObjects.add(hallwaybg);
			viewObjects.add(hwMenuScreenButton);
			viewObjects.add(hwClassRoomButton);
			viewObjects.add(textBox);
		}
		if(currentScreen == 1){
			viewObjects.add(classroombg);
			viewObjects.add(crMenuScreenButton);
			viewObjects.add(crHallwayButton);
		}
		
	
	}
	public void goToHallway(List<Visible> viewObjects) {
		addObject(hallwaybg);
		addObject(hwMenuScreenButton);
		addObject(textBox);
		addObject(hwClassRoomButton);
		
		remove(classroombg);
		remove(crMenuScreenButton);
		remove(crHallwayButton);
	}
	public void goToClassroom() {
		addObject(classroombg);
		addObject(crMenuScreenButton);
		addObject(crHallwayButton);
		
		remove(hallwaybg);
		remove(hwMenuScreenButton);
		remove(textBox);
		remove(hwClassRoomButton);
	}

}

