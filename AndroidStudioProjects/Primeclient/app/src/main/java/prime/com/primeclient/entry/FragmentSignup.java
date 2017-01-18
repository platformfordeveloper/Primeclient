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

import prime.com.primeclient.R;
import prime.com.primeclient.model.core.SignUp;

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
            SignUp signUp = new SignUp();
            signUp.setName(input_name.getText().toString());
            signUp.setEmail(input_email.getText().toString());
            signUp.setPassword(input_password.getText().toString());

            ObjectMapper mapper = new ObjectMapper();
            try {
                String json=mapper.writeValueAsString(signUp);
                Toast.makeText(getActivity(), json ,Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}