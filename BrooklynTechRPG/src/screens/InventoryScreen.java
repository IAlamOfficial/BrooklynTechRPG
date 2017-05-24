package screens;

import java.util.List;

import guiTeacher.components.TextArea;
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

	public InventoryScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		descriptionDisplay = new InfoBox(250, 50, 300, 300, "");
		viewObjects.add(descriptionDisplay);
		
		SampleItem test = new SampleItem(20,20+(yPos*80),200,75);
		test.setInfoBox(descriptionDisplay);
		viewObjects.add(test);
		yPos++;
		
		Coffee coffee = new Coffee(20,20+(yPos*80),200,75);
		coffee.setInfoBox(descriptionDisplay);
		viewObjects.add(coffee);
		yPos++;
		
		EnergyDrink drink = new EnergyDrink(20,20+(yPos*80),200,75);
		drink.setInfoBox(descriptionDisplay);
		viewObjects.add(drink);
		yPos++;
		
		Homework homework = new Homework(20,20+(yPos*80),200,75);
		homework.setInfoBox(descriptionDisplay);
		viewObjects.add(homework);
		yPos++;
		
		StudyGuide study = new StudyGuide(20,20+(yPos*80),200,75);
		study.setInfoBox(descriptionDisplay);
		viewObjects.add(study);
		yPos++;
		
		Test exam = new Test(20,20+(yPos*80),200,75);
		exam.setInfoBox(descriptionDisplay);
		viewObjects.add(exam);
		yPos++;
	}
	
	protected void defaultWhenNothingHovered() {
		descriptionDisplay.setText("");
	}

}
