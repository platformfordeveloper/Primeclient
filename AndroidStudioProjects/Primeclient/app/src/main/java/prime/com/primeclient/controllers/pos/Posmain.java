package prime.com.primeclient.controllers.pos;

import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import prime.com.primeclient.R;
import prime.com.primeclient.models.BillModel;
import prime.com.primeclient.models.PosListItemModel;
import prime.com.primeclient.pos.FragmentPosmain;
import prime.com.primeclient.pos.FragmentProductselector;

/**
 * Created by BrahmaRishi on 02/02/17.
 */

public class Posmain {

    FragmentPosmain fragment;
    PoslistAdapter adapter;
    IPosmain iPosmain;
    BillModel bill;


    public Posmain(FragmentPosmain fragment) {
        this.fragment = fragment;
        iPosmain = fragment;
        adapter();
        bill = new BillModel();
    }


    public PoslistAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(PoslistAdapter adapter) {
        this.adapter = adapter;
    }

    public void onCreate() {

    }

    public void onViewCreated() {
        iPosmain.initializeView();
        iPosmain.listAdapter();
    }

    public void onClick(View view) {
        if (view.getId() == R.id.fab)
            addItem();
        else if (view.getId() == R.id.button_additem) {
            FragmentProductselector fragmentProductselector = new FragmentProductselector();
            FragmentTransaction transaction = fragment.getFragmentManager().beginTransaction();
            transaction.replace(R.id.activity_pos, fragmentProductselector, "pos");
            transaction.commit();
        }
    }

    void adapter() {
        adapter = new PoslistAdapter(fragment.getActivity());
    }

    void addItem() {
        List<PosListItemModel> list = adapter.getList();

        PosListItemModel item = new PosListItemModel("Maggie", 1, 45.05, null);
        list.add(item);
        bill.setList(list);
        bill.setTOTAL( Math.round((bill.getTOTAL() + item.getPrice())*100.0)/100.0);

        iPosmain.setTotal(bill.getTOTAL());
        bill.getTOTAL();
        adapter.notifyDataSetChanged();
    }


    //     Adapter for recycler view class
    public class PoslistAdapter extends RecyclerView.Adapter<ListViewHolder> {

        //        List<PosListItem> list = Collections.emptyList();

        List<PosListItemModel> list = new ArrayList<>();
        private LayoutInflater inflater;

        public List<PosListItemModel> getList() {
            return list;
        }

        public void setList(List<PosListItemModel> list) {
            this.list = list;
            notifyDataSetChanged();
        }

        public PoslistAdapter(Context context) {
            inflater = LayoutInflater.from(context);
        }

        @Override
        public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.support_poslistitem, parent, false);
            ListViewHolder holder = new ListViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(ListViewHolder holder, int position) {
            PosListItemModel item = list.get(position);
            holder.productName.setText(item.getProductName());
            holder.qty.setText(Double.toString(item.getQty()));
            holder.rate.setText(Double.toString(item.getRate()));
            holder.price.setText(Double.toString(item.getPrice()));
            holder.itemView.setBackgroundResource(position % 2 == 0 ?
                    R.color.list_item_background_alternating : R.color.list_item_background);
        }


        @Override
        public int getItemCount() {
            return list.size();
        }


    }

    //ViewHolder class
    class ListViewHolder extends RecyclerView.ViewHolder {

        TextView productName;
        TextView qty;
        TextView rate;
        TextView price;

        public ListViewHolder(View itemView) {
            super(itemView);
            productName = (TextView) itemView.findViewById(R.id.productName);
            qty = (TextView) itemView.findViewById(R.id.qty);
            rate = (TextView) itemView.findViewById(R.id.rate);
            price = (TextView) itemView.findViewById(R.id.price);
        }
    }

    /*TODO:copy this code to when adding to cart stage
        public void calculatePrice() {

            if (getTax() == 0) {
                double price = getRate() * getQty();
                Log.d("Error", String.valueOf(price));
                setPrice(price);
            } else {
                double price = getRate() * getQty()*getTax();
                Log.d("Error", String.valueOf(price));
                setPrice(price);
            }
        }
        */
    public interface IPosmain {
        void initializeView();

        void setTotal(double total);

        void listAdapter();
    }

}
