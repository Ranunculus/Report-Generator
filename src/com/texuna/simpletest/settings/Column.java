package com.texuna.simpletest.settings;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by malyutina on 31.05.2016.
 */
@XmlRootElement(name = "column")
public class Column {

    @XmlElement(name = "title")
    private String title;
    @XmlElement(name = "width")
    private String width;

    public String getTitle() {
        return title;
    }

    public String getWidth() {
        return width;
    }
}
