package items;

public class StudyGuide extends Item {

	public StudyGuide(int x, int y, int w, int h, String imageLocation) {
		super(x, y, w, h, "resources/studyguide.png");
		setName("Study Guide");	
		setDescription("Time to study like a good boy!");
	}

}
