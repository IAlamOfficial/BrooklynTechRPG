package screens;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.util.List;

import TechRPG.TechGame;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import items.Coffee;
import items.EnergyDrink;
import items.Homework;
import items.InfoBox;
import items.SampleItem;
import items.StudyGuide;
import items.Test;

public class InventoryScreen extends FullFunctionScreen {

	private int yPos = 0;
	private InfoBox descriptionDisplay;
	private Button exitInv;
	private CustomButton menuScreenButton;
	private CustomButton hallwayScreenButton;
	private CustomButton classRoomScreenButton;
	private CustomButton homeScreenButton;
	private Graphic invbg;
	private TextLabel title;
	public static SampleItem test;
	public static Coffee coffee;
	public static EnergyDrink drink;
	public static Homework homework;
	public static StudyGuide study;
	public static Test exam;
	private int numberOfEntriesInventory;
	
	private TextArea textBox;
	private String text;
	public void performInitialTasks() {
		// TODO Auto-generated method stub
		if(numberOfEntriesInventory == 0){
			numberOfEntriesInventory++;
		}else{
			textBox.setText("Knowledge: "+TechGame.player.getKnowledgePoints()+"\n"+
					"Money: $"+TechGame.player.getMoney()+"\n"+
					"Reputation: "+TechGame.player.getRep()+"\n"+
					"Energy: "+TechGame.player.getEnergy()+"\n"+
					"Strength: "+TechGame.player.getStrength()+"\n"+
					"Social: "+TechGame.player.getSocial()+"\n"+
					"Time: "+TechGame.player.getTime()+"\n"+
					"Day: "+TechGame.player.getDay()+"\n"+
					"Level: "+TechGame.player.getLevel()+"\n");
		}
	}
	public InventoryScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		text = "This is where your stats will be displayed.";
		invbg = new Graphic(0,0,"resources/inventorybackground.png");
		invbg.setX((getWidth()-invbg.getWidth())/2);
		viewObjects.add(invbg);

		title = new CenterTextLabel(0, 25, getWidth(), 50, "Inventory");
		try {
			File fontFile = new File("resources/MyGirlIsRetroDEMO.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(48f);
			//	StyledComponent.setBaseFont(baseFont);//Changes font everywhere
			title.setFont(baseFont);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		viewObjects.add(title);
		
		descriptionDisplay = new InfoBox(400, 250, 300, 300, "");
		viewObjects.add(descriptionDisplay);
		
		test = new SampleItem(120,95+(yPos*85),200,75, 0);
		test.setInfoBox(descriptionDisplay);
		//viewObjects.add(test);
		yPos++;
		
		coffee = new Coffee(120,30+(yPos*85),200,75, 0);
		coffee.setInfoBox(descriptionDisplay);
		viewObjects.add(coffee);
		yPos++;
		
		drink = new EnergyDrink(120,30+(yPos*85),200,75, 0);
		drink.setInfoBox(descriptionDisplay);
		viewObjects.add(drink);
		yPos++;
		
		homework = new Homework(120,30+(yPos*85),200,75, 0);
		homework.setInfoBox(descriptionDisplay);
		viewObjects.add(homework);
		yPos++;
		
		study = new StudyGuide(120,30+(yPos*85),200,75, 0);
		study.setInfoBox(descriptionDisplay);
		viewObjects.add(study);
		yPos++;
		
		exam = new Test(120,30+(yPos*85),200,75, 0);
		exam.setInfoBox(descriptionDisplay);
		viewObjects.add(exam);
		yPos++;
		
		menuScreenButton = new CustomButton(700, 100, 200, 100, "Menu", new Action() {
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
			menuScreenButton.setFont(baseFont);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		hallwayScreenButton = new CustomButton(700, 250, 200, 100, "Hallway", new Action() {
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
			hallwayScreenButton.setFont(baseFont);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		classRoomScreenButton = new CustomButton(700, 400, 200, 100, "Classroom", new Action() {
			@Override
			public void act() {
				TechGame.trpg.setScreen(TechGame.classroomScreen);
			}
		}); 
				try {
			File fontFile = new File("resources/MyGirlIsRetroDEMO.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(30f);
		//	StyledComponent.setBaseFont(baseFont);//Changes font everywhere
			classRoomScreenButton.setFont(baseFont);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		homeScreenButton = new CustomButton(700, 550, 200, 100, "Home", new Action() {
			@Override
			public void act() {
				TechGame.trpg.setScreen(TechGame.homeScreen);
			}
		}); 
				try {
			File fontFile = new File("resources/MyGirlIsRetroDEMO.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(30f);
		//	StyledComponent.setBaseFont(baseFont);//Changes font everywhere
			homeScreenButton.setFont(baseFont);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		textBox = new TextArea(120, 540, 500, 197, text);
		//intro.setBorderThickness(3);
		textBox.showBorder(true);
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
		
		viewObjects.add(menuScreenButton);
		viewObjects.add(hallwayScreenButton);
		viewObjects.add(classRoomScreenButton);
		viewObjects.add(homeScreenButton);
		viewObjects.add(textBox);
	}
	
	protected void defaultWhenNothingHovered() {
		descriptionDisplay.setText("");
	}

}
