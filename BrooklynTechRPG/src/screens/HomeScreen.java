package screens;

import java.awt.event.KeyListener;
import java.util.List;

import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class HomeScreen extends FullFunctionScreen implements Runnable, KeyListener {
	
	private Graphic homebg;

	public HomeScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		homebg = new Graphic(0,0,"resources/home.png");
		homebg.setX((getWidth()-homebg.getWidth())/2);
		viewObjects.add(homebg);
	}

}
