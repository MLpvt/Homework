import java.util.List;
import java.util.ArrayList;

public class Dropdown {

	List<String> options = new ArrayList<String>();
	private boolean isSelected;
	private String name;

	public Dropdown(List<String> options, boolean isSelected, String name) {
		this.options = options;
		this.isSelected = isSelected;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Dropdown " + options + " " + isSelected + " " + name;
	}

}
