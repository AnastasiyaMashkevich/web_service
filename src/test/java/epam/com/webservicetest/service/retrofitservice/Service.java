package epam.com.webservicetest.service.retrofitservice;

import epam.com.webservicetest.model.gist.Gist;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

public interface Service {

	@GET("/gists/public")
	Call<ResponseBody> getGists();

	@POST("/gists")
	Call<ResponseBody> createGist(@Body Gist gist);
}

