package screens;

import java.awt.FontMetrics;
import java.awt.Graphics2D;

import guiTeacher.components.TextLabel;

public class DescriptionTextLabel extends TextLabel {

	public DescriptionTextLabel(int x, int y, int w, int h, String text) {
		super(x, y, w, h, text);
		// TODO Auto-generated constructor stub
	}
	public void drawString(Graphics2D g, FontMetrics fm){
		String s = getText();
		int start;
		int line = 1;
		int x = (getWidth()-fm.stringWidth(s))/2;
		
		
		
		g.drawString(getText(), 0, (fm.getHeight()*line));
	}
}