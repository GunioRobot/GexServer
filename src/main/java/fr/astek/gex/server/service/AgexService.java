package fr.astek.gex.server.service;

import fr.astek.gex.model.Node;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sdaclin
 */
public class AgexService {
    private static Map<String,Node> nodes = new HashMap<String, Node>();
    static {
        Node vivop = new Node();
        vivop.setId("vivop");
        vivop.setLabel("Vivop");
        vivop.setParentId(null);
        vivop.setProject(false);
        nodes.put("vivop", vivop);
        Node vio = new Node();
        vio.setId("vio");
        vio.setLabel("Vio");
        vio.setParentId("vivop");
        vio.setProject(true);
        nodes.put("vio", vio);
        Node siclop = new Node();
        siclop.setId("siclop");
        siclop.setLabel("Siclop");
        siclop.setParentId("vivop");
        siclop.setProject(true);
        nodes.put("siclop", siclop);
    }
    
    /**
     * Retourne tous les fils d'un node
     * @param nodeId
     * @return 
     */
    public static List<Node> listNode(String nodeId) {
        List<Node> list = new ArrayList<Node>();
        for(Map.Entry<String,Node> entry : nodes.entrySet()){
            String key = entry.getKey();
            Node node = entry.getValue();
            if (node.getParentId()!=null && node.getParentId().equalsIgnoreCase(nodeId)){
                list.add(node);
            }
        }
        return list;
    }

    public static Node getNode(String nodeId) {
        for(Map.Entry<String,Node> entry : nodes.entrySet()){
            String key = entry.getKey();
            Node node = entry.getValue();
            if (node.getId()!=null && node.getId().equalsIgnoreCase(nodeId)){
                return node;
            }
        }
        return null;
    }

    public static void addNode(Node node) {
        if(node.getId() == null || node.getId().trim().equals("")){
            throw new IllegalArgumentException("la valeur id du node doit être remplie");
        }
        if (nodes.containsKey(node.getId())){
            throw new RuntimeException("Ce nodeId existe déjà");
        }
        nodes.put(node.getId().toLowerCase(), node);
    }
    
}
