package screens;

import java.util.List;

import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import items.SampleItem;

public class InventoryScreen extends FullFunctionScreen {

	public InventoryScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		SampleItem test = new SampleItem(20,20,200,75);
		viewObjects.add(test);
		

	}

}
