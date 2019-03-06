import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class Page {

	private ArrayList<Button> buttons = new ArrayList<Button>();
	private LinkedList<Field> fields = new LinkedList<Field>();
	private HashSet<Label> labels = new HashSet<Label>();
	private HashMap<Integer, Dropdown> dropdowns = new HashMap<Integer, Dropdown>();
	private float id;
	private String title;

	public void add(Button button) {
		buttons.add(button);
	}

	public void remove(Button button) {
		buttons.remove(button);
	}

	public void replace(Button oldButton, Button newButton) {
		for (int i = 0; i < buttons.size(); i++) {
			if (buttons.get(i).equals(newButton)) {
				buttons.set(i, newButton);
			}
		}

	}
	public void printButtons() {
		Iterator<Button> iterator = buttons.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	public void add(Field field) {
		fields.add(field);
	}

	public void remove(Field field) {
		fields.remove(field);
	}

	public void replace(Field oldField, Field newField) {
		for (int i = 0; i < fields.size(); i++) {
			if (fields.get(i).equals(newField)) {
				fields.set(i, newField);
			}
		}
	}
	public void printFields() {
		Iterator<Field> iterator = fields.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	public void add(Label label) {
		labels.add(label);
	}

	public void remove(Label label) {
		labels.remove(label);
	}

	public void replace(Label oldLabel, Label newLabel) {
		if (labels.remove(oldLabel)) {
			labels.add(newLabel);
		}
	}
	public void printLabels() {
		Iterator<Label> iterator = labels.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	public void add(int index, Dropdown dropdown) {
		dropdowns.put(index, dropdown);
	}

	public void remove(int index, Dropdown dropdown) {
		dropdowns.remove(index, dropdown);
	}

	public void replace(int key, Dropdown oldDropdown, Dropdown newDropdown) {
		dropdowns.replace(key, oldDropdown, newDropdown);
	}
	public void printDropdowns() {
		Iterator<Dropdown> iterator = dropdowns.values().iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

}
