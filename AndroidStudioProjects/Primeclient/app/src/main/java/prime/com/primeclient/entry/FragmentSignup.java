package prime.com.primeclient.entry;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import prime.com.primeclient.R;
import prime.com.primeclient.controllers.core.entry.SignUp;
import prime.com.primeclient.models.core.SignUpModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSignup extends Fragment implements View.OnClickListener {

    View _rootView;
    EditText input_name, input_email, input_password;
    Button button_signup;
    SignUp signUp;

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

    public void initializeView(){
        input_name = (EditText) getActivity().findViewById(R.id.input_name);
        input_email = (EditText) getActivity().findViewById(R.id.input_email);
        input_password = (EditText) getActivity().findViewById(R.id.input_password);
        button_signup = (Button) getActivity().findViewById(R.id.button_signup);
        button_signup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        signUp.onClick(v);

    }


    public SignUpModel bindSignUpModel() {
        SignUpModel signUp = new SignUpModel();
        signUp.setName(input_name.getText().toString());
        signUp.setEmail(input_email.getText().toString());
        signUp.setPassword(input_password.getText().toString());
        return signUp;
    }

}