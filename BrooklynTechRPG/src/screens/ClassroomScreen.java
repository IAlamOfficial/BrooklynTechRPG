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
import npc.Bully;
import npc.ClassTable;
import npc.Faculty;
import npc.NPCController;
import npc.NPCEvent;

public class ClassroomScreen extends FullFunctionScreen implements Runnable, KeyListener {
	
	private Graphic classroombg;
	private CustomButton crMenuScreenButton;
	private CustomButton crHallwayButton;
	private CustomButton inventoryScreenButton;
	private CustomButton crHomeButton;
	public static TextArea textBox;
	public String text;
	private int numberOfEntriesClassroom;
	
	private NPCEvent e;
	
	private Faculty teacher;
	private CustomButton teacherButton;
	
	private ClassTable classTable;
	private CustomButton classTableButton;
	
	public ClassroomScreen(int width, int height) {
		super(width,height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	public void performInitialTasks() {
		// TODO Auto-generated method stub
		if(numberOfEntriesClassroom == 0){
			numberOfEntriesClassroom++;
		}else{
			textBox.setText("Click on people to interact with them.");
		}
	}
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		text = "Welcome to your classroom, this is where you will be learning your subjects.";
		classroombg = new Graphic(0,0,"resources/classroom.png");
		classroombg.setX((getWidth()-classroombg.getWidth())/2);
		crMenuScreenButton = new CustomButton(500, 205, 100, 30, "Menu", new Action() {
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
		
		crHallwayButton = new CustomButton(605, 205, 115, 30, "Hallway", new Action() {
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
			crHallwayButton.setFont(baseFont);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		inventoryScreenButton = new CustomButton(725, 205, 115, 30, "Inventory", new Action() {
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
			inventoryScreenButton.setFont(baseFont);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		textBox = new TextArea(500, 235, 420, 80, text);
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
		
		crHomeButton = new CustomButton(845, 205, 80, 30, "Home", new Action() {
			@Override
			public void act() {
				TechGame.trpg.setScreen(TechGame.homeScreen);
			}
		}); 
				try {
			File fontFile = new File("resources/MyGirlIsRetroDEMO.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(20f);
		//	StyledComponent.setBaseFont(baseFont);//Changes font everywhere
			crHomeButton.setFont(baseFont);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
				
		teacher = new Faculty("Teacher",300,140,"resources/teacher.png",true);
		teacherButton = new CustomButton(300, 140, 40, 50, "", new Action() {
			@Override
			public void act() {
				e = new NPCEvent(TechGame.player,teacher);
				NPCController npcCon = new NPCController(getWidth(), getHeight(),e, TechGame.player,InventoryScreen.homework);
				viewObjects.add(npcCon);
				Thread interact = new Thread(e);
				interact.start();
				
			} 
		}); 
				try {
			File fontFile = new File("resources/MyGirlIsRetroDEMO.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(20f);
		//	StyledComponent.setBaseFont(baseFont);//Changes font everywhere
			teacherButton.setFont(baseFont);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		classTable = new ClassTable("Class Table",245,215,"resources/ball.png");
		classTableButton = new CustomButton(210, 190, 160, 100, "", new Action() {
			@Override
			public void act() {
				e = new NPCEvent(TechGame.player,classTable);
				NPCController npcCon = new NPCController(getWidth(), getHeight(),e, TechGame.player);
				viewObjects.add(npcCon);
				Thread interact = new Thread(e);
				interact.start();
				
			} 
		}); 
				try {
			File fontFile = new File("resources/MyGirlIsRetroDEMO.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(20f);
		//	StyledComponent.setBaseFont(baseFont);//Changes font everywhere
			classTableButton.setFont(baseFont);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
				
		viewObjects.add(classroombg);
		viewObjects.add(crMenuScreenButton);
		viewObjects.add(crHallwayButton);
		viewObjects.add(inventoryScreenButton);
		viewObjects.add(crHomeButton);
		
		viewObjects.add(teacherButton);
		viewObjects.add(teacher);
		viewObjects.add(classTableButton);
		viewObjects.add(classTable);
		viewObjects.add(textBox);
	}

}
