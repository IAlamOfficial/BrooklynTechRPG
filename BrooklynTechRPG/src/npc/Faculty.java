package npc;

import player.Player;

public class Faculty extends NPC {

	boolean ability;
	
	public Faculty(String name, boolean ability) {
		super(name);
		this.ability = ability;
	}
	
	public boolean collectHW(Player p){
		boolean flag = false;
		if(p.getHw()>0){
			p.setHw(-1);
		}
		/**
		 * create after items have been fixed
		 */
//		else if(){
//			
//		}
		else if(p.getRep()<25){
			flag = true;
		}
		
		return flag;
		
	}
	
	
}
