package prime.com.primeclient.entry;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import prime.com.primeclient.R;

public class ActivityEntry extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);
        signup();
    }

    void signup() {
        FragmentSignup signup = new FragmentSignup();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.activity_entry, signup, "signup");
        transaction.addToBackStack("signup");
        transaction.commit();
    }
}
