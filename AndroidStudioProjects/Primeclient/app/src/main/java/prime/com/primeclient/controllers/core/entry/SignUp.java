package prime.com.primeclient.controllers.core.entry;

import android.view.View;

import java.io.IOException;

import okhttp3.Response;
import prime.com.primeclient.R;
import prime.com.primeclient.controllers.core.resources.Network;
import prime.com.primeclient.controllers.core.resources.Support;
import prime.com.primeclient.controllers.core.resources.Validator;
import prime.com.primeclient.entry.FragmentSignup;
import prime.com.primeclient.models.core.SignUpModel;

/**
 * Created by BrahmaRishi on 18/01/17.
 */

public class SignUp implements Network.INetwork{
    ISignUp iSignUp;
    CEntry comm;
    FragmentSignup fragment;

    public SignUp(FragmentSignup fragment) {
        this.fragment = fragment;
        iSignUp = fragment;
        comm = (CEntry) fragment.getActivity();
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_signup:
                Validator validator = new Validator();
                SignUpModel signUp = iSignUp.bindSignUp();
                if (validator.validateEmail(signUp.getEmail())) {
                    String json = new Support().toJson(signUp);
                    Network network = new Network(this);
                    try {
                        network.post(fragment.getActivity().getString(R.string.apiUrl) + "/users", json);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case R.id.text_login:
                comm.showLogin();
        }
    }

    public void onActivityCreated() {
        iSignUp.initializeView();
    }

    @Override
    public void networkCallback(Response response) {
        comm.showLogin();
    }

    public interface ISignUp {

        void initializeView();

        SignUpModel bindSignUp();
    }

    public interface CEntry {
        void showLogin();
    }
}
