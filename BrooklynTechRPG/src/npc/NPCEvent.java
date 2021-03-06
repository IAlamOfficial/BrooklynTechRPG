package npc;

import guiTeacher.components.Action;
import guiTeacher.interfaces.TextComponent;
import items.Item;
import player.Player;
import screens.ClassroomScreen;
import screens.HallwayScreen;
import screens.HomeScreen;

public class NPCEvent implements Runnable{
	private NPC npc;
	private TextComponent target;
	private Player p;
	private Item i;
	
	public NPCEvent(Player p, NPC npc) {
		this.npc = npc;

		this.p = p;
		
	}
	
	public NPCEvent(Player p, NPC npc, Item i) {
		this.npc = npc;
		this.p = p;
		this.i= i;
		
	}
	
	
	@Override
	public void run() {
		//textBox.setText
		String[] arr = {"You just ran into "+ npc.getName()+". What would you like to do?"};
		showTextHome(arr, null);
		showTextClass(arr, null);
		showTextHall(arr, null);
	}
	
	private void showTextHome(String[] arr, Action a) {
		if( a != null){
			a.act();
		}
		Thread text = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i<arr.length; i++){
					HomeScreen.textBox.setText(arr[i]);
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

	private void showTextClass(String[] arr, Action a) {
		if( a != null){
			a.act();
		}
		Thread text = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i<arr.length; i++){
					ClassroomScreen.textBox.setText(arr[i]);
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

	
	public void showTextHall(String[] arr, Action a){
		if( a != null){
			a.act();
		}
		Thread text = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i<arr.length; i++){
					HallwayScreen.textBox.setText(arr[i]);
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
	
	public NPC getNPC() {
		return npc;
	}
	
	public void beatBully(boolean result) {

		if(result){
			String[] arr = {"You beat the bully!","You earned $5.00", "You have a total of $" + p.getMoney()};
			showTextHall(arr, new Action() {
				
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
			showTextHall(arr, new Action() {
				
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
		showTextHall(arr, null);
		
	}
	
	public void purchaseItem(Item item){
		i = item;
		String[] arr = {"You have purchased " + i.getName() + " for $" + (i.getCost()*p.getSocial()), "You have a total of $" + p.getMoney()};
		showTextHall(arr, new Action() {
			
			@Override
			public void act() {
				NPCEvent.this.p.setMoney((i.getCost()*p.getSocial())*(-1));
				NPCEvent.this.i.setQuantity(NPCEvent.this.i.getQuantity()+1);
				
			}
		});
	}
	
	public void couldNotPpurchase() {
		String[] arr = {"Sorry you do not have enough money to purchase this item"};
		showTextHall(arr, null);
		
	}
	
	public void returnHomework(boolean result) {
		if(!result){
			String[] arr = {"You gave in the homework","You have recived 5 Knowledge points", "You have a total of " + p.getKnowledgePoints() + " knowledge points"};
			showTextClass(arr, new Action() {

				@Override
				public void act() {
					NPCEvent.this.p.setKnowledgePoints(5);
					NPCEvent.this.p.setRep(1);
					
					
				}
				
			});
		}else{
			String[] arr = {"You got caught using someone else homework","You have lost 25 Knowledge points", "You have a total of " + p.getKnowledgePoints() + " knowledge points"};
			showTextClass(arr, new Action() {

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
		showTextClass(arr, null);
	}
	
	public void doMath(Player p) {
		String[] arr = {"You have completed a homework assigment.","You have " + p.getHw() + " completed assigments"};
		showTextHome(arr, new Action() {

			@Override
			public void act() {
				NPCEvent.this.p.setKnowledgePoints(5);
				NPCEvent.this.p.setEnergy(-2);
				NPCEvent.this.p.setTime(-1);
				NPCEvent.this.p.setHw(1);
				NPCEvent.this.p.setSocial(.05);
			}
		});	
	}
	
	public void dontDoMath(String string) {
		String[] arr = {"You do not have enough " + string + " to complete your homweork"};
		showTextHome(arr, null);
		
	}
	
	public void socialMedia(Player p) {
		String[] arr = {"You have went online with friends", "You have gained a better reputation"};
		showTextHome(arr, new Action() {

			@Override
			public void act() {
				NPCEvent.this.p.setEnergy(-2);
				NPCEvent.this.p.setTime(-1);
				NPCEvent.this.p.setSocial(-.15);
			}
		});	
	}
	
	public void dontDoSocialMedia(String string) {
		String[] arr = {"You do not have enough " + string + " to go online"};
		showTextHome(arr, null);
		
	}
	
	public void play(Player p) {
		String[] arr = {"You have went outside to play", "You have gained more strength"};
		showTextHall(arr, new Action() {

			@Override
			public void act() {
				NPCEvent.this.p.setEnergy(-3);
				NPCEvent.this.p.setTime(-3);
				NPCEvent.this.p.setSocial(-.1);
				NPCEvent.this.p.setStrength(3);
			}
		});	
		
	}
	
	public void dontPlay(String string) {
		String[] arr = {"You do not have enough " + string + " to play outside"};
		showTextHall(arr, null);
		
	}
	
	public void learn(Player p) {
		String[] arr = {"You went to class and learned", "You have gained 10 knowledge points", "You have a total of " + p.getKnowledgePoints() + " knowledge points" };
		showTextClass(arr, new Action() {

			@Override
			public void act() {
				NPCEvent.this.p.setEnergy(-5);
				NPCEvent.this.p.setTime(-5);
				NPCEvent.this.p.setSocial(.05);
				NPCEvent.this.p.setKnowledgePoints(10);
				NPCEvent.this.p.setRep(1);
			}
		});	
		
	}
	
	public void dontLearn(String string) {
		String[] arr = {"You do not have enough " + string + " to go to class"};
		showTextClass(arr, null);
		
	}
	
	public void eat(Player p2) {
		String[] arr = {"You have went to eat", "You have gained more energy"};
		showTextHome(arr, new Action() {

			@Override
			public void act() {
				NPCEvent.this.p.setEnergy(5);
				NPCEvent.this.p.setTime(-1);
			}
		});	
		
		
	}

	public void dontEat() {
		String[] arr = {"You do not have enough time to go eat"};
		showTextHome(arr, null);
		
	}


	
	
}
