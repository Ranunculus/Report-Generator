package com.texuna.simpletest.generators;


/**
 * Factory to create different formats of Generators for reports
 * Created by Ranunculus on 29/05/16.
 */
public class ReportGeneratorFactory {

    public static ReportGenerator getReportGenerator(String extension){
        if (extension == null) {
            return null;
        } else if (extension.equals("txt")) {
            return new TxtReportGenerator();
        } else if (extension.equals("old")) {
            return new TxtReportGeneratorOld();
        }
        return null;
    }
}
