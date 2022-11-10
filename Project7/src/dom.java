import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.URL;

public class dom {

    static void print(Node e) {
        NodeList childs = e.getChildNodes();
        for (int k = 0; k < childs.getLength(); k++) {
            Node n = childs.item(k);
            if (n.hasChildNodes()) {
                if (((Element) n).getElementsByTagName("subj").item(0).getTextContent().equalsIgnoreCase("MATH")) {
                    Element place = (Element) ((Element) n).getElementsByTagName("place").item(0);
                    if (place.getElementsByTagName("building").item(0).getTextContent().equalsIgnoreCase("LIB") &&
                            place.getElementsByTagName("room").item(0).getTextContent().equalsIgnoreCase("204")) {
                        System.out.println(((Element) n).getElementsByTagName("title").item(0).getTextContent());
                    }
                }
            }
        }
    }

    public static void main(String args[]) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db
                .parse((new URL("http://aiweb.cs.washington.edu/research/projects/xmltk/xmldata/data/courses/reed.xml"))
                        .openStream());
        Node root = doc.getDocumentElement();
        print(root);
    }
}