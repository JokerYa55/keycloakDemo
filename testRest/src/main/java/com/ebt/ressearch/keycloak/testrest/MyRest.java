/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebt.ressearch.keycloak.testrest;

import beans.user;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author vasil
 */
@Path("hello")
public class MyRest {

    private Logger log = Logger.getLogger(getClass().getName());

    /**
     * Инкапсулируем информацию по requestHeader
     */
    /*@Context
    private HttpHeaders requestHeaders;
     */
    @Context
    private HttpServletRequest httpRequest;

    @GET
    //@Produces("application/json")
    //@Produces("text/plain")    
    //@Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public user getText(@PathParam("id") String id) {
        List<user> res = new ArrayList<>();
        user u1 = new user(id, "test", "Новый пользователь");
        log.log(Level.INFO, "header = {0}", httpRequest.getServletPath());
        log.log(Level.INFO, "header = {0}", httpRequest.getLocalAddr());
        log.log(Level.INFO, "header = {0}", httpRequest.getMethod());
        

        
        //log.info(size);
        res.add(u1);
        System.out.println("Test");
        return u1;
    }

    @POST
    //@Path("/tpost")
    @Consumes(MediaType.APPLICATION_JSON)
    public String setUser(user person) {
        log.info("setUser");
        log.log(Level.INFO, "header = {0}", httpRequest.getServletPath());
        log.log(Level.INFO, "header = {0}", httpRequest.getLocalAddr());
        log.log(Level.INFO, "header = {0}", httpRequest.getMethod());
        return person.toString();
    }

}
