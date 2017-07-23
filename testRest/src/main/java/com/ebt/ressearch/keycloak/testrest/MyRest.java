/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebt.ressearch.keycloak.testrest;

import beans.user;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author vasil
 */
@Path("hello")
public class MyRest {

    @GET
    @Produces("application/json")
    //@Produces("text/plain")
    public List<user> getText() {
        List<user> res = new ArrayList<>();
        user u1 = new user(1, "test", "Новый пользователь");
        res.add(u1);
        System.out.println("Test");
        return res ;
        //return "TEST";
    }
}
