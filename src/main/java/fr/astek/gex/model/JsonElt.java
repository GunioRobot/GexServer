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
public class JsonElt {
    private String name="Durand";
    private String firstName="Pierre";

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
