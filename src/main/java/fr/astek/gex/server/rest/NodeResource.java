package fr.astek.gex.server.rest;

import fr.astek.gex.model.Node;
import fr.astek.gex.server.service.AgexService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author sdaclin
 */
@Path("/node")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class NodeResource {
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public void addNode(Node node){
        AgexService.addNode(node);
    }
    
    @GET 
    @Path("/list/{nodeId}")
    public List<Node> getNodeList(@PathParam("nodeId") String nodeId) {
        return AgexService.listNode(nodeId);
    }
    
    @GET 
    @Path("/id/{nodeId}")
    public Node getNode(@PathParam("nodeId") String nodeId) {
        return AgexService.getNode(nodeId);
    }
}