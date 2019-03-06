public class Example {

	public static void main(String[] args) {

		Page page = new Page();
		Button button1 = new Button("enter", "action1");
		Button button2 = new Button("space", "action2");
		page.add(button1);
		page.add(button2);
		page.replace(button1, new Button("caps", "action3"));
		page.remove(button2);
		page.printButtons();

		Field field1 = new Field(1, "field1");
		Field field2 = new Field(2, "field2");
		page.add(field1);
		page.add(field2);
		page.replace(field1, new Field(3, "field3"));
		page.remove(field2);
		page.printFields();

		Label label1 = new Label("label1");
		Label label2 = new Label("label2");
		page.add(label1);
		page.add(label2);
		page.replace(label1, new Label("label3"));
		page.remove(label2);
		page.printLabels();

		Dropdown dropdown1 = new Dropdown(null, false, "dropdown1");
		Dropdown dropdown2 = new Dropdown(null, false, "dropdown2");
		page.add(0, dropdown1);
		page.add(1, dropdown2);
		page.replace(0, dropdown1, new Dropdown(null, false, "dropdown3"));
		page.remove(1, dropdown2);
		page.printDropdowns();

	}

}
