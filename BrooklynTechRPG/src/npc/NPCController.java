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
	Item i;
	
	public NPCController(int width, int height, NPCEvent npcEvent, Player p) {
		super(0,0,width, height);
		this.event = npcEvent;
		this.p = p;
	}
	
	public NPCController(int width, int height, NPCEvent npcEvent, Player p, Item i) {
		super(0,0,width, height);
		this.event = npcEvent;
		this.p = p;
		this.i = i;
	}

	@Override
	public void keyPressed(KeyEvent k) {
		if(k.getKeyCode()==KeyEvent.VK_Q){
			if(event.getNPC() instanceof Bully){
				if(p.getEnergy() > 20){
					p.setEnergy(-20);
					Bully b = (Bully)event.getNPC();
					boolean result = b.fight(p.getStrength());
					event.beatBully(result);
				}else{
					event.couldNotFight();
				}
			}
			
			if(event.getNPC() instanceof Merchant ){
				if(p.getMoney()>i.getCost()){
				event.purchaseItem(InventoryScreen.coffee);
				}else{
					event.couldNotPpurchase();
				}
			}
			/*
			 * item should only be hW
			 */
			if(event.getNPC() instanceof Faculty){
				if(p.getHw() + i.getQuantity()> 0){
				Faculty f = (Faculty)event.getNPC();
					boolean result = f.collectHW(p,i);
					event.returnHomework(result);
				}else{
					event.haveNoHomework();
				}
			}
			
			if(event.getNPC() instanceof HomeworkTable){
				if(p.getEnergy()>1 && p.getTime()>0){
					event.doMath(p);
				}else{
					if(p.getEnergy()<2){
						event.dontDoMath("energy");
					}else{
						event.dontDoMath("time");
					}
				}
			}
			
			if(event.getNPC() instanceof Computer){
				if(p.getEnergy()>0 && p.getTime()>0){
					event.socialMedia(p);
				}else{
					if(p.getEnergy()<1){
						event.dontDoSocialMedia("energy");
					}else{
						event.dontDoSocialMedia("time");
					}
				}
			}
			
			if(event.getNPC() instanceof Ball){
				if(p.getEnergy()>3 && p.getTime()>3){
					event.play(p);
				}else{
					if(p.getEnergy()<1){
						event.dontPlay("energy");
					}else{
						event.dontPlay("time");
					}
				}
			}
			
			if(event.getNPC() instanceof ClassTable){
				if(p.getEnergy()>5 && p.getTime()>5){
					event.learn(p);
				}else{
					if(p.getEnergy()<1){
						event.dontLearn("energy");
					}else{
						event.dontLearn("time");
					}
				}
			}
			
			if(event.getNPC() instanceof Food){
				if(p.getTime()>0){
					event.eat(p);
				}else{
					if(p.getEnergy()<1){
						event.dontEat();
					}
				}
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
