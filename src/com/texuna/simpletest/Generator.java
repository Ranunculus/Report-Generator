package com.texuna.simpletest;

import com.texuna.simpletest.generators.ReportGeneratorFactory;
import com.texuna.simpletest.generators.TxtReportGenerator;
import com.texuna.simpletest.parsers.ParserFactory;
import com.texuna.simpletest.parsers.XmlParser;
import com.texuna.simpletest.parsers.TsvParser;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import java.io.*;

/**
 * This generator can be used to create different types of reports in the future.
 *
 * Just add Parsers (to parse input data) for different formats;
 * Add Report Generators for different formats;
 */
public class Generator {

    public static void main(String[] args) throws JAXBException, XMLStreamException, FileNotFoundException, UnsupportedEncodingException {
        /**
         * Creating xml parser to parse settings
         */
        XmlParser xmlParser = (XmlParser) ParserFactory.getParser("xml");
        xmlParser.parse(args[0]);

        /**
         * Creating tsv parser to parse input data
         */
        TsvParser tsvParser = (TsvParser) ParserFactory.getParser("tsv");
        tsvParser.parse(args[1]);

        /**
         * Creating txtReportGenerator to create a report
         */
        TxtReportGenerator txtReportGenerator = ReportGeneratorFactory.getReportGenerator("txt");
        txtReportGenerator.setSettings(xmlParser.getParsedSettings());
        txtReportGenerator.generate();
    }
}
