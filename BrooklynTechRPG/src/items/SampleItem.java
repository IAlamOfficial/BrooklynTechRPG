package items;

public class SampleItem extends Item {

	public SampleItem(int x, int y, int w, int h, int qty) {
		super(x, y,"resources/jackiechan.jpg", qty);
		setName("hi im jackie chan");
		setDescription("test");
		setQuantity(0);
	}

}
