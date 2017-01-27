package prime.com.primeclient.controllers.core.entry;

import android.view.View;

import java.io.IOException;

import prime.com.primeclient.R;
import prime.com.primeclient.controllers.core.resources.Network;
import prime.com.primeclient.controllers.core.resources.Support;
import prime.com.primeclient.controllers.core.resources.Validator;
import prime.com.primeclient.entry.FragmentSignup;
import prime.com.primeclient.models.core.SignUpModel;

/**
 * Created by BrahmaRishi on 18/01/17.
 */

public class SignUp {
    FragmentSignup view;

    public SignUp(FragmentSignup view) {
        this.view = view;
    }

    public void onClick(View v) {
        if (v.getId() == R.id.button_signup) {
            Validator validator = new Validator();
            SignUpModel signUp = view.bindSignUpModel();
            if (validator.validateEmail(signUp.getEmail())) {
                String json = new Support().toJson(signUp);
                Network network = new Network(this);
                try {
                    network.post(view.getResources().getString(R.string.userUrl), json);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void onActivityCreated() {
        view.initializeView();
    }
}
