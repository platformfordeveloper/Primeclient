package prime.com.primeclient.entry;


import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import prime.com.primeclient.R;
import prime.com.primeclient.controllers.core.entry.Login;
import prime.com.primeclient.models.core.LoginModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentLogin extends Fragment implements View.OnClickListener {

    private View _rootView;
    Login login;
    private TextView input_email;
    private TextView input_password;
    private Button button_login;
    private ProgressDialog progressDialog = null;

    public FragmentLogin() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        login = new Login(this);
        if (_rootView == null) {
            _rootView = inflater.inflate(R.layout.fragment_login, container, false);
        }
        return _rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        login.onActivityCreated();
    }

    public void initializeView() {
        input_email = (TextView) getActivity().findViewById(R.id.input_email);
        input_password = (TextView) getActivity().findViewById(R.id.input_password);
        button_login = (Button) getActivity().findViewById(R.id.button_login);
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Logging in ...");
        progressDialog.setIndeterminate(true);
        button_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        login.onClick(v);
    }

    public LoginModel bindLoginModel() {
        LoginModel login = new LoginModel();
        login.setEmail(input_email.getText().toString());
        login.setPassword(input_password.getText().toString());
        return login;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (progressDialog != null) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

    public void showProgressDialog() {
        progressDialog.show();
    }
}
