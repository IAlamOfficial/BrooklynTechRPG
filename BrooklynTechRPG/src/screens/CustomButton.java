package screens;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.interfaces.Clickable;
import guiTeacher.components.TextLabel;

public class CustomButton extends Button implements Clickable{


	public CustomButton(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, text, action);
		setForeground(Color.black);
		update();
	}


	public void drawBorder(Graphics2D g, boolean hover){
		super.drawBorder(g, hover);
		if(hover){
			FontMetrics fm = g.getFontMetrics(getFont());
			g.setStroke(new BasicStroke(5));
			int x = (getWidth()-fm.stringWidth(getText()))/2;
			int y = getHeight()/2 + fm.getHeight()/2;
			g.drawLine(x, y, x+fm.stringWidth(getText()) , y);
		}
	}

}
