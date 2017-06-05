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
	private int currentScreen = -1;
	private int numberOfEntries = 0;
	private TextArea intro;
	private CustomButton menuScreen;
	
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
		hallwaybg = new Graphic(0,0,"resources/hallwayimproved.png");
		hallwaybg.setX((getWidth()-hallwaybg.getWidth())/2);
		viewObjects.add(hallwaybg);
		
		intro = new TextArea(250, 100, 500, 100, "Welcome to Brooklyn Tech, this is where you will be spending the next 4 years of your life, learning many new things and making new friends.");
		//intro.setBorderThickness(3);
		intro.showBorder(false);
		try {
			File fontFile = new File("resources/MyGirlIsRetroDEMO.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(15f);
		//	StyledComponent.setBaseFont(baseFont);//Changes font everywhere
			intro.setFont(baseFont);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(numberOfEntries == 0){
			viewObjects.add(intro);
			numberOfEntries++;
		}
		
		classroombg = new Graphic(0,0,"resources/classroom.png");
		classroombg.setX((getWidth()-classroombg.getWidth())/2);
		viewObjects.add(classroombg);
		
		
		menuScreen = new CustomButton(250, 60, 100, 30, "Return", new Action() {
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
			menuScreen.setFont(baseFont);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		viewObjects.add(menuScreen);
	}

}
