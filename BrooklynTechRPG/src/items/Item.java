package items;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import TechRPG.TechGame;
import guiTeacher.components.Action;
import guiTeacher.components.Component;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Clickable;
import player.Player;
import techInterfaces.Ability;

public abstract class Item extends Component implements Clickable {

	private String name;
	private String description;
	private Ability ability; //adds to stat
	private double cost;
	private Graphic graphic;
	private TextLabel label;
	private TextLabel qtylabel;
	private int quantity;
	private Action action;
	private InfoBox infobox;
	
	public static final int ITEM_WIDTH = 300;
	public static final int ITEM_HEIGHT = 80;

	public Item(int x, int y, String imageLocation, int qty) {
		super(x, y, ITEM_WIDTH, ITEM_HEIGHT);
		graphic = new Graphic(0,0,ITEM_HEIGHT,ITEM_HEIGHT,imageLocation);
		label = new TextLabel(ITEM_HEIGHT,0,ITEM_WIDTH-ITEM_HEIGHT,25,"");
		qtylabel = new TextLabel(ITEM_WIDTH-10,0,ITEM_WIDTH-ITEM_HEIGHT-15,25,""+quantity);
		qty = 0;
	}

	public void setInfoBox(InfoBox infobox){
		this.infobox = infobox;
	}
	
	public void use(){
		ability.use();
	}

	public String getName() {
		return name;
	}

	public void setName(String description) {
		this.name = description;
		label.setText(description);
		update();
	}
	
	public int getQuantity(){
		return quantity;
	}

	public void setQuantity(int quantity){
		this.quantity = quantity;
		qtylabel.setText(""+quantity);
		update();
		
	}
	
	public String getDescription() {
		return name;
	}

	public void setDescription(String name) {
		this.name = name;
	}

	public Ability getAbility() {
		return ability;
	}

	public void setAbility(Ability ability) {
		this.ability = ability;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		Player p = TechGame.getPlayer();
		this.cost = cost * p.getSocial();
	}

	@Override
	public void update(Graphics2D g) {
		if(label!=null){
			g.drawImage(graphic.getImage(),graphic.getX(),graphic.getY(),null);
			g.drawImage(label.getImage(),label.getX(),label.getY(),null);
			g.drawImage(qtylabel.getImage(), qtylabel.getX(), qtylabel.getY(), null);
		}
	}

	@Override
	public boolean isHovered(int x, int y) {
		boolean hovered = x > getX() && x < getX()+getWidth() && y > getY() && y < getY()+getHeight();
		if(hovered && infobox!=null){
			infobox.setText(name);
		}
		return hovered;
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAction(Action a) {
		// TODO Auto-generated method stub
		
	}




}
