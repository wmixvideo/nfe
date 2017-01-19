package com.fincatto.nfe310.parsers;

import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class StringElementParser {

    public static Element read(final String xml) {
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource inputSource = new InputSource();
            inputSource.setCharacterStream(new StringReader(xml));
            return documentBuilder.parse(inputSource).getDocumentElement();
        } catch (SAXException | IOException | ParserConfigurationException ex) {
            Logger.getLogger(StringElementParser.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao converter objeto String para Element", ex);
        }
    }

}
