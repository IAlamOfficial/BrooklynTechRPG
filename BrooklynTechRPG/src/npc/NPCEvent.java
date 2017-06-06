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
			String[] arr = {"You beat the bully!","You earned $5.00", "You have a total of $" + p.getMoney()};
			showText(arr, new Action() {
				
				@Override
				public void act() {
					NPCEvent.this.p.setMoney(20.00);
					NPCEvent.this.p.setRep(-5);
					NPCEvent.this.p.setSocial(-0.6);
				}
			});
		}
		else{
			String[] arr = {"You lost to the bully!","You lost $5.00", "You have a total of $" + p.getMoney()};
			showText(arr, new Action() {
				
				@Override
				public void act() {
					NPCEvent.this.p.setMoney(-5.00);
					NPCEvent.this.p.setSocial(0.1);
					
				}
			});
		}
		
	}
	
	public void couldNotFight() {
		String[] arr = {"Sorry you do not have enough energy to fight the bully"};
		showText(arr, null);
		
	}
	
	public void purchaseItem(Item item){
		i = item;
		String[] arr = {"You have purchased " + i.getName() + " for $" + (i.getCost()*p.getSocial()), "You have a total of $" + p.getMoney()};
		showText(arr, new Action() {
			
			@Override
			public void act() {
				NPCEvent.this.p.setMoney((i.getCost()*p.getSocial())*(-1));
				NPCEvent.this.i.setQuantity(NPCEvent.this.i.getQuantity()+1);
				
			}
		});
	}
	
	public void returnHomework(boolean result) {
		if(!result){
			String[] arr = {"You gave in the homework","You have recived 10 Knowledge points", "You have a total of " + p.getKnowledgePoints() + " knowledge points"};
			showText(arr, new Action() {

				@Override
				public void act() {
					NPCEvent.this.p.setKnowledgePoints(10);
					NPCEvent.this.p.setRep(1);
					
					
				}
				
			});
		}else{
			String[] arr = {"You got caught using someone else homework","You have lost 25 Knowledge points", "You have a total of " + p.getKnowledgePoints() + " knowledge points"};
			showText(arr, new Action() {

				@Override
				public void act() {
					NPCEvent.this.p.setKnowledgePoints(-25);
					NPCEvent.this.p.setRep(-10);
					
				}
			});	
				
		}
		
	}

	public void haveNoHomework(){
		String[] arr = {"You have no homework to give"};
		showText(arr, null);
	}
	public void couldNotPpurchase() {
		String[] arr = {"Sorry you do not have enough money to purchase this item"};
		showText(arr, null);
		
	}

	
	
}
