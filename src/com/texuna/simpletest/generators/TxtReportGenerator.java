package com.texuna.simpletest.generators;

import java.util.HashMap;

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

    private int height;
    private int width;
    private HashMap<String, Integer> columns;

    public TxtReportGenerator() {}

    public TxtReportGenerator(int height, int width, HashMap<String, Integer> columns) {
        this.height = height;
        this.width = width;
        this.columns = columns;
    }

    @Override
    public void generate() {

    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public HashMap<String, Integer> getColumns() {
        return columns;
    }

    public void setColumns(HashMap<String, Integer> columns) {
        this.columns = columns;
    }
}
