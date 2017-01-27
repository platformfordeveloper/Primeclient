package prime.com.primeclient.controllers.core.entry;

import android.content.Context;
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
    ILogin iLogin;
    Context context;

    public Login(FragmentLogin view) {
        iLogin = view;
        context = view.getContext();
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
                        network.post(context.getResources().getString(R.string.loginUrl), json);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        }
    }

    public interface ILogin {
        void initializeView();

        LoginModel bindLoginModel();

        void showProgressDialog();
    }
}
