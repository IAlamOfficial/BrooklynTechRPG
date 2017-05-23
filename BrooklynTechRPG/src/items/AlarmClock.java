package items;

public class AlarmClock extends Item {

	public AlarmClock(int x, int y, int w, int h) {
		super(x, y, w, h, "resources/alarmclock.png");
		setName("Alarm Clock");	
		setDescription("Wake up!");
	}

}
