package prime.com.primeclient.pos;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import prime.com.primeclient.R;
import prime.com.primeclient.controllers.pos.Posmain;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPosmain extends Fragment implements View.OnClickListener, Posmain.IPosmain {

    RecyclerView poslist;
    Posmain posmain;

    View _rootView;

    public FragmentPosmain() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        posmain = new Posmain(this);
        posmain.onCreate();
        if (_rootView == null) {
            _rootView = inflater.inflate(R.layout.fragment_posmain, container, false);
        }
        return _rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        posmain.onViewCreated();
    }

    @Override
    public void initializeView() {
        poslist = (RecyclerView) getActivity().findViewById(R.id.poslist);
    }

    @Override
    public void listAdapter() {
        poslist.setAdapter(posmain.getAdapter());
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        poslist.setLayoutManager(manager);
    }

    @Override
    public void onClick(View view) {
        posmain.onClick(view);
    }
}
