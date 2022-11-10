import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.URL;

public class xpath {
    static void printTitles(Node e) {
        System.out.println("Titles of all MATH courses that are taught in room LIB 204 are as follows -");
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
        System.out.println("X------------------------X-------------------------------X");
    }

    static void printInstructors(Node e) {
        System.out.println("Instructor name who teaches MATH 412 are as follows -");
        NodeList childs = e.getChildNodes();
        for (int k = 0; k < childs.getLength(); k++) {
            Node n = childs.item(k);
            if (n.hasChildNodes()) {
                if (((Element) n).getElementsByTagName("subj").item(0).getTextContent().equalsIgnoreCase("MATH")
                        && ((Element) n).getElementsByTagName("crse").item(0).getTextContent()
                                .equalsIgnoreCase("412")) {
                    System.out.println(((Element) n).getElementsByTagName("instructor").item(0).getTextContent());

                }
            }
        }
        System.out.println("X------------------------X-------------------------------X");
    }

    static void printTitlesFromWieting(Node e) {
        System.out.println("Titles of all courses taught by Wieting are as follows -");
        NodeList childs = e.getChildNodes();
        for (int k = 0; k < childs.getLength(); k++) {
            Node n = childs.item(k);
            if (n.hasChildNodes()) {
                if (((Element) n).getElementsByTagName("instructor").item(0).getTextContent()
                        .equalsIgnoreCase("Wieting")) {
                    System.out.println(((Element) n).getElementsByTagName("title").item(0).getTextContent());

                }
            }
        }
        System.out.println("X------------------------X-------------------------------X");
    }

    public static void main(String args[]) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db
                .parse((new URL("http://aiweb.cs.washington.edu/research/projects/xmltk/xmldata/data/courses/reed.xml"))
                        .openStream());
        Node root = doc.getDocumentElement();
        printTitles(root);
        printInstructors(root);
        printTitlesFromWieting(root);
    }
}
