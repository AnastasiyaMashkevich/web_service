package epam.com.webservicetest.service;

import epam.com.webservicetest.model.user.User;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import java.util.List;

public class RestAssuredService {

    public RestAssuredService() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    public int getResponseStatusCode() {
        return getUsersResponse().statusCode();
    }

    public boolean isHeaderExist(String headerName) {
       List<Header> headerList = getHeaders();
       boolean isExist = false;
       for (Header header : headerList) {
           if (header.getName().toLowerCase().equals(headerName)) {
               isExist = true;
               break;
           }
       }
       return isExist;
    }

    public User[] getUsers() {
        return getUsersResponse().as(User[].class);
    }

    public String getHeaderValue(String headerName) {
        List<Header> headerList = getHeaders();
        for (Header header : headerList) {
            if (header.getName().toLowerCase().equals(headerName)) {
                return header.getValue();
            }
        }
        throw new RuntimeException( headerName = " header is absent.");
    }

    private List<Header> getHeaders() {
        return  getUsersResponse().getHeaders().asList();
    }

    private Response getUsersResponse() {
        return RestAssured.given().get("/users").andReturn();
    }
}
