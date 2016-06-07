package com.texuna.simpletest.settings;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * A class to store input settings
 * Created by malyutina on 31.05.2016.
 */
@XmlRootElement(name = "settings")
public class Settings {

    @XmlElement(name = "page")
    private PageConfig page;

    @XmlElementWrapper(name="columns")
    @XmlElement(name = "column")
    private List<ColumnConfig> columns;

    public PageConfig getPage() {
        return page;
    }

    public List<ColumnConfig> getColumns() {
        return columns;
    }
}
