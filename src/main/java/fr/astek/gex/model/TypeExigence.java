package fr.astek.gex.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author sdaclin
 */
@XmlRootElement
public class TypeExigence {
    private String id;
    private String label;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
