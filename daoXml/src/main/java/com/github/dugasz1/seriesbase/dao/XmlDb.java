package com.github.dugasz1.seriesbase.dao;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class XmlDb {
    private File dbFile;
    private File schemaFile;
    private Schema schema;
    private Document document;

    public XmlDb (String dbPath){
        dbFile = new File(dbPath);
        try {
            dbFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        //schemaFactory.newSchema(new File(getClass().getClassLoader().getResource("db_schema").getFile()));
        try {
            schema = schemaFactory.newSchema(new File("C:\\Users\\Dudu\\IdeaProjects\\SeriesBase\\daoXml\\src\\main\\resources\\db_schema.xsd"));
            Validator validator = schema.newValidator();
            validator.setErrorHandler(new XsdErrorHandler());
        } catch (SAXException e) {
            e.printStackTrace();
        }
        builderFactory.setSchema(schema);
        builderFactory.setIgnoringElementContentWhitespace(true);
        builderFactory.setIgnoringComments(true);


        DocumentBuilder builder = null;
        try {
            builder = builderFactory.newDocumentBuilder();
            document = builder.parse(dbFile);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void Save() throws IOException, TransformerException {
        DOMSource source = new DOMSource(document);
        FileWriter writer = new FileWriter(dbFile);
        StreamResult result = new StreamResult(writer);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(source, result);
    }

    public Document getDocument() {
        return document;
    }
}
