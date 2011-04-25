package fr.astek.gex.model;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author sdaclin
 */
@XmlRootElement
public class Exigence {
    String id;
    String nodeId;
    String parentId;
    Date date;
    TypeExigence type;
    String text;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TypeExigence getType() {
        return type;
    }

    public void setType(TypeExigence type) {
        this.type = type;
    }
}