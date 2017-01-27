package prime.com.primeclient.controllers.core.entry;

import android.view.View;

import java.io.IOException;

import prime.com.primeclient.R;
import prime.com.primeclient.controllers.core.resources.Network;
import prime.com.primeclient.controllers.core.resources.Support;
import prime.com.primeclient.controllers.core.resources.Validator;
import prime.com.primeclient.entry.FragmentLogin;
import prime.com.primeclient.models.core.LoginModel;

/**
 * Created by BrahmaRishi on 27/01/17.
 */

public class Login {
    FragmentLogin view;

    public Login(FragmentLogin view) {
        this.view = view;
    }

    public void onActivityCreated() {
        view.initializeView();
    }

    public void onClick(View v) {
        LoginModel login = view.bindLoginModel();
        switch (v.getId()) {
            case R.id.button_login:
                Validator validator = new Validator();
                if (validator.validateEmail(login.getEmail()) && validator.validatePassword(login.getPassword())) {
                    view.showProgressDialog();
                    String json = new Support().toJson(login);
                    Network network = new Network(this);
                    try {
                        network.post(view.getResources().getString(R.string.loginUrl), json);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        }
    }
}
