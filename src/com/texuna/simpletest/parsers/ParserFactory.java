package com.texuna.simpletest.parsers;

/**
 * Factory to create different types of Parsers
 * Created by Ranunculus on 29/05/16.
 */
public class ParserFactory {

    public Parser getParser(String extension){
        if (extension == null) {
            return null;
        } else if (extension.equals("txt")) {
            return new TxtParser();
        } else if (extension.equals("xml")) {
            return new XmlParser();
        }
        return null;
    }
}
