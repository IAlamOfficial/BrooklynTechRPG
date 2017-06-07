package npc;

import items.Item;
import player.Player;

public class Faculty extends NPC {

	boolean ability;
	
	public Faculty(String name, boolean ability) {
		super(name);
		this.ability = ability;
	}
	
	public boolean collectHW(Player p, Item i){
		boolean flag = false;
		if(p.getHw()>0){
			p.setHw(-1);
		}else if(i.getQuantity()>0){
			i.setQuantity(i.getQuantity()-1);
			if(p.getRep()<5){
				flag = true;
			}
		}

		return flag;
		
	}
	
	
}
