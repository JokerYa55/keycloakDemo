package com.ebt.videorest.rest;

import com.ebt.common.Video;
import com.ebt.videorest.service.VideoService;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;
import java.util.logging.Logger;

/**
 * REST сервис.
 *
 * @author EastBanc Technologies (http://eastbanctech.ru/)
 */


@Path("/")
@Produces("application/json")
@Stateless
public class VideoRest {

    Logger log = Logger.getLogger(getClass().getName());
    //@Inject

    @GET
    @Path("/list")
    @RolesAllowed("video-rest-user")

    public List<Video> get() {
        log.info("get");
        VideoService videoService = new VideoService();
        return videoService.list();
    }
}
