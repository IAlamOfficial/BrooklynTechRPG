package screens;

import guiTeacher.components.Action;
import guiTeacher.interfaces.Clickable;
import guiTeacher.components.TextLabel;

public class CustomButton extends TextLabel implements Clickable{
private Action action;


	public CustomButton(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, text);
		this.action = action;
		update();
	}

	@Override 
	public boolean isHovered(int x, int y) {
		return x > getX() && x < getX() + getWidth() && y > getY() && y < getY() + getHeight();
	}

	@Override
	public void act() {
		action.act();
	}

}
