package epam.com.webservicetest.service.retrofitservice;

import epam.com.webservicetest.model.gist.FileTxt;
import epam.com.webservicetest.model.gist.Files;
import epam.com.webservicetest.model.gist.Gist;
import epam.com.webservicetest.service.retrofitservice.Service;
import epam.com.webservicetest.service.retrofitservice.ServiceWrapper;
import epam.com.webservicetest.util.JsonHelper;
import okhttp3.ResponseBody;
import retrofit2.Call;

import java.io.IOException;

public class RetrofitServiceHelper {
	private Service service;

	public RetrofitServiceHelper() {
		service = ServiceWrapper.getInstance();
	}

	public Gist[] getGistList() {
		String body;
		try {
			body = new String(service.getGists().execute().body().bytes());
			return JsonHelper.fromJson(body, Gist[].class);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public int getStatusCode() {
		try {
			return getGists().execute().code();
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public boolean isGistCreate() {
		try {
			return createGist().execute().code() == 201;
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	private Call<ResponseBody> getGists(){
		return service.getGists();
	}

	private Call<ResponseBody> createGist(){
		Gist gist = new Gist(new Files(new FileTxt("test")));
		return service.createGist(gist);
	}
}
