package screens;

import java.awt.Event;
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
import npc.Ball;
import npc.Bully;
import npc.Merchant;
import npc.NPC;
import npc.NPCController;
import npc.NPCEvent; 

public class HallwayScreen extends FullFunctionScreen implements Runnable, KeyListener {
	
	private Graphic hallwaybg;
	
	
	private CustomButton hwMenuScreenButton;//goes back to main menu
	private CustomButton hwClassRoomButton;//goes to classroom
	private CustomButton hwInventoryButton;//goes to inventory
	private CustomButton hwHomeButton;//goes to player's home
	public static TextArea textBox;

	private int numberOfEntriesHallway;
	public String text;
	private NPCEvent e;
	
	private Bully bully;
	private CustomButton bullyButton;
	
	private Merchant merchant;
	private CustomButton merchantButton;
	
	private Ball ball;
	private CustomButton ballButton;
	
	private CustomButton bullyActionButton;
	
	public HallwayScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
	
	
	
	public void performInitialTasks() {
		// TODO Auto-generated method stub
		if(numberOfEntriesHallway == 0){
			numberOfEntriesHallway++;
		}else{
			textBox.setText("Click on people to interact with them.");
		}
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		text = "Welcome to Brooklyn Tech, this is where you will be spending the next 4 years of your life, learning many new things and making new friends.";

		hallwaybg = new Graphic(0,0,"resources/hallwayimproved.png");
		hallwaybg.setX((getWidth()-hallwaybg.getWidth())/2);
		
		hwMenuScreenButton = new CustomButton(250, 60, 100, 30, "Menu", new Action() {
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
				TechGame.trpg.setScreen(TechGame.classroomScreen);
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
		
		hwInventoryButton = new CustomButton(485, 60, 115, 30, "Inventory", new Action() {
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
			hwInventoryButton.setFont(baseFont);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		textBox = new TextArea(250, 100, 500, 125, text);
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
		
		hwHomeButton = new CustomButton(610, 60, 100, 30, "Home", new Action() {
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
			hwHomeButton.setFont(baseFont);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		bullyActionButton = new CustomButton(600, 200, 150, 30, "Act", new Action() {
			@Override
			public void act() {
				if(e.getNPC() instanceof Bully){
					if(TechGame.player.getEnergy() > 20){
						TechGame.player.setEnergy(-20);
						Bully b = (Bully) e.getNPC();
						boolean result = b.fight(TechGame.player.getStrength());
						e.beatBully(result);
					}else{
						e.couldNotFight();
					}
				}
			}
		}); 
		try {
			File fontFile = new File("resources/MyGirlIsRetroDEMO.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(20f);
			//	StyledComponent.setBaseFont(baseFont);//Changes font everywhere
			bullyActionButton.setFont(baseFont);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bully = new Bully("Bully",100,125,"resources/bully.png",10);
		bullyButton = new CustomButton(100, 125, 40, 40, "", new Action() {
			@Override
			public void act() {
				e = new NPCEvent(TechGame.player,bully);
				NPCController npcCon = new NPCController(getWidth(), getHeight(),e, TechGame.player);
				viewObjects.add(npcCon);
				Thread interact = new Thread(e);
				interact.start();
				viewObjects.add(bullyActionButton);
				
			}
		}); 
				try {
			File fontFile = new File("resources/MyGirlIsRetroDEMO.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(20f);
		//	StyledComponent.setBaseFont(baseFont);//Changes font everywhere
			bullyButton.setFont(baseFont);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		merchant = new Merchant("Merchant",870,125,"resources/merchant.png");
		merchantButton = new CustomButton(870, 125, 40, 40, "", new Action() {
			@Override
			public void act() {
				e = new NPCEvent(TechGame.player,merchant);
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
			merchantButton.setFont(baseFont);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		ball = new Ball("Ball",300,550,"resources/ball.png");
		ballButton = new CustomButton(295, 545, 30, 30, "", new Action() {
			@Override
			public void act() {
				e = new NPCEvent(TechGame.player,ball);
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
			ballButton.setFont(baseFont);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		viewObjects.add(hallwaybg);
		viewObjects.add(hwMenuScreenButton);
		viewObjects.add(hwClassRoomButton);
		viewObjects.add(hwInventoryButton);
		viewObjects.add(hwHomeButton);
		
		viewObjects.add(bullyButton);
		viewObjects.add(bully);
		viewObjects.add(merchantButton);
		viewObjects.add(merchant);
		viewObjects.add(ballButton);
		viewObjects.add(ball);
		
		viewObjects.add(textBox);
		
	
	}
	
}

