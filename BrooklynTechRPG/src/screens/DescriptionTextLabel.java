package screens;

import java.awt.FontMetrics;
import java.awt.Graphics2D;

import guiTeacher.components.TextLabel;

public class DescriptionTextLabel extends TextLabel {
	
	private int width;
	
	public DescriptionTextLabel(int x, int y, int w, int h, String text) {
		super(x, y, w, h, text);
		this.width = w;
	}
	public void drawString(Graphics2D g, FontMetrics fm){
		String s = getText();
		//int x = (getWidth()/fm.stringWidth(s.substring(0,1)));
		int start = 0;
		int end = width/fm.stringWidth(s.substring(0,1));
		int line = 1;
		
		
		
		while(end<fm.stringWidth(s)){
			g.drawString(s.substring(start,end), 0, (fm.getHeight()*line));
			line++;
		}
		g.drawString(s.substring(start,end), 0, (fm.getHeight()*line));
	}
}