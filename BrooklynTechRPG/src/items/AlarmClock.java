package items;

public class AlarmClock extends Item {

	public AlarmClock(int x, int y, int w, int h, int qty) {
		super(x, y, "resources/alarmclock.png", qty);
		setName("Alarm Clock");	
		setDescription("Wake up!");
		setQuantity(0);
	}

}
