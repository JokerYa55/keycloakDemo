/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServices;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import services.userServices;
import static services.userServices.getToken;
import static services.userServices.getUserFullInfo;
import static services.userServices.getUserShortInfo;

/**
 *
 * @author vasil
 */
@WebServlet(name = "userInfo", urlPatterns = {"/userInfo"})
public class userInfo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet userInfo</title>");            
//            out.println("</head>");
//            out.println("<body>");
            
            JSONObject token = getToken("appuser", "123", "192.168.1.150:8080", "videomanager", "video-app", "50c93bab-fe8f-422a-948e-a63c52458ee3");
            JSONObject userShotInfo = getUserShortInfo("192.168.1.150:8080", "videomanager", "appuser", (String) token.get("access_token"));
            String userID = (String) userShotInfo.get("sub");
            // Авторизуемся под админом
            JSONObject tokenAdm = getToken("vasil", "123", "192.168.1.150:8080", "master", "admin-cli", null);
            JSONObject userFullInfo = getUserFullInfo("192.168.1.150:8080", "videomanager", userID, (String) tokenAdm.get("access_token"));
            out.println(userFullInfo.toString());
            
//            //out.println("<h1>Servlet userInfo at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
