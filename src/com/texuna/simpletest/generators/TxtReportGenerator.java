package com.texuna.simpletest.generators;

import com.texuna.simpletest.settings.Settings;

/**
 * A report generator for simple txt documents;
 *
 * Created by Ranunculus on 29/05/16.
 */
public class TxtReportGenerator implements ReportGenerator {

    private static final String WORD_DELIMETER = " ";
    private static final String COLUMN_DELIMETER = "|";
    private static final String PAGE_DELIMETER = "~";
    private static final String ROW_DELIMETER = "-";

    private Settings settings;

    public TxtReportGenerator() {}

    public TxtReportGenerator(Settings settings) {
        this.settings = settings;
    }

    @Override
    public void generate() {

    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }
}
