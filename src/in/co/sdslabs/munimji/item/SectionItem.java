package in.co.sdslabs.munimji.item;

public class SectionItem implements Item{

	private final String name;
	
	public SectionItem(String name) {
		this.name = name;
	}
	
	public String getTitle(){
		return name;
	}
	
	@Override
	public boolean isSection() {
		return true;
	}

}