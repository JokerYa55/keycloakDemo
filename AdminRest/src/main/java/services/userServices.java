/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.sun.istack.internal.logging.Logger;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.simple.JSONObject;
import static util.HTTPUtil.doPost;

/**
 *
 * @author vasil
 */
public class userServices {

    private static final Logger log = Logger.getLogger(userServices.class);

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
    public static JSONObject getToken(String userName, String password, String host, String realm, String client_id) {
        JSONObject res = null;
        String url = "http://" + host + "/auth/realms/" + realm + "/protocol/openid-connect/token";
        try {
            List nameValuePairs = new ArrayList(1);
            nameValuePairs.add(new BasicNameValuePair("client_id", client_id)); //you can as many name value pair as you want in the list.
            nameValuePairs.add(new BasicNameValuePair("username", userName));
            nameValuePairs.add(new BasicNameValuePair("password", password));
            nameValuePairs.add(new BasicNameValuePair("grant_type", "password"));
            res = doPost(url, nameValuePairs, null);
            log.info(res.toJSONString());
        } catch (Exception e) {
            log.warning(e.getMessage());
        }
        return res;
    }
}
