package com.texuna.simpletest.generators;


import java.util.HashMap;

/**
 * Created by Ranunculus on 29/05/16.
 */
public class ReportGeneratorFactory {

    public TxtReportGenerator getParser(String extension){
        if (extension == null) {
            return null;
        } else if (extension.equals("txt")) {
            //todo
            return new TxtReportGenerator(3, 4, new HashMap<>());
        }
        return null;
    }
}
