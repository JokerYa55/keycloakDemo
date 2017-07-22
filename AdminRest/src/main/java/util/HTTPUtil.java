/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.json.simple.parser.ParseException;

/**
 *
 * @author vasil
 */
public class HTTPUtil {

    private static final Logger log = Logger.getLogger("HTTPUtil");

    public static JSONObject doPost(String url, Object params, Map<String, String> headerList) throws ParseException {
        log.info("doPost_1");
        JSONObject res = new JSONObject();
        try {
            HttpClient httpClient = HttpClientBuilder.create().build();
            Gson gson = new Gson();
            JSONParser parser = new JSONParser();
            HttpPost post = new HttpPost(url);
            StringEntity postingString = new StringEntity(gson.toJson(params));
            //log.info("json = " + gson.toJson(params));
            post.setEntity(postingString);
            if (headerList != null) {
                headerList.entrySet().stream().forEach((t) -> {
                    Header header = new BasicHeader(t.getKey(), t.getValue());
                    post.setHeader(header);
                });
            }
            HttpResponse response = httpClient.execute(post);

            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line;
            StringBuilder json = new StringBuilder();
            while ((line = rd.readLine()) != null) {
                //log.info(line);
                json.append(line);
            }

            Object obj = parser.parse(json.toString());
            JSONObject jsonObj = (JSONObject) obj;
            res = jsonObj;
            //log.info("access_token : " + res.get("access_token"));

        } catch (IOException | IllegalStateException | ParseException e) {
            log.warning(e.getMessage());
        }
        return res;
    }

    /**
     * Отправка POST запроса
     */
    public static JSONObject doPost(String url, List params, Map<String, String> headerList) {
        log.info("doPost_2");
        JSONObject res = new JSONObject();
        try {
            HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost(url);
            if (headerList != null) {
                headerList.entrySet().stream().forEach((t) -> {
                    Header header = new BasicHeader(t.getKey(), t.getValue());
                    post.setHeader(header);
                });
            }

            if (params != null) {
                post.setEntity(new UrlEncodedFormEntity(params));
            }

            HttpResponse response = client.execute(post);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line;
            StringBuilder json = new StringBuilder();
            while ((line = rd.readLine()) != null) {
                //log.info(line);
                json.append(line);
            }

            JSONParser parser = new JSONParser();
            Object obj = parser.parse(json.toString());
            JSONObject jsonObj = (JSONObject) obj;
            res = jsonObj;
            //log.info("access_token : " + res.get("access_token"));

        } catch (IOException | IllegalStateException | ParseException e) {
            log.warning(e.getMessage());
        }
        return res;
    }

    public static JSONObject doGet(String url, Map<String, String> headerList) throws ParseException {
        log.info("doGet");
        JSONObject res = new JSONObject();
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url);
        HttpResponse response;

        if (headerList != null) {
            headerList.entrySet().stream().forEach((t) -> {
                Header header = new BasicHeader(t.getKey(), t.getValue());
                request.setHeader(header);
            });
        }

        try {
            response = client.execute(request);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line;
            StringBuilder json = new StringBuilder();
            while ((line = rd.readLine()) != null) {
                //log.info(line);
                json.append(line);
            }
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(json.toString());
            JSONObject jsonObj = (JSONObject) obj;
            res = jsonObj;
        } catch (IOException ex) {
            log.warning(ex.getMessage());
        }
        return res;
    }

    /**
     *
     * @param userName
     * @param password
     * @param host
     * @param realm
     * @param client_id
     * @return
     */
    /*public JSONObject getAccessToken(String userName, String password, String host, String realm, String client_id) {
        System.out.println("getAccessToken");

        return userServices.getToken(userName, password, host, realm, client_id);
    }*/
}
