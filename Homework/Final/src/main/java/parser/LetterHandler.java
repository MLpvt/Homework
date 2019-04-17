package parser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class LetterHandler extends DefaultHandler {
	private Letter letter;
	private boolean bTo = false;
	private boolean bSubject = false;
	private boolean bBody = false;

	public Letter getLetter() {
		return letter;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if (qName.equalsIgnoreCase("Letter")) {
			letter = new Letter();
		} else if (qName.equalsIgnoreCase("to")) {
			bTo = true;
		} else if (qName.equalsIgnoreCase("subject")) {
			bSubject = true;
		} else if (qName.equalsIgnoreCase("body")) {
			bBody = true;
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
