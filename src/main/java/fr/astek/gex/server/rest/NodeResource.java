package fr.astek.gex.server.rest;

import fr.astek.gex.model.Node;
import fr.astek.gex.server.service.AgexService;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author sdaclin
 */
@Path("/node")
public class NodeResource {
    
    @GET 
    @Path("/list/{nodeId}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Node> getNodeContent(@PathParam("nodeId") String nodeId) {
        return AgexService.listNode(nodeId);
    }
    
    @GET 
    @Path("/id/{nodeId}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Node getNode(@PathParam("nodeId") String nodeId) {
        return AgexService.getNode(nodeId);
    }
}
