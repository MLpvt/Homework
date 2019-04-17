package parser;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLStreamException;

import org.xml.sax.SAXException;

public class LetterParser {

	public Letter parseLetter(String file)
			throws ParserConfigurationException, SAXException, IOException, XMLStreamException {
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		SAXParser saxParser = saxParserFactory.newSAXParser();
		LetterHandler letterHandler = new LetterHandler();
		saxParser.parse(new File(file), letterHandler);
		return letterHandler.getLetter();
	}

}
