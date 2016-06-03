package com.texuna.simpletest.generators;


import java.util.HashMap;

/**
 * Factory to create different formats of Generators for reports
 * Created by Ranunculus on 29/05/16.
 */
public class ReportGeneratorFactory {

    public static TxtReportGenerator getReportGenerator(String extension){
        if (extension == null) {
            return null;
        } else if (extension.equals("txt")) {
            return new TxtReportGenerator();
        }
        return null;
    }
}
