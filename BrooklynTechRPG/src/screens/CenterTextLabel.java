package screens;

import java.awt.FontMetrics;
import java.awt.Graphics2D;

import guiTeacher.components.TextLabel;

public class CenterTextLabel extends TextLabel {

	public CenterTextLabel(int x, int y, int w, int h, String text) {
		super(x, y, w, h, text);
		// TODO Auto-generated constructor stub
	}
	public void drawString(Graphics2D g, FontMetrics fm){
		String s = getText();
		int x = (getWidth()-fm.stringWidth(s))/2;
		g.drawString(getText(), x, fm.getHeight());
	}
}
