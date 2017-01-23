package prime.com.primeclient.controllers.core.entry;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import prime.com.primeclient.R;
import prime.com.primeclient.entry.FragmentSignup;
import prime.com.primeclient.models.core.SignUpModel;

/**
 * Created by BrahmaRishi on 18/01/17.
 */

public class SignUp {
    FragmentSignup view;

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    public SignUp(FragmentSignup view) {
        this.view = view;
    }

    public void onClick() {
        SignUpModel signUp = view.bindSignUpModel();
        String json = toJson(signUp);
        try {
            post(view.getResources().getString(R.string.userUrl), json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    void post(String url, String json) throws IOException {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
//        Response response = client.newCall(request).execute();
//        return response.body().string();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                Headers responseHeaders = response.headers();
                for (int i = 0, size = responseHeaders.size(); i < size; i++) {
                    System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
                }

                System.out.println(response.body().string());
            }
        });
    }

    //TODO:to be put in support class
    String toJson(SignUpModel signUp) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(signUp);
            return json;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
