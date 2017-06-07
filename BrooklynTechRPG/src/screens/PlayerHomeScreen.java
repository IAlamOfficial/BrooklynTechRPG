package screens;

import java.awt.event.KeyListener;
import java.util.List;

import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class PlayerHomeScreen extends FullFunctionScreen implements Runnable, KeyListener{
	
	private Graphic playerhomebg;

	public PlayerHomeScreen(int width, int height) {
		super(width,height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		playerhomebg = new Graphic(0,0,"resources/home.png");
		playerhomebg.setX((getWidth()-playerhomebg.getWidth())/2);
		viewObjects.add(playerhomebg);
	}

}
