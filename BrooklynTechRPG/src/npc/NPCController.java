package npc;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import guiTeacher.components.Component;
import guiTeacher.interfaces.KeyedComponent;
import items.Item;
import player.Player;
import screens.InventoryScreen;

public class NPCController extends Component implements KeyedComponent {

	NPCEvent event;
	Player p;
	
	public NPCController(int width, int height, NPCEvent npcEvent, Player p) {
		super(0,0,width, height);
		this.event = npcEvent;
		this.p = p;
	}

	@Override
	public void keyPressed(KeyEvent k) {
		if(k.getKeyCode()==KeyEvent.VK_Q){
			if(event.getNPC() instanceof Bully && p.getEnergy() > 20){
				p.setEnergy(-20);
				Bully b = (Bully)event.getNPC();
				boolean result = b.fight(p.getStrength());
				event.beatBully(result);
			}else{
				event.couldNotFight();
			}
			if(event.getNPC() instanceof Merchant ){
				
				//Merchant m = (Merchant)event.getNPC();
				event.purchaseItem(InventoryScreen.coffee);
			}else{
				
			}
			if(event.getNPC() instanceof Faculty && p.getHw() > 0){
				Faculty f = (Faculty)event.getNPC();
				boolean result = f.collectHW(p);
				event.returnHomework(result);
			}else{
				event.haveNoHomework();
			}
		}
	}


	@Override
	public void keyReleased(KeyEvent k) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent k) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isHovered(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setFocus(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}

}
