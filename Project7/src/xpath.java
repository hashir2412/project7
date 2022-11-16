// https://stackoverflow.com/questions/38207465/how-to-use-and-operator-in-xpath

import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;
import org.w3c.dom.*;

class XPATH {
    static void print(Node e) {
        if (e instanceof Text)
            System.out.println(((Text) e).getData());
        else {
            NodeList c = e.getChildNodes();
            for (int k = 0; k < c.getLength(); k++)
                print(c.item(k));
        }
    }

    static void eval(String query, Document doc) throws Exception {
        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        NodeList result = (NodeList) xpath.evaluate(query, doc, XPathConstants.NODESET);
        System.out.println("XPath query: " + query);
        for (int i = 0; i < result.getLength(); i++)
            print(result.item(i));
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db
                .parse((new URL("http://aiweb.cs.washington.edu/research/projects/xmltk/xmldata/data/courses/reed.xml"))
                        .openStream());
        System.out.println("Titles of all MATH courses that are taught in room LIB 204 are as follows:");
        eval("//course[subj='MATH' and place/building='LIB' and place/room='204']/title", doc);
        System.out.println("X--------------------------------X--------------------------------X");
        System.out.println("Instructor name who teaches MATH 412 are as follows:");
        eval("//course[subj='MATH' and crse='412']/instructor", doc);
        System.out.println("X--------------------------------X--------------------------------X");
        System.out.println("Titles of all courses taught by Wieting are as follows:");
        eval("//course[instructor='Wieting']/title", doc);
        System.out.println("X--------------------------------X--------------------------------X");
    }
}
