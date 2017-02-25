package prime.com.primeclient.entry;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import prime.com.primeclient.R;
import prime.com.primeclient.controllers.core.entry.SignUp;
import prime.com.primeclient.models.SignUpModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSignup extends Fragment implements View.OnClickListener, SignUp.ISignUp {

    private View _rootView;
    private EditText input_name, input_email, input_password;
    private Button button_signup;
    private SignUp signUp;
    private TextView text_login;

    public FragmentSignup() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        signUp = new SignUp(this);
        if (_rootView == null) {
            _rootView = inflater.inflate(R.layout.fragment_signup, container, false);
        }
        return _rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        signUp.onActivityCreated();
    }

    @Override
    public void initializeView() {
        input_name = (EditText) getActivity().findViewById(R.id.input_name);
        input_email = (EditText) getActivity().findViewById(R.id.input_email);
        input_password = (EditText) getActivity().findViewById(R.id.input_password);
        button_signup = (Button) getActivity().findViewById(R.id.button_signup);
        button_signup.setOnClickListener(this);
        text_login = (TextView) getActivity().findViewById(R.id.text_login);
        text_login.setOnClickListener(this);
    }

    @Override
    public SignUpModel bindSignUp() {
        SignUpModel signUp = new SignUpModel();
        signUp.setName(input_name.getText().toString());
        signUp.setEmail(input_email.getText().toString());
        signUp.setPassword(input_password.getText().toString());
        return signUp;
    }

    @Override
    public void onClick(View v) {
        signUp.onClick(v);
    }

}