package fr.astek.gex.server.service;

import fr.astek.gex.model.Node;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sdaclin
 */
public class AgexService {

    public static List<Node> listNode(String nodeId) {
        List<Node> list = new ArrayList<Node>();
        list.add(new Node("Modification de l'en-tête du formulaire."));
        list.add(new Node("Suppression du champ libellé."));
        return list;
    }

    public static Node getNode(String nodeId) {
        return new Node("Modification du libelle");
    }
    
}
