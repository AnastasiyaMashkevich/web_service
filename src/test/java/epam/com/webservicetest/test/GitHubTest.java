package epam.com.webservicetest.test;

import epam.com.webservicetest.service.retrofitservice.RetrofitServiceHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GitHubTest {

	private RetrofitServiceHelper serviceHelper;
	private static final int STATUS_CODE = 200;

	@BeforeMethod
	public void setup() {
		serviceHelper = new RetrofitServiceHelper();
	}

	@Test
	public void getGistListTest() {
		Assert.assertEquals(serviceHelper.getStatusCode(), STATUS_CODE,
				"Status code should be " + STATUS_CODE);
	}

	@Test
	public void createGistTest() {
		Assert.assertTrue(serviceHelper.isGistCreate(),
				"Gist was not created.");
	}
}
