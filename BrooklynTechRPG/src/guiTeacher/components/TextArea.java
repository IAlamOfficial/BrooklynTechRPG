/*******************************************************************************
 * Copyright (c) 2016-2017 Benjamin Nockles
 *
 * This file is part of OrcMath.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, 
 * but WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License 
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *******************************************************************************/
package guiTeacher.components;

import java.awt.BasicStroke;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;

public class TextArea extends TextLabel {

	private boolean showBorder;
	private int borderThickness;
	
	public TextArea(int x, int y, int w, int h, String text) {
		super(x, y, w, h, text);
		showBorder = false;
		borderThickness = 1;
	}

	public void showBorder(boolean b){
		showBorder = b;
		update();
	}
	
	public void setBorderThickness(int x){
		borderThickness = x;
		update();
	}
	
	public void update(Graphics2D g){
		clear();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setFont(getFont());
		FontMetrics fm = g.getFontMetrics();
		g.setColor(getTextColor());
		if(showBorder){
			Stroke old = g.getStroke();
			g.setStroke(new BasicStroke(borderThickness));
			g.drawRect(borderThickness/2, borderThickness/2, getWidth()-3*borderThickness/2, getHeight()-3*borderThickness/2);
			g.setStroke(old);
		}
		if(getText() != null){
			String[] paragraphs = getText().split("\n");
			final int SPACING = 2;
			int y = 0 + fm.getHeight()+SPACING;
			for(String paragraph: paragraphs){
				String[] words = paragraph.split(" ");
				if(words.length >0){
					int i = 0;
					String line = "";
					//				i++;
					while(i < words.length){
						while(i < words.length && fm.stringWidth(line) + fm.stringWidth(words[i]) < getWidth()-borderThickness){
							line += words[i]+" ";
							i++;
						}
						if(y < getHeight()){
							g.drawString(line, borderThickness+2, y);
							y += fm.getDescent() + fm.getHeight()+SPACING;
							line = "";
						}else{
							break;//print no more text
						}
					}
				}
			}
		}
	}

}
