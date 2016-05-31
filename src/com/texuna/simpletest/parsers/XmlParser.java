package com.texuna.simpletest.parsers;

import com.texuna.simpletest.settings.Settings;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Ranunculus on 29/05/16.
 */
public class XmlParser implements Parser {

    private Settings parsedSettings;

    @Override
    public void parse(String fileName) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Settings.class);
            XMLStreamReader xss = XMLInputFactory.newFactory().createXMLStreamReader(new FileInputStream(fileName));
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            xss.nextTag();
            parsedSettings = (Settings) unmarshaller.unmarshal(xss);
        } catch (XMLStreamException | JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Settings file hasn't been found");
        }
    }

    public Settings getParsedSettings() {
        return parsedSettings;
    }

    public void setParsedSettings(Settings parsedSettings) {
        this.parsedSettings = parsedSettings;
    }
}
