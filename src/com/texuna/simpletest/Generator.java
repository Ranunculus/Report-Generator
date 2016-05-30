package com.texuna.simpletest;

import com.texuna.simpletest.generators.ReportGeneratorFactory;
import com.texuna.simpletest.generators.TxtReportGenerator;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;

/**
 * This generator can be used to create different types of reports in the future.
 *
 * Just add Parsers (to parse input data) for different formats;
 * Add Report Generators for different formats;
 */
public class Generator {

    public static void main(String[] args) {



        //open and read files
        //parse input files, get data
        try {
            File file = new File(args[0]);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();

        } catch (SAXException | ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Settings file hasn't been found");
        }

        TxtReportGenerator txtReportGenerator = ReportGeneratorFactory.getReportGenerator("txt");
//        txtReportGenerator.setHeight();
//        txtReportGenerator.setWidth();
//        txtReportGenerator.setColumns();
        txtReportGenerator.generate();
        //create new report
        //save and close output file
    }
}
