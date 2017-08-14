/*
 * Created on 2 nov. 03 with Eclipse for Java
 */

import java.io.IOException;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * Cette classe est livree telle quelle.
 * @author smeric
 * @version 1.0
 */
public class SimpleSaxParser {

        /**
         * Contructeur.
         */
        public SimpleSaxParser(String uri) throws SAXException, IOException {
                        XMLReader saxReader = XMLReaderFactory.createXMLReader("org.apache.xerces.parsers.SAXParser");
                        saxReader.setContentHandler(new SimpleContentHandler());
                        saxReader.parse(uri);
        }

        public static void main(String[] args) {
                if (0 == args.length || 2 < args.length) {
                        System.out.println("Usage : SimpleSaxParser uri [parserClassName]");
                        System.exit(1);
                }

                String uri = args[0];

                String parserName = null;
                if (2 == args.length) {
                        parserName = args[1];
                }

                try {
                        SimpleSaxParser parser = new SimpleSaxParser(uri);
                } catch (Throwable t) {
                        t.printStackTrace();
                }
        }
}
