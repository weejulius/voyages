package com.wee.voyages.domain.model.customer;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.wee.voyages.application.validatation.Strings;

/**
 * User: weejulius
 * Date: 2009-7-24
 * Time: 8:33:11
 */   
public class AreaCodes {
    private final static Map<String, String> codesAndNames = new HashMap<String, String>();
    private final static AreaCodes AREA_CODES = new AreaCodes();
    private final static Logger log = LoggerFactory.getLogger(AreaCodes.class);
    private final static String XML_PATH = "idcard.xml";

    private AreaCodes() {
        readDataFromXML();
    }

    public static AreaCodes instance() {
        if (codesAndNames.isEmpty()){
            readDataFromXML();           
        }
        return AREA_CODES;
    }

    private static void readDataFromXML() {
        XMLReader reader = new XMLReader() {
            @Override
            void doWork(Element el) {
                codesAndNames.put(el.element("code").getText(), el.element("name").getText());
            }
        };
        try {
            read(reader, XML_PATH);
        } catch (FileNotFoundException e) {
            log.error(e.getMessage());
        }
    }

    private static void read(XMLReader reader, String filepath) throws FileNotFoundException {
        try {
            InputStream in = AreaCodes.class.getResourceAsStream(filepath);
            if (in != null) { //file exist.
                reader.read(in);
                return;
            }
            throw new FileNotFoundException(new File(filepath).getAbsolutePath() + " does not exist");
        } catch (DocumentException e) {
            codesAndNames.clear();
            log.warn("reading xml file encounted DocumentException, and clear exist data.");
        }
    }

    public Map<String, String> codesAndNames() {
        return codesAndNames;
    }

    public boolean hasCode(String code) {
        return codesAndNames().containsKey(code);
    }

    public static abstract class XMLReader {

        public Document parse(InputStream in) throws DocumentException {
            SAXReader reader = new SAXReader();
            Document document = reader.read(in);
            return document;
        }

        public void read(InputStream in) throws DocumentException {
            Document document = parse(in);
            Element root = document.getRootElement();
            for (Iterator i = root.elementIterator(); i.hasNext();) {
                Element element = (Element) i.next();
                doWork(element);
            }
        }

        abstract void doWork(Element el);
    }

    public static class AreaCode {
        private String code;
        private String name;

        public AreaCode(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String code() {
            return code;
        }

        public String name() {
            return name;
        }
    }

}
