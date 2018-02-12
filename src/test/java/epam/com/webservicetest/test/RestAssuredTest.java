package epam.com.webservicetest.test;

import epam.com.webservicetest.service.RestAssuredService;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RestAssuredTest {
    private static final int STATUS_CODE = 200;
    private static final String CONTENT_TYPE = "content-type";
    private RestAssuredService service;

    @BeforeTest
    public void initTest() {
        service = new RestAssuredService();
    }

    @Test
    public void checkStatusCode() {
        Assert.assertEquals(service.getResponseStatusCode(), STATUS_CODE,
                "Status code should be " + STATUS_CODE);
    }

    @Test
    public void checkResponseHeader() {
        Assert.assertTrue(service.isHeaderExist(CONTENT_TYPE));
        Assert.assertTrue(service.getHeaderValue(CONTENT_TYPE).equals("application/json; charset=utf-8"));
    }
    @Test
    public void checkResponseBody() {
        Assert.assertEquals(service.getUsers().length, 10);
    }
}
