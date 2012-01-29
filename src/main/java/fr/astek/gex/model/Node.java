/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.astek.gex.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author sdaclin
 */
@XmlRootElement
public class Node {

    String id;
    String parentId;
    String typeExigenceTree;
    String label;
    Boolean project;

    public Node(){};

    public Node(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Boolean getProject() {
        return project;
    }

    public void setProject(Boolean project) {
        this.project = project;
    }

    public String getTypeExigenceTree() {
        return typeExigenceTree;
    }

    public void setTypeExigenceTree(String typeExigenceTree) {
        this.typeExigenceTree = typeExigenceTree;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
