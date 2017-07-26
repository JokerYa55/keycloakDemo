/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.rtk;

import beans.user;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author vasil
 */
@Path("adm")
public class adminREST {

    @Context
    private HttpServletRequest httpRequest;
    private Logger log = Logger.getLogger(getClass().getName());
    
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
}
