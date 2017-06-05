package items;

public class Coffee extends Item {

	public Coffee(int x, int y, int w, int h, int qty) {
		super(x, y, "resources/coffee.png", qty);
		setName("Coffee");
		setDescription("Time to stay up all night!");
		setQuantity(0);
	}

}
