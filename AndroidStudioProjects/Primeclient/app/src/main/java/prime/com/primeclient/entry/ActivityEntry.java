package prime.com.primeclient.entry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import prime.com.primeclient.R;
import prime.com.primeclient.controllers.core.entry.Entry;
import prime.com.primeclient.controllers.core.entry.Login;
import prime.com.primeclient.controllers.core.entry.SignUp;

public class ActivityEntry extends AppCompatActivity implements Entry.IEntry, Login.CEntry,SignUp.CEntry {

    Entry entry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);
        entry = new Entry(this);
        entry.onCreate();
    }

    @Override
    public void showSignup() {
        entry.showSignup();
    }

    @Override
    public void showLogin() {
        entry.showLogin();
    }
}
