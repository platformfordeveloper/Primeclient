package prime.com.primeclient.selectcompany;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseUser;

import prime.com.primeclient.R;

public class ActivityCompanyselector extends AppCompatActivity implements View.OnClickListener {

    Button join, create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_companyselector);
        join = (Button) findViewById(R.id.join);
        join.setOnClickListener(this);
        create = (Button) findViewById(R.id.create);
        create.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.create) {

        } else if (view.getId() == R.id.join) {

        }
    }
}
