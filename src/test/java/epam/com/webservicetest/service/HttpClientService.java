package epam.com.webservicetest.service;

import epam.com.webservicetest.model.user.User;
import epam.com.webservicetest.util.JsonHelper;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClientService {
    private static final String PATH = "https://jsonplaceholder.typicode.com/users";
    private CloseableHttpClient httpclient;

    public HttpClientService(){
        httpclient = HttpClients.createDefault();
    }

    public int getResponseStatusCode() {
        return getResponse(PATH).getStatusLine().getStatusCode();
    }

    public boolean isHeaderExist(String headerName) {
        return getHeaders(headerName).length > 0;
    }

    public User[] getUsers() {
        String body;
        try {
            body = EntityUtils.toString(getResponse(PATH).getEntity(), "UTF-8");
            return JsonHelper.fromJson(body, User[].class);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public String getHeaderValue(String headerName) {
        return getHeaders(headerName)[0].getValue();
    }

    private Header[] getHeaders(String haderName) {
        return getResponse(PATH).getHeaders(haderName);
    }

    private CloseableHttpResponse getResponse(String path){
        HttpGet httpGet = new HttpGet(path);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpGet);
        } catch (IOException e) {
            throw new RuntimeException("Fail to execute Get Request");
        }
        return response;
    }
}
