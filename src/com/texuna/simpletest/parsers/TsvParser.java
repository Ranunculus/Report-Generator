package com.texuna.simpletest.parsers;

import com.univocity.parsers.tsv.TsvParserSettings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by Ranunculus on 29/05/16.
 */
public class TsvParser implements Parser{

    public static final String delimeter = "\t";

    List<String[]> tsvParserResult;
    @Override
    public void parse(String fileName) {
        TsvParserSettings settings = new TsvParserSettings();
        com.univocity.parsers.tsv.TsvParser parser = new com.univocity.parsers.tsv.TsvParser(settings);

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(fileName);
            tsvParserResult = parser.parseAll(new InputStreamReader(fis, "UTF-16"));
        } catch (FileNotFoundException e) {
            System.out.println("Data file not found");
        } catch (UnsupportedEncodingException e) {
            System.out.println("Unsupported Encoding");
        }

    }

    public List<String[]> getTsvParserResult() {
        return tsvParserResult;
    }

    public void setTsvParserResult(List<String[]> tsvParserResult) {
        this.tsvParserResult = tsvParserResult;
    }
}
