import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.URL;
import java.util.HashSet;

public class dom {

    static void print(Node e) {
        NodeList childs = e.getChildNodes();
        HashSet<String> hash = new HashSet<String>();
        for (int k = 0; k < childs.getLength(); k++) {
            Node n = childs.item(k);
            if (n.hasChildNodes()) {
                if (((Element) n).getElementsByTagName("subj").item(0).getTextContent().equalsIgnoreCase("MATH")) {
                    Element place = (Element) ((Element) n).getElementsByTagName("place").item(0);
                    if (place.getElementsByTagName("building").item(0).getTextContent().equalsIgnoreCase("LIB") &&
                            place.getElementsByTagName("room").item(0).getTextContent().equalsIgnoreCase("204")) {
                        String title = ((Element) n).getElementsByTagName("title").item(0).getTextContent();
                        if (!hash.contains(title)) {
                            hash.add(title);
                            System.out.println(title);
                        }
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