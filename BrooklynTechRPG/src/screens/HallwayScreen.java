package screens;

import java.awt.event.KeyListener;
import java.util.List;

import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class HallwayScreen extends FullFunctionScreen implements Runnable, KeyListener {
	
	private Graphic hallwaybg;

	public HallwayScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		hallwaybg = new Graphic(0,0,"resources/hallwayimproved.png");
		hallwaybg.setX((getWidth()-hallwaybg.getWidth())/2);
		viewObjects.add(hallwaybg);
	}

}
