package items;

public class Coffee extends Item {

	public Coffee(int x, int y, int w, int h) {
		super(x, y, w, h, "resources/coffee.png");
		setName("Coffee");
		setDescription("Time to stay up all night!");
	}

}
