package core;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class Http {
	public static void main(String[] args) throws URISyntaxException, ClientProtocolException, IOException {

		HttpClient client = HttpClientBuilder.create().build();
		URIBuilder builder_create = new URIBuilder("https://api.vk.com/method/wall.post?");
		builder_create
				.setParameter("access_token",
						"177a1735df307fe0d0f7c0d5eebf468f8bdf670a572738fe82a630b3a3575fb177a2a9166c663f9fba46c")
				.setParameter("owner_id", "45981626").setParameter("message", "test message Java")
				.setParameter("v", "5.92");
		HttpGet request_create = new HttpGet(builder_create.build());
		HttpResponse response_create = client.execute(request_create);
		String str = EntityUtils.toString(response_create.getEntity());
		System.out.println(str);
		str = str.replaceAll("\\D+", "");
		System.out.println(str);

		URIBuilder builder_edit = new URIBuilder("https://api.vk.com/method/wall.edit?");
		builder_edit
				.setParameter("access_token",
						"177a1735df307fe0d0f7c0d5eebf468f8bdf670a572738fe82a630b3a3575fb177a2a9166c663f9fba46c")
				.setParameter("owner_id", "45981626").setParameter("post_id", str).setParameter("v", "5.92")
				.setParameter("message", "EDIT MESSEGE");
		HttpGet request_edit = new HttpGet(builder_edit.build());
		HttpResponse response_edit = client.execute(request_edit);
		System.out.println(EntityUtils.toString(response_edit.getEntity()));

		URIBuilder builder_delete = new URIBuilder("https://api.vk.com/method/wall.delete?");
		builder_delete
				.setParameter("access_token",
						"177a1735df307fe0d0f7c0d5eebf468f8bdf670a572738fe82a630b3a3575fb177a2a9166c663f9fba46c")
				.setParameter("owner_id", "45981626").setParameter("post_id", str).setParameter("v", "5.92");
		HttpGet request_delete = new HttpGet(builder_delete.build());
		HttpResponse response_delete = client.execute(request_delete);
		System.out.println(EntityUtils.toString(response_delete.getEntity()));

	}

}
