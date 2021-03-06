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
import npc.Computer;
import npc.Faculty;
import npc.Food;
import npc.HomeworkTable;
import npc.NPCController;
import npc.NPCEvent;

public class HomeScreen extends FullFunctionScreen implements Runnable, KeyListener {
	
	private Graphic homebg;
	private CustomButton hsMenuScreenButton;//goes back to main menu
	private CustomButton hsClassRoomButton;//goes to classroom
	private CustomButton hsInventoryButton;//goes to inventory
	private CustomButton hsHallwayButton;//goes to player's home
	
	
	//private Bed bed;
	private CustomButton bedButton;
	
	private Food dinnerTable;
	private CustomButton dinnerTableButton;
	
	private Computer computer;
	private CustomButton computerButton;
	
	private HomeworkTable homeworkTable;
	private CustomButton homeworkTableButton;
	
	private NPCEvent e;
	
	
	
	
	public static TextArea textBox;
	public String text;
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
			textBox.setText("Click on people to interact with them. Click on the dinner table to get food or click the bed to sleep which adds another day");
		}
	}
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		text = "Welcome to your home, this is where you will be eating and sleeping. Click on the dinner table to get food or click the bed to sleep which adds another day.";
		homebg = new Graphic(0,0,"resources/home.png");
		homebg.setX((getWidth()-homebg.getWidth())/2);
		viewObjects.add(homebg);
		
		hsMenuScreenButton = new CustomButton(470, 605, 100, 30, "Menu", new Action() {
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
		
		hsClassRoomButton = new CustomButton(575, 605, 115, 30, "Classroom", new Action() {
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
		
		hsInventoryButton = new CustomButton(695, 605, 115, 30, "Inventory", new Action() {
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
		
		textBox = new TextArea(480, 645, 450, 65, text);
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
		
		hsHallwayButton = new CustomButton(815, 605, 100, 30, "Hallway", new Action() {
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

		bedButton = new CustomButton(50, 240, 53, 75, "Bed", new Action() {
			@Override
			public void act() {
				
			}
		}); 
				try {
			File fontFile = new File("resources/MyGirlIsRetroDEMO.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(20f);
		//	StyledComponent.setBaseFont(baseFont);//Changes font everywhere
			bedButton.setFont(baseFont);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
				
		dinnerTable = new Food("Food",600,200,"resources/ball.png");				
		dinnerTableButton = new CustomButton(600, 200, 200, 80, "Dinner Table", new Action() {
			@Override
			public void act() {
				e = new NPCEvent(TechGame.player,dinnerTable);
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
			dinnerTableButton.setFont(baseFont);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
				
				
		computer = new Computer("Teacher",200,100,"resources/ball.png");
		computerButton = new CustomButton(200, 90, 50, 70, "Computer", new Action() {
			@Override
			public void act() {
				e = new NPCEvent(TechGame.player,computer);
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
			computerButton.setFont(baseFont);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
				
		homeworkTable = new HomeworkTable("Food",100,100,"resources/ball.png");				
		homeworkTableButton = new CustomButton(100, 100, 100, 60, "Homework Table", new Action() {
			@Override
			public void act() {
				e = new NPCEvent(TechGame.player,homeworkTable);
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
			homeworkTableButton.setFont(baseFont);
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
		
		//viewObjects.add(bed);
		viewObjects.add(bedButton);
		
		viewObjects.add(dinnerTable);
		viewObjects.add(dinnerTableButton);
		
		viewObjects.add(computer);
		viewObjects.add(computerButton);
		
		viewObjects.add(homeworkTable);
		viewObjects.add(homeworkTableButton);
		
		viewObjects.add(textBox);
	}

}
