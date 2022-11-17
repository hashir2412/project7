package xslt;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;
import java.net.URL;

class XSLT {
    public static void main(String argv[]) throws Exception {
        File stylesheet = new File("xslt\\math.xsl");
        // File xmlfile = new File();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db
                .parse((new URL("http://aiweb.cs.washington.edu/research/projects/xmltk/xmldata/data/courses/reed.xml"))
                        .openStream());
        StreamSource stylesource = new StreamSource(stylesheet);
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer(stylesource);
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new File("xslt\\result.html"));
        transformer.transform(source, result);
    } 
}