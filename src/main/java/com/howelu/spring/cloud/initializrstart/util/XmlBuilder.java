package com.howelu.spring.cloud.initializrstart.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;

/**
 * Xml Builder, use Unmarshaller to transform xml to object
 */
public class XmlBuilder {
    public static Object xmlStrToObject(Class<?> clazz, String xmlStr) throws Exception {
        Object xmlObject;
        Reader reader;
        JAXBContext context = JAXBContext.newInstance(clazz);

        // xml -> object
        Unmarshaller unmarshaller = context.createUnmarshaller();

        reader = new StringReader(xmlStr);
        xmlObject = unmarshaller.unmarshal(reader);

        if (reader != null) {
            reader.close();
        }
        return xmlObject;
    }
}
