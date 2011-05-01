package fr.astek.gex.server.service;

import fr.astek.gex.model.Node;
import fr.astek.gex.model.TypeExigence;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author sdaclin
 */
public class AgexService {
    public static final String TYPE_EXIGENCE_SEPARATOR = ">";
  
    private static final Pattern patternNodeId = Pattern.compile("^[a-z]");

    private static final Map<String, Node> nodes = new HashMap<String, Node>();
    private static final Map<String, TypeExigence> typeExigences = new HashMap<String, TypeExigence>();
    static {
        TypeExigence te = new TypeExigence();
        te.setId("ec");
        te.setLabel("Exigence de conception");
        typeExigences.put("ec", te);
        te = new TypeExigence();
        te.setId("es");
        te.setLabel("Exigence de spécification");
        typeExigences.put("es", te);
        te = new TypeExigence();
        te.setId("ti");
        te.setLabel("Test d'intégration");
        typeExigences.put("ti", te);
        
        Node vivop = new Node();
        vivop.setId("vivop");
        vivop.setLabel("Vivop");
        vivop.setParentId(null);
        vivop.setProject(false);
        vivop.setTypeExigenceTree("ec>es>ti");
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
        for (Map.Entry<String, Node> entry : nodes.entrySet()) {
            String key = entry.getKey();
            Node node = entry.getValue();
            if (node.getParentId() != null && node.getParentId().equalsIgnoreCase(nodeId)) {
                list.add(node);
            }
        }
        return list;
    }

    public static Node getNode(String nodeId) {
        for (Map.Entry<String, Node> entry : nodes.entrySet()) {
            String key = entry.getKey();
            Node node = entry.getValue();
            if (node.getId() != null && node.getId().equalsIgnoreCase(nodeId)) {
                return node;
            }
        }
        return null;
    }

    public static void addNode(Node node) {
        if (node.getId() == null || node.getId().trim().equals("")) {
            throw new IllegalArgumentException("L'id du node doit être remplit");
        }
        if (patternNodeId.matcher(node.getId()).find()){
            throw new IllegalArgumentException("L'id ne peut contenir que les caractères [a-z],[0-1],-");
        }
        if (node.getLabel() == null || node.getLabel().trim().length()==0){
            throw new IllegalArgumentException("Le label du node doit être remplit");
        }
        if (nodes.containsKey(node.getId())) {
            throw new RuntimeException("Cet id existe déjà");
        }
        if (node.getTypeExigenceTree() != null && node.getTypeExigenceTree().trim().length()>0){
            if (!checkExigenceTree(node.getTypeExigenceTree())){
                throw new IllegalArgumentException("L'exigenceTree n'est pas valide, vous devez séparer les types d'exigence par le caractère > ex : \"es>ec>ti\"");
            }
        }
        nodes.put(node.getId().toLowerCase(), node);
    }

    public static boolean checkExigenceTree(String typeExigenceTree) {
        String[] typeExigences = typeExigenceTree.split(TYPE_EXIGENCE_SEPARATOR);
        for (String typeExigence : typeExigences){
            if (getTypeExigence(typeExigence) == null){
                return false;
            }
        }
        return true;
    }

    public static TypeExigence getTypeExigence(String typeExigenceId) {
        for (Map.Entry<String, TypeExigence> entry : typeExigences.entrySet()) {
            String key = entry.getKey();
            TypeExigence te = entry.getValue();
            if (te.getId() != null && te.getId().equalsIgnoreCase(typeExigenceId)) {
                return te;
            }
        }
        return null;
    }

    public static List<TypeExigence> getTypesExigenceForNode(String nodeId) {
        List toReturn = new ArrayList<TypeExigence>();
        if (nodeId == null || nodeId.trim().length()==0){
            return toReturn;
        }
        List<Node> path = getPath(nodeId);
        Collections.reverse(path);
        for (Node node : path){
            if (node.getTypeExigenceTree()!=null){
                String[] typeExigences = node.getTypeExigenceTree().split(">");
                for (String te : typeExigences){
                    toReturn.add(getTypeExigence(te));
                }
                break;
            }
        }
        return toReturn;
    }
    
    public static List<Node> getPath(String nodeId){
        List<Node> path = new ArrayList();
        getPathRecurse(path, nodeId);
        Collections.reverse(path);
        return path;
    }
    
    private static void getPathRecurse(List<Node> path, String nodeId) {
        Node node = getNode(nodeId);
        path.add(node);
        if (node.getParentId() != null) {
            getPathRecurse(path, node.getParentId());
        }
        return;
    }
}