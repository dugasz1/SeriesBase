package com.github.dugasz1.seriesbase.dao;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class XsdErrorHandler implements ErrorHandler {
    public void warning(SAXParseException exception) throws SAXException {
        System.out.println("BAJ VAN");
    }

    public void error(SAXParseException exception) throws SAXException {
        System.out.println("BAJ VAN");
    }

    public void fatalError(SAXParseException exception) throws SAXException {
        System.out.println("BAJ VAN");
    }
}
