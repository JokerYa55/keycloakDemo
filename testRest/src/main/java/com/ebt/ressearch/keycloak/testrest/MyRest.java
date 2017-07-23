/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebt.ressearch.keycloak.testrest;

import beans.user;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author vasil
 */
@Path("hello")
public class MyRest {
    private Logger log = Logger.getLogger(getClass().getName());

    @GET
    @Produces("application/json")
    //@Produces("text/plain")    
    //@Path("/{id}")
    //@Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")

    public user getText(@PathParam("id") String id) {
        List<user> res = new ArrayList<>();
        user u1 = new user(new Integer(id), "test", "Новый пользователь");
        res.add(u1);
        System.out.println("Test");
        return u1;
        //return "TEST";
    }

    @POST
    @Path("/tpost")
    @Consumes("application/json")
    public String setUser(user person) {
        log.info("setUser");
        return person.toString();
    }

}
