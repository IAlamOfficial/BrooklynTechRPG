package items;

public class EnergyDrink extends Item {

	public EnergyDrink(int x, int y, int w, int h, int qty) {
		super(x, y,"resources/energy.png", qty);
		setName("Energy Drink");	
		setDescription("INEEDMOREENERGY");
		setQuantity(0);
	}

}
