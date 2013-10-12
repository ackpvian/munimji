package in.co.sdslabs.munimji.item;

public class EntryItem implements Item {

	public final String name;
	public final String location;
	public final String time;
	public final String date;
	public final Integer image;
	public final String url;

	public EntryItem(Integer image, String name, String location, String time,
			String date, String url) {
		this.name = name;
		this.image = image;
		this.location = location;
		this.time = time;
		this.date = date;
		this.url = url;
	}

	@Override
	public boolean isSection() {
		return false;
	}

}
