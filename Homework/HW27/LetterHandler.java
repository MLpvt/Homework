package sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import model.Letter;

public class LetterHandler extends DefaultHandler {
	private List<Letter> letters;
	private Letter letter;
	boolean bTo = false;
	boolean bSubject = false;
	boolean bBody = false;

	public List<Letter> getletters() {
		return letters;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if (qName.equalsIgnoreCase("Letter")) {
			String id = attributes.getValue("id");
			letter = new Letter();
			letter.setId(Integer.parseInt(id));
			if (letters == null) {
				letters = new ArrayList<Letter>();
			}
		} else if (qName.equalsIgnoreCase("to")) {
			bTo = true;
		} else if (qName.equalsIgnoreCase("subject")) {
			bSubject = true;
		} else if (qName.equalsIgnoreCase("body")) {
			bBody = true;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equalsIgnoreCase("Letter")) {
			letters.add(letter);
		}
	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException {

		if (bTo) {
			letter.setTo((new String(ch, start, length)));
			bTo = false;
		} else if (bSubject) {
			letter.setSubject(new String(ch, start, length));
			bSubject = false;
		} else if (bBody) {
			letter.setBody(new String(ch, start, length));
			bBody = false;
		}
	}
}
