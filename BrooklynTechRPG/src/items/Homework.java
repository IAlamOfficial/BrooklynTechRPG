package items;

public class Homework extends Item {

	public Homework(int x, int y, int w, int h, int qty) {
		super(x, y,"resources/textbook.png", qty);
		setName("Homework Pass");	
		setDescription("I ain't doing my homework!");
		setQuantity(0);
	}

}
