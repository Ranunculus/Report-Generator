package com.texuna.simpletest.generators;

import com.texuna.simpletest.settings.ColumnConfig;
import com.texuna.simpletest.settings.Settings;

import java.util.ArrayList;
import java.util.List;

/**
 * Generator to create paged list
 * Created by malyutina on 06.06.2016.
 */
public class PageGenerator {

    private static final String PAGE_DELIMITER = "~";
    private Settings settings;
    private RowGenerator rowGenerator = new RowGenerator();

    public PageGenerator(Settings settings) {
        this.settings = settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public Settings getSettings() {
        return settings;
    }

    public List<String> generate(List<String[]> inputData) {
        List<String> result = new ArrayList<>();

        rowGenerator.setSettings(settings);
        rowGenerator.generateHead(settings.getColumns());

        rowGenerator.generateRowDelimiter();
        result.add(rowGenerator.getHeadRow());
        result.add(rowGenerator.getDelimiterRow());
        for (String[] dataRow : inputData) {
            /**
             * Count row's height
             */
            int i = 0;
            int height = 1;
            for (ColumnConfig column : settings.getColumns()) {
                if(dataRow[i].length() / column.getWidth() >= 1){
                    if(height < dataRow[i].length() / column.getWidth()) {
                        height = dataRow[i].length() / column.getWidth();
                    }
                    if(dataRow[i].length() % column.getWidth() > 0){
                        height++;
                    }
                }
                i++;
            }

            for (int j = 0; j < height; j++) {
                String[] inner = new String[dataRow.length];
                for (int k = 0; k < dataRow.length; k++) {
                    if(dataRow[k].length() < settings.getColumns().get(k).getWidth()) {
                        if(j == 0) {
                            inner[k] = dataRow[k];
                        } else {
                            inner[k] = "";
                        }
                    } else {
                        int rowMultiplier = settings.getColumns().get(k).getWidth()*j;
                        if (rowMultiplier >= dataRow[k].length()) {
                            inner[k] = "";
                        } else if (rowMultiplier + settings.getColumns().get(k).getWidth()-1 >= dataRow[k].length()){
                            inner[k] = dataRow[k].substring(rowMultiplier);
                        } else {
                            inner[k] = dataRow[k].substring(rowMultiplier, rowMultiplier + settings.getColumns().get(k).getWidth());
                        }
                    }
                }
                result.add(rowGenerator.generate(inner));
                if (result.size() % settings.getPage().getHeight() == 0) {
                    result.add(PAGE_DELIMITER);
                    result.add(rowGenerator.getHeadRow());
                    result.add(rowGenerator.getDelimiterRow());
                } else if(j == height-1) {
                    result.add(rowGenerator.getDelimiterRow());
                }
            }
        }
        result.forEach(System.out::println);
        return result;
    }
}
