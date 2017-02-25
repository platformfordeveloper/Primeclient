package prime.com.primeclient.pos;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import prime.com.primeclient.R;
import prime.com.primeclient.controllers.pos.ProductSelector;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentProductselector extends Fragment implements ProductSelector.IProductSelector, View.OnClickListener {

    View _rootView;
    ProductSelector productSelector;
    Button createnew;

    public FragmentProductselector() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (_rootView == null)
            _rootView = inflater.inflate(R.layout.fragment_productselector, container, false);
        productSelector = new ProductSelector(this);
        return _rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        productSelector.onViewCreated();
    }

    @Override
    public void onClick(View view) {
        productSelector.onClick(view);
    }

    @Override
    public void initializeView() {
        createnew = (Button) getActivity().findViewById(R.id.button_createnew);
        createnew.setOnClickListener(this);
    }
}
