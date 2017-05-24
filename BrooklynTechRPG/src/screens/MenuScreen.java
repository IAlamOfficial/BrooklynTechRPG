package screens;

import java.awt.event.KeyListener;
import java.util.List;

import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class MenuScreen extends FullFunctionScreen implements Runnable, KeyListener{

	private TextLabel title;
	
	public MenuScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		title = new TextLabel(60, 160, 200, 50, "Brooklyn Tech RPG");
		viewObjects.add(title);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
