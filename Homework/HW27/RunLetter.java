package runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import dom.DomParserLetter;
import model.Letter;
import sax.LetterHandler;
import stax.StaxParserLetter;

public class RunLetter {

	private static final String LETTER_XML = "letter.xml";

	public static void main(String[] args)
			throws ParserConfigurationException, SAXException, IOException, XMLStreamException {
		System.out.println(" ========================= SAX parser ==============================");
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		SAXParser saxParser = saxParserFactory.newSAXParser();
		LetterHandler letterHandler = new LetterHandler();
		saxParser.parse(new File(LETTER_XML), letterHandler);
		List<Letter> letters = letterHandler.getletters();
		letters.forEach(letter -> System.out.println(letter));

		System.out.println(" ============================== STAX parser =========================");
		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
		XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(LETTER_XML));
		letters = new StaxParserLetter().parse(xmlEventReader);
		letters.forEach(letter -> System.out.println(letter));

		System.out.println(" ============================== DOM parser =========================");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document document = dBuilder.parse(LETTER_XML);
		letters = new DomParserLetter().parse(document);
		letters.forEach(letter -> System.out.println(letter));
	}

}
