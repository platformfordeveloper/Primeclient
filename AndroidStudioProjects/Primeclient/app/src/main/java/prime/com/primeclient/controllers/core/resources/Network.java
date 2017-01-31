package prime.com.primeclient.controllers.core.resources;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by BrahmaRishi on 27/01/17.
 */

public class Network {
    INetwork network;

    public Network(Object object) {
        network = (INetwork) object;
    }

    private static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");


    public void post(String url, String json) throws IOException {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
                network.networkCallback(response);
            }
        });
    }

    public interface INetwork {
        void networkCallback(Response response);
    }
}
