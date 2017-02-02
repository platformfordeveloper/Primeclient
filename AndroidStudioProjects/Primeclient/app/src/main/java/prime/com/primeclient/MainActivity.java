package prime.com.primeclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import prime.com.primeclient.entry.ActivityEntry;
import prime.com.primeclient.pos.ActivityPos;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, ActivityPos.class);
        startActivity(intent);
    }
}
