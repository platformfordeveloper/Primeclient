package prime.com.primeclient.pos;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import prime.com.primeclient.R;

public class ActivityPos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pos);

        FragmentPosmain fragment = new FragmentPosmain();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.activity_pos, fragment, "pos");
        transaction.commit();
    }
}
