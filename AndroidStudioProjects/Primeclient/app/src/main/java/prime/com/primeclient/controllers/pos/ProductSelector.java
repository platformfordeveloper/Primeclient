package prime.com.primeclient.controllers.pos;

import android.content.Intent;
import android.view.View;

import prime.com.primeclient.R;
import prime.com.primeclient.pos.FragmentProductselector;
import prime.com.primeclient.productdevelopment.ActivityCreateproduct;

/**
 * Created by BrahmaRishi on 09/02/17.
 */

public class ProductSelector {
    FragmentProductselector fragment;
    IProductSelector iProductSelector;

    public ProductSelector(FragmentProductselector fragment) {
        this.fragment = fragment;
        iProductSelector = fragment;
    }


    public void onViewCreated() {
        fragment.initializeView();
    }

    public void onClick(View view) {
        if (view.getId() == R.id.button_createnew) {
            Intent intent = new Intent(fragment.getActivity(), ActivityCreateproduct.class);
            fragment.startActivity(intent);
        }
    }


    public interface IProductSelector {
        void initializeView();
    }
}
