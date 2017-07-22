/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import org.apache.http.message.BasicNameValuePair;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import static util.HTTPUtil.doGet;
import static util.HTTPUtil.doPost;

/**
 *
 * @author vasil
 */
public class userServices {

    private static final Logger log = Logger.getLogger("userServices");

    /**
     * Функция получает токен для доступа к защищенным методам.
     *
     * @param userName
     * @param password
     * @param host
     * @param realm
     * @param client_id
     * @return
     */
    public static JSONObject getToken(String userName, String password, String host, String realm, String client_id, String clientSicret) {
        JSONObject res = null;
        String url = "http://" + host + "/auth/realms/" + realm + "/protocol/openid-connect/token";
        try {
            List nameValuePairs = new ArrayList(1);
            nameValuePairs.add(new BasicNameValuePair("client_id", client_id)); //you can as many name value pair as you want in the list.
            nameValuePairs.add(new BasicNameValuePair("username", userName));
            nameValuePairs.add(new BasicNameValuePair("password", password));
            nameValuePairs.add(new BasicNameValuePair("grant_type", "password"));
            if (clientSicret!=null) nameValuePairs.add(new BasicNameValuePair("client_secret", clientSicret));
            res = doPost(url, nameValuePairs, null);
            //log.info(res.toJSONString());
        } catch (Exception e) {
            log.warning(e.getMessage());
        }
        return res;
    }

    /**
     *
     * @param host
     * @param realm
     * @param username
     * @param accessToken
     * @return
     */
    public static JSONObject getUserShortInfo(String host, String realm, String username, String accessToken) {
        log.info("getUserShortInfo");
        //log.info("access_token = " + accessToken);
        JSONObject res = null;
        try {
            String url;
            url = "http://" + host + "/auth/realms/" + realm + "/protocol/openid-connect/userinfo?username="+username;
            log.info(url);
            Map<String, String> mapHeader = new HashMap<>();
            mapHeader.put("Content-Type", "application/json");
            mapHeader.put("Authorization", "Bearer " + accessToken);
            res = doGet(url, mapHeader);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return res;
    }

    /**
     * Функция получает полные данные о пользователе
     *
     * @param host
     * @param realm
     * @param id
     * @param accessToken
     * @return
     */
    public static JSONObject getUserFullInfo(String host, String realm, String id, String accessToken) {
        // GET /admin/realms/{realm}/users/{id}
        log.info("getUserFullInfo");
        JSONObject res = null;
        try {
            String url;
            url = "http://" + host + "/auth/admin/realms/" + realm + "/users/" + id;
            log.info(url);
            Map<String, String> mapHeader = new HashMap<>();
            mapHeader.put("Content-Type", "application/json");
            mapHeader.put("Authorization", "Bearer " + accessToken);
            res = doGet(url, mapHeader);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return res;
    }

}
