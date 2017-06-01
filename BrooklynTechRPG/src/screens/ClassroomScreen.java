package screens;

import java.awt.event.KeyListener;
import java.util.List;

import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class ClassroomScreen extends FullFunctionScreen implements Runnable, KeyListener {
	
	private Graphic classroombg;

	public ClassroomScreen(int width, int height) {
		super(width,height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		classroombg = new Graphic(0,0,"resources/classroom.png");
		classroombg.setX((getWidth()-classroombg.getWidth())/2);
		viewObjects.add(classroombg);
		
	}

}
