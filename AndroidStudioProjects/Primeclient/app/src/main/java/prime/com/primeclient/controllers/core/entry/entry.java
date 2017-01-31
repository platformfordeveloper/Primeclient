package prime.com.primeclient.controllers.core.entry;

import android.app.Activity;
import android.app.FragmentTransaction;

import prime.com.primeclient.R;
import prime.com.primeclient.entry.ActivityEntry;
import prime.com.primeclient.entry.FragmentLogin;
import prime.com.primeclient.entry.FragmentSignup;

/**
 * Created by BrahmaRishi on 28/01/17.
 */

public class Entry {

    IEntry iEntry;
    Activity activity;

    public Entry(ActivityEntry activity) {
        this.activity = activity;
        iEntry = activity;
    }

    public void onCreate() {
        FragmentLogin login = new FragmentLogin();
        FragmentTransaction transaction = activity.getFragmentManager().beginTransaction();
        transaction.add(R.id.activity_entry, login, "login");
        transaction.commit();
    }

    public void showSignup() {
        FragmentSignup signup = new FragmentSignup();
        FragmentTransaction transaction = activity.getFragmentManager().beginTransaction();
        transaction.replace(R.id.activity_entry, signup, "signup");
        transaction.commit();
    }

    public void showLogin() {
        FragmentLogin login = new FragmentLogin();
        FragmentTransaction transaction = activity.getFragmentManager().beginTransaction();
        transaction.replace(R.id.activity_entry, login, "login");
        transaction.commit();
    }

    public interface IEntry {

    }
}
