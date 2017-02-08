package prime.com.primeclient.controllers.pos;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import prime.com.primeclient.R;
import prime.com.primeclient.models.pos.PosListItemModel;
import prime.com.primeclient.pos.FragmentPosmain;

/**
 * Created by BrahmaRishi on 02/02/17.
 */

public class Posmain {

    FragmentPosmain fragment;
    PoslistAdapter adapter;
    IPosmain iPosmain;


    public Posmain(FragmentPosmain fragment) {
        this.fragment = fragment;
        iPosmain = fragment;
        adapter();
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

    }

    void adapter() {
        adapter = new PoslistAdapter(fragment.getActivity());
        List<PosListItemModel> list = adapter.getList();
        PosListItemModel item1 = new PosListItemModel("Maggie", 1, 45.05, null, "");
        list.add(item1);
        PosListItemModel item2 = new PosListItemModel("Top Ramen", 1, 45.05, null, "");
        list.add(item2);
        PosListItemModel item3 = new PosListItemModel("Pepper", 1, 95, null, "");
        list.add(item3);
        PosListItemModel item4 = new PosListItemModel("Uniball", 1, 30, null, "");
        list.add(item4);
        PosListItemModel item5 = new PosListItemModel("Speaker", 1, 4500, null, "");
        list.add(item5);
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

        void listAdapter();
    }

}
