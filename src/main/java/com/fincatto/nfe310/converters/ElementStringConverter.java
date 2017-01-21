package com.fincatto.nfe310.converters;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class ElementStringConverter {

    public static String write(final Element element) {
        try {
            Document document = element.getOwnerDocument();
            StringWriter sw = new StringWriter();
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.transform(new DOMSource(document), new StreamResult(sw));
            return sw.toString();
        } catch (TransformerException ex) {
            Logger.getLogger(ElementStringConverter.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao converter objeto Document para String", ex);
        }
    }
    
    public static Element read(final String xml) {
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource inputSource = new InputSource();
            inputSource.setCharacterStream(new StringReader(xml));
            return documentBuilder.parse(inputSource).getDocumentElement();
        } catch (SAXException | IOException | ParserConfigurationException ex) {
            Logger.getLogger(ElementStringConverter.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao converter objeto String para Element", ex);
        }
    }
}
