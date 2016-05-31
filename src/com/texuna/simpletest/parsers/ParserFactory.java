package com.texuna.simpletest.parsers;

/**
 * Factory to create different types of Parsers
 * Created by Ranunculus on 29/05/16.
 */
public class ParserFactory {

    public static Parser getParser(String extension){
        if (extension == null) {
            return null;
        } else if (extension.equals("tsv")) {
            return new TsvParser();
        } else if (extension.equals("xml")) {
            return new XmlParser();
        }
        return null;
    }
}
