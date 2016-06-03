package com.texuna.simpletest.generators;

import com.sun.org.apache.xpath.internal.SourceTree;
import com.texuna.simpletest.settings.Column;
import com.texuna.simpletest.settings.Settings;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

        inputData.forEach(this::composeTableRow);
//        composePages();
    }

    private void composeTableRow(String[] data) {
        //todo: calculate height of the row
        if(data.length != settings.getColumns().size()){
            System.out.println("The size of input data != size in settings!");
            return;
        }
        /**
         * calculating row height
         *
         * if data size is bigger than row width: find how much rows we need to fit all the data
         */
        int i = 0;
        int height = 1;
        for (Column column : settings.getColumns()) {
            if(data[i].length() / column.getWidth() > 1){
               if(height < data[i].length() / column.getWidth()) {
                   height = data[i].length() / column.getWidth();
               }
               if(data[i].length() % column.getWidth() > 0){
                   height++;
               }
            }
            i++;
        }
//        System.out.println("Current line height = " + height);
        currentLine = new char[height][settings.getPage().getWidth()];
        int outerCarriagePosition = 0;
        for (int column = 0; column < data.length; column++) {
            //todo: refactor .get(0)
            int settingsColumnWidth = settings.getColumns().get(column).getWidth();
            int currentColumnCarriagePosition = 0;
            for (int innerRow = 0; innerRow < height; innerRow++){
                currentLine[innerRow][0+outerCarriagePosition] = COLUMN_DELIMITER;
                currentLine[innerRow][1+outerCarriagePosition] = WORD_DELIMITER;
                int carriagePosition = 2;
                for(; carriagePosition < settingsColumnWidth+2; carriagePosition++ ){
                    if(currentColumnCarriagePosition >= data[column].length()) {
                        currentLine[innerRow][carriagePosition + outerCarriagePosition] = WORD_DELIMITER;
                    } else {
                        currentLine[innerRow][carriagePosition + outerCarriagePosition] = data[column].charAt(currentColumnCarriagePosition);
                        currentColumnCarriagePosition++;
                    }
                }
                currentLine[innerRow][settingsColumnWidth + outerCarriagePosition + 2] = WORD_DELIMITER;
                currentLine[innerRow][settingsColumnWidth + outerCarriagePosition + 3] = COLUMN_DELIMITER;
            }
            outerCarriagePosition += settingsColumnWidth + 2 + 1;
        }
        System.out.println("Result for current string");
        for(int x = 0; x < height; x++ ) {
            System.out.println(currentLine[x]);
        }


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
