package screens;

import java.util.List;

import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import items.Coffee;
import items.EnergyDrink;
import items.InfoBox;
import items.SampleItem;

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
		SampleItem test = new SampleItem(20,20+(yPos*65),200,75);
		viewObjects.add(test);
		yPos++;
		EnergyDrink drink = new EnergyDrink(20,20+(yPos*65),200,75);
		drink.setInfoBox(descriptionDisplay);
		viewObjects.add(drink);
		yPos++;
		Coffee coffee = new Coffee(20,20+(yPos*65),200,75);
		coffee.setInfoBox(descriptionDisplay);
		viewObjects.add(coffee);

	}
	
	protected void defaultWhenNothingHovered() {
		descriptionDisplay.setText("");
	}

}
