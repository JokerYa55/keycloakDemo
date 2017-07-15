package com.ebt.videoapp.servlet;

import com.ebt.videoapp.service.VideoService;

import javax.annotation.security.DeclareRoles;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.jboss.logging.Logger;

/**
 * Сервлет показывает список видео, используя в качестве данных внутренний
 * сервис.
 *
 * @author EastBanc Technologies (http://eastbanctech.ru/)
 */
@WebServlet("/video-list-servlet")
@DeclareRoles("video-app-user")
@ServletSecurity(
        @HttpConstraint(rolesAllowed = {"video-app-user"}))
public class VideoListServlet extends HttpServlet {

    Logger log = Logger.getLogger(VideoListServlet.class);

    //@Inject
    private final VideoService videoService  = new VideoService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*Client client = ClientBuilder.newBuilder().build();
        WebTarget target = client.target("http://192.168.1.150:8080/video-rest/list");
        GenericType<List<VideoImpl>> listGenericType = new GenericType<List<VideoImpl>>() {
        };
        KeycloakSecurityContext ksc = (KeycloakSecurityContext) req.getAttribute(KeycloakSecurityContext.class.getName());
        List<VideoImpl> list = target.request().header("Authorization", "Bearer " + ksc.getTokenString()).get(listGenericType);

        // merge lists
        List<Video> mergeList = new ArrayList<>();
        mergeList.addAll(list);
        mergeList.addAll(videoService.list());

        req.setAttribute("list", mergeList);
        req.setAttribute("ksc", ksc);
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(req, resp);*/
        log.info("videoService = " + videoService);
        req.setAttribute("list", videoService.list());
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(req, resp);
    }
}
