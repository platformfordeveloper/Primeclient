package prime.com.primeclient.controllers.core.entry;

import android.view.View;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.Response;
import prime.com.primeclient.R;
import prime.com.primeclient.controllers.core.resources.Network;
import prime.com.primeclient.controllers.core.resources.Support;
import prime.com.primeclient.controllers.core.resources.Validator;
import prime.com.primeclient.entry.FragmentLogin;
import prime.com.primeclient.models.core.LoginModel;

/**
 * Created by BrahmaRishi on 27/01/17.
 */

public class Login implements Network.INetwork {
    private ILogin iLogin;
    private CEntry comm;
    private FragmentLogin fragment;

    public Login(FragmentLogin fragment) {
        this.fragment = fragment;
        iLogin = fragment;
        comm = (CEntry) fragment.getActivity();
    }

    public void onActivityCreated() {

        iLogin.initializeView();
    }

    public void onClick(View v) {
        LoginModel login = iLogin.bindLoginModel();
        switch (v.getId()) {
            case R.id.button_login:
                Validator validator = new Validator();
                if (validator.validateEmail(login.getEmail()) && validator.validatePassword(login.getPassword())) {
                    iLogin.showProgressDialog();
                    String json = new Support().toJson(login);
                    Network network = new Network(this);
                    try {
                        network.post(fragment.getActivity().getString(R.string.apiUrl) + "/authentication", json);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case R.id.text_signup:
                comm.showSignup();
        }
    }

    @Override
    public void networkCallback(Response response) {
        iLogin.dismissProgressDialog();

        Headers responseHeaders = response.headers();

        for (int i = 0, size = responseHeaders.size(); i < size; i++) {
            System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
        }

    }

    public interface ILogin {
        void initializeView();

        LoginModel bindLoginModel();

        void dismissProgressDialog();

        void showProgressDialog();
    }

    public interface CEntry {
        void showSignup();
    }
}
