package stax;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import model.Letter;

public class StaxParserLetter {
	private static final String TO = "To";
	private static final String SUBJECT = "Subject";
	private static final String BODY = "Body";
	private static final String ID = "id";
	private static final String LETTER = "Letter";
	private Letter letter;
	List<Letter> letters = new ArrayList<>();

	public List<Letter> parse(XMLEventReader xmlEventReader) throws FileNotFoundException, XMLStreamException {
		while (xmlEventReader.hasNext()) {
			XMLEvent xmlEvent = xmlEventReader.nextEvent();
			proceedStartElement(xmlEvent, xmlEventReader);
			proceedEndElement(xmlEvent);
		}
		return letters;
	}

	private void proceedStartElement(XMLEvent xmlEvent, XMLEventReader xmlEventReader) throws XMLStreamException {
		if (xmlEvent.isStartElement()) {
			StartElement startElement = xmlEvent.asStartElement();
			if (isTagNameEqual(startElement, LETTER)) {
				letter = new Letter();
				Attribute attribute = startElement.getAttributeByName(new QName(ID));
				if (attribute != null) {
					letter.setId(Integer.parseInt(attribute.getValue()));
				}
			}
			// set the other varibles from xml elements
			else if (isTagNameEqual(startElement, TO)) {
				letter.setTo(xmlEventReader.nextEvent().asCharacters().getData());
			} else if (isTagNameEqual(startElement, SUBJECT)) {
				letter.setSubject(xmlEventReader.nextEvent().asCharacters().getData());
			} else if (isTagNameEqual(startElement, BODY)) {
				letter.setBody(xmlEventReader.nextEvent().asCharacters().getData());
			}
		}
	}

	private void proceedEndElement(XMLEvent xmlEvent) {
		if (xmlEvent.isEndElement()) {
			EndElement endElement = xmlEvent.asEndElement();
			if (endElement.getName().getLocalPart().equals(LETTER)) {
				letters.add(letter);
			}
		}
	}

	private boolean isTagNameEqual(StartElement startElement, String tagName) {
		return startElement.getName().getLocalPart().equals(tagName);
	}
}
