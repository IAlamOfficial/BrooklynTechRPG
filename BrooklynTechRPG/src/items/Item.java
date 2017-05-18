package items;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import guiTeacher.components.Component;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextLabel;
import techInterfaces.Ability;

public abstract class Item extends Component {

	private String description;
	private String name;
	private Ability ability; //adds to stat
	private double cost;
	private Graphic graphic;
	private TextLabel label;

	public Item(int x, int y, int w, int h, String imageLocation) {
		super(x, y, w, h);
		graphic = new Graphic(0,0,h,h,imageLocation);
		label = new TextLabel(h,0,w-h,25,"");
		// TODO Auto-generated constructor stub
	}

	public void use(){
		ability.use();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
		label.setText(description);
		update();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
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
		this.cost = cost;
	}

	@Override
	public void update(Graphics2D g) {
		if(label!=null){
			g.drawImage(graphic.getImage(),graphic.getX(),graphic.getY(),null);
			g.drawImage(label.getImage(),label.getX(),label.getY(),null);
		}
	}




}
