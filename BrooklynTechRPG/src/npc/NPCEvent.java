package npc;

import guiTeacher.components.Action;
import guiTeacher.interfaces.TextComponent;
import items.Item;
import player.Player;

public class NPCEvent implements Runnable{
	private NPC npc;
	private TextComponent target;
	private Player p;
	private Item i;
	
	public NPCEvent(Player p, NPC npc, TextComponent target) {
		this.npc = npc;
		this.target = target;
		this.p = p;
		
	}
	public NPCEvent(Player p, NPC npc, TextComponent target, Item i) {
		this.npc = npc;
		this.target = target;
		this.p = p;
		this.i= i;
		
	}
	
	
	@Override
	public void run() {
		this.target.setText("You just ran into "+ npc.getName()+". What would you like to do?");
		
	}
	public NPC getNPC() {
		return npc;
	}
	
	public void showText(String[] arr, Action a){
		if( a != null){
			a.act();
		}
		Thread text = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i<arr.length; i++){
					NPCEvent.this.target.setText(arr[i]);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		text.start();
		}
	
	public void beatBully(boolean result) {

		if(result){
			String[] arr = {"You beat the bully!","You earned $5.00", "You have a total of " + p.getMoney()};
			showText(arr, new Action() {
				
				@Override
				public void act() {
					NPCEvent.this.p.setMoney(5.00);
				}
			});
		}
		else{
			String[] arr = {"You lost to the bully!","You lost $5.00", "You have a total of " + p.getMoney()};
			showText(arr, new Action() {
				
				@Override
				public void act() {
					NPCEvent.this.p.setMoney(-5.00);
				}
			});
		}
		
	}
	
	public void purchaseItem(Item item){
		i = item;
		String[] arr = {"You have purchased " + i.getName() + " for " + (i.getCost()*p.getSocial()), "You have a total of " + p.getMoney()};
		showText(arr, new Action() {
			
			@Override
			public void act() {
				NPCEvent.this.p.setMoney((i.getCost()*p.getSocial())*-1);
				NPCEvent.this.i.setQuantity(NPCEvent.this.i.getQuantity());
				
			}
		});
	}

}
