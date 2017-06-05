package items;

public class StudyGuide extends Item {

	public StudyGuide(int x, int y, int w, int h, int qty) {
		super(x, y, "resources/studyguide.png", qty);
		setName("Study Guide");	
		setDescription("Time to study like a good boy!");
		setQuantity(0);
	}

}
