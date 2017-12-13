/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nalyv2saxparser;

import java.io.File;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Nicolle
 */
public class SaxHandler extends DefaultHandler {
        
        @Override
        public void startDocument() throws SAXException {
            System.out.println("start document   : ");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("end document     : ");
        }

        @Override
        public void startElement(String uri, String localName,
            String qName, Attributes attributes)
        throws SAXException {

            System.out.println("start element    : " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName)
        throws SAXException {
            System.out.println("end element      : " + qName);
        }

        @Override
        public void characters(char ch[], int start, int length)
        throws SAXException {
            System.out.println("start characters : " +
                new String(ch, start, length));
        }
}
