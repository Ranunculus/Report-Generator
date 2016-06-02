package com.texuna.simpletest.generators;

import com.texuna.simpletest.settings.Column;
import com.texuna.simpletest.settings.Settings;

import java.util.ArrayList;
import java.util.List;

/**
 * A report generator for simple txt documents;
 *
 * Created by Ranunculus on 29/05/16.
 */
public class TxtReportGenerator implements ReportGenerator {

    private static final char WORD_DELIMITER = ' ';
    private static final char COLUMN_DELIMITER = '|';
    private static final char PAGE_DELIMITER = '~';
    private static final char ROW_DELIMITER = '-';
    private static final String NEW_LINE = "\n";

    private Settings settings;
    private List<String[]> inputData;

    private char[] head;
    private ArrayList<char[][]> lines;
    private char[][] currentLine;
    private char[][] result;

    public TxtReportGenerator() {}

    public TxtReportGenerator(Settings settings) {
        this.settings = settings;
    }

    @Override
    public void generate() {
        if(settings == null) {
            System.out.println("No settings");
            return;
        }
        if(inputData == null){
            System.out.println("No input data");
            return;
        }
        composeTableHead();
    }

    //todo: generalize for data
    private void composeTableHead() {
        head = new char[settings.getPage().getWidth()];
        head[0] = COLUMN_DELIMITER;
        int i = 1;
        for (Column column : settings.getColumns()) {
            head[i] = WORD_DELIMITER;
            i++;
            for (char titleChar : column.getTitle().toCharArray()) {
                head[i] = titleChar;
                i++;
            }
            if (column.getTitle().length() < column.getWidth()) {
                for (int j = 0; j < column.getWidth() - column.getTitle().length(); j++) {
                    head[i] = WORD_DELIMITER;
                    i++;
                }
            }
            head[i] = WORD_DELIMITER;
            i++;
            head[i] = COLUMN_DELIMITER;
            i++;
        }
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public List<String[]> getInputData() {
        return inputData;
    }

    public void setInputData(List<String[]> inputData) {
        this.inputData = inputData;
    }
}
