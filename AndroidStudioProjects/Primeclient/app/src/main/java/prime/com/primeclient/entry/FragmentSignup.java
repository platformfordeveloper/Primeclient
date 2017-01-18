package prime.com.primeclient.entry;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import prime.com.primeclient.R;
import prime.com.primeclient.controller.core.entry.SignUp;
import prime.com.primeclient.model.core.SignUpModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSignup extends Fragment implements View.OnClickListener {

    View _rootView;
    EditText input_name, input_email, input_password;
    Button button_signup;


    public FragmentSignup() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (_rootView == null) {
            _rootView = inflater.inflate(R.layout.fragment_signup, container, false);
        }
        return _rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        input_name = (EditText) getActivity().findViewById(R.id.input_name);
        input_email = (EditText) getActivity().findViewById(R.id.input_email);
        input_password = (EditText) getActivity().findViewById(R.id.input_password);
        button_signup = (Button) getActivity().findViewById(R.id.button_signup);
        button_signup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_signup) {
            onclickclicked();
        }
    }

    public SignUpModel bindSignUpModel() {
        SignUpModel signUp = new SignUpModel();
        signUp.setName(input_name.getText().toString());
        signUp.setEmail(input_email.getText().toString());
        signUp.setPassword(input_password.getText().toString());
        return signUp;
    }


    void onclickclicked() {
        SignUpModel signUp = bindSignUpModel();
        String json = objtojson(signUp);
        try {
            String toast = post("http://192.168.1.100/posttest/", json);
            Toast.makeText(getActivity(), toast, Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    String post(String url, String json) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = okHttpClient.newCall(request).execute();
        return response.body().string();
    }

    String objtojson(SignUpModel signUp) {
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