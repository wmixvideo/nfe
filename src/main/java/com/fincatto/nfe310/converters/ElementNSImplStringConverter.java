package com.fincatto.nfe310.converters;

import com.sun.org.apache.xerces.internal.dom.ElementNSImpl;
import java.io.StringWriter;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;

public class ElementNSImplStringConverter {

    public static String read(final ElementNSImpl elementNSImpl) {
        try {
            Document document = elementNSImpl.getOwnerDocument();
            StringWriter sw = new StringWriter();
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.transform(new DOMSource(document), new StreamResult(sw));
            return sw.toString();
        } catch (TransformerException ex) {
            throw new RuntimeException("Erro ao converter objeto Document para String", ex);
        }
    }
}
