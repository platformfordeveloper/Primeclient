package prime.com.primeclient.pos;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import prime.com.primeclient.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentProductselector extends Fragment {


    public FragmentProductselector() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_productselector, container, false);
    }

}
