package dom;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import model.Letter;

public class DomParserLetter {
	public List<Letter> parse(Document document) throws FileNotFoundException, XMLStreamException {
		NodeList nodeList = document.getElementsByTagName("Letter");
		List<Letter> letters = new ArrayList<Letter>();
		for (int i = 0; i < nodeList.getLength(); i++) {
			letters.add(getLetter(nodeList.item(i)));
		}
		return letters;
	}

	private static Letter getLetter(Node node) {
		Letter letter = new Letter();
		Element element = (Element) node;
		letter.setId(Integer.parseInt(element.getAttribute("id")));
		letter.setTo(getTagValue("To", element));
		letter.setSubject(getTagValue("Subject", element));
		letter.setBody(getTagValue("Body", element));

		return letter;
	}

	private static String getTagValue(String tag, Element element) {
		NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
		Node node = nodeList.item(0);
		return node.getNodeValue();
	}
}
