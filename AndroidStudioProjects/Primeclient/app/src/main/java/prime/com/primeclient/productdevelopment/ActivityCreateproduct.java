package prime.com.primeclient.productdevelopment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import prime.com.primeclient.R;
import prime.com.primeclient.controllers.productdevelopment.Createproduct;
import prime.com.primeclient.models.ProductModel;

public class ActivityCreateproduct extends AppCompatActivity implements View.OnClickListener, Createproduct.ICreateproduct, AdapterView.OnItemSelectedListener {

    Createproduct createproduct;
    Spinner spinner_producttype;
    LinearLayout layout_producttype;
    Button saveproduct;
    String flag = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createproduct = new Createproduct(this);
        setContentView(R.layout.activity_createproduct);
        spinner_producttype = (Spinner) findViewById(R.id.spinner_producttype);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.producttype_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_producttype.setOnItemSelectedListener(this);
        saveproduct = (Button) findViewById(R.id.saveproduct);
        saveproduct.setOnClickListener(this);
        spinner_producttype.setAdapter(adapter);
        layout_producttype = (LinearLayout) findViewById(R.id.layout_producttype);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i) {
            case 0:
                prod();
                flag = "prod";
                break;
            case 1:
                imp();
                flag = "imp";
                break;
            case 2:
                mould();
                flag = "mould";
                break;
            case 3:
                rm();
                flag = "rm";
                break;
            case 4:
                consumables();
                flag = "consumables";
                break;
            case 5:
                insert();
                flag = "insert";
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    void prod() {
        layout_producttype.removeAllViews();
        TextView tv = new TextView(this);
        tv.setText("Product Details");
        tv.setId(View.generateViewId());
        layout_producttype.addView(tv);
        EditText et3 = new EditText(this);
        et3.setHint("Minimum bill Quantity");
        et3.setInputType(InputType.TYPE_CLASS_NUMBER);
        et3.setId(View.generateViewId());
        layout_producttype.addView(et3);
        EditText et4 = new EditText(this);
        et4.setHint("Cost");
        et4.setInputType(InputType.TYPE_CLASS_PHONE);
        et4.setId(View.generateViewId());
        layout_producttype.addView(et4);
        EditText et5 = new EditText(this);
        et5.setHint("Customer");
        et5.setId(View.generateViewId());
        layout_producttype.addView(et5);

    }

    void imp() {
        layout_producttype.removeAllViews();
        TextView tv = new TextView(this);
        tv.setText("Product Details");
        tv.setId(View.generateViewId());
        layout_producttype.addView(tv);
        EditText et1 = new EditText(this);
        et1.setHint("Mould Code");
        et1.setId(View.generateViewId());
        layout_producttype.addView(et1);
        EditText et2 = new EditText(this);
        et2.setHint("RM Code");
        et2.setId(View.generateViewId());
        layout_producttype.addView(et2);
        EditText et3 = new EditText(this);
        et3.setHint("Part Wt");
        et3.setInputType(InputType.TYPE_CLASS_NUMBER);
        et3.setId(View.generateViewId());
        layout_producttype.addView(et3);
        EditText et4 = new EditText(this);
        et4.setHint("Shot Wt");
        et4.setInputType(InputType.TYPE_CLASS_NUMBER);
        et4.setId(View.generateViewId());
        layout_producttype.addView(et4);
        EditText et5 = new EditText(this);
        et5.setHint("Cavity");
        et5.setId(View.generateViewId());
        et3.setInputType(InputType.TYPE_CLASS_NUMBER);
        layout_producttype.addView(et5);

    }

    void mould() {
        layout_producttype.removeAllViews();
        TextView tv = new TextView(this);
        tv.setText("Product Details");
        tv.setId(0);
        layout_producttype.addView(tv);
    }

    void rm() {
        layout_producttype.removeAllViews();
        TextView tv = new TextView(this);
        tv.setText("Product Details");
        tv.setId(0);
        layout_producttype.addView(tv);
    }

    void consumables() {
        layout_producttype.removeAllViews();
        TextView tv = new TextView(this);
        tv.setText("Product Details");
        tv.setId(0);
        layout_producttype.addView(tv);
    }

    private void insert() {
        layout_producttype.removeAllViews();
        TextView tv = new TextView(this);
        tv.setText("Product Details");
        tv.setId(0);
        layout_producttype.addView(tv);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.saveproduct) {
            if (flag == "prod") {
                ProductModel product = new ProductModel();
//                product.setProductName();
            }
        }
    }
}
