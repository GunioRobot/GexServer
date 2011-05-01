package fr.astek.gex.server.rest;

import fr.astek.gex.model.TypeExigence;
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
@Path("/typeExigence")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class TypeExigenceResource {

    @GET
    @Path("/id/{typeExigenceId}")
    public TypeExigence getTypeExigence(@PathParam("typeExigenceId") String teId) {
        return AgexService.getTypeExigence(teId);
    }

    @GET
    @Path("/nodeId/{nodeId}")
    public List<TypeExigence> getTypeExigenceForNode(@PathParam("nodeId") String nodeId) {
        return AgexService.getTypesExigenceForNode(nodeId);
    }
}
