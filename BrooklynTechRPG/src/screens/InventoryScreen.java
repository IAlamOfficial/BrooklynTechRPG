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
	private CustomButton menuScreen;
	private Graphic invbg;
	private TextLabel title;

	public InventoryScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
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
		
		SampleItem test = new SampleItem(120,90+(yPos*80),200,75);
		test.setInfoBox(descriptionDisplay);
		viewObjects.add(test);
		yPos++;
		
		Coffee coffee = new Coffee(120,90+(yPos*80),200,75);
		coffee.setInfoBox(descriptionDisplay);
		viewObjects.add(coffee);
		yPos++;
		
		EnergyDrink drink = new EnergyDrink(120,90+(yPos*80),200,75);
		drink.setInfoBox(descriptionDisplay);
		viewObjects.add(drink);
		yPos++;
		
		Homework homework = new Homework(120,90+(yPos*80),200,75);
		homework.setInfoBox(descriptionDisplay);
		viewObjects.add(homework);
		yPos++;
		
		StudyGuide study = new StudyGuide(120,90+(yPos*80),200,75);
		study.setInfoBox(descriptionDisplay);
		viewObjects.add(study);
		yPos++;
		
		Test exam = new Test(120,90+(yPos*80),200,75);
		exam.setInfoBox(descriptionDisplay);
		viewObjects.add(exam);
		yPos++;
		
		menuScreen = new CustomButton(700, 250, 200, 100, "Return", new Action() {
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
	}
	
	protected void defaultWhenNothingHovered() {
		descriptionDisplay.setText("");
	}

}
