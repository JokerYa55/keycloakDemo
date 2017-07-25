/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServices;

import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author vasil
 */
@Path("userREST")
@Produces("application/json")
@Stateless
public class userInfoREST {

    Logger log = Logger.getLogger(getClass().getName());
    //@Inject

    @GET
    @Path("/{id}")
    //@RolesAllowed("video-rest-user")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPerson(@PathParam("id") String id) {
        /*Person person = new Person();
        person.setName("MyDesignStudio");
        person.setId(id);*/
        return id;
    }

    /*@POST
    @Consumes("application/json")
    public String setPerson(Person person) {
        return person.toString();
    }*/

}
