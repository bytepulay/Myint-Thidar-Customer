package asia.nainglintun.myintthidarcustomer.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import asia.nainglintun.myintthidarcustomer.R;
import asia.nainglintun.myintthidarcustomer.models.Orderhistory;

public class CustomerOrderRecyclerAdapter extends RecyclerView.Adapter<CustomerOrderRecyclerAdapter.MyViewHolder> {

    private List<Orderhistory> salehistories;
    private Context context;

    public CustomerOrderRecyclerAdapter(List<Orderhistory> salehistories, Context context) {
        this.salehistories = salehistories;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_sale_list_layout, parent, false);

        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {

        holder.saleDate.setText("date : " + salehistories.get(i).getOrderDate());
        holder.voucherNo.setText("sale name:" + salehistories.get(i).getSaleUserName());
        holder.shopName.setText("voucher no: " + salehistories.get(i).getVoucherNumber());
        holder.town.setText("gram : " + salehistories.get(i).getGram());
        holder.quantity.setText("Quantity :" + salehistories.get(i).getQty());
        holder.point_eight.setText("Point Eight :" + salehistories.get(i).getPointEight());
    }

    @Override
    public int getItemCount() {
        return salehistories.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView shopName, saleDate, voucherNo, town, quantity, point_eight;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            shopName = itemView.findViewById(R.id.shopName);
            saleDate = itemView.findViewById(R.id.sDate);
            voucherNo = itemView.findViewById(R.id.voucherNo);
            town = itemView.findViewById(R.id.town);
            quantity = itemView.findViewById(R.id.normalItem);
            point_eight = itemView.findViewById(R.id.pointEightItem);
        }
    }


    public void setFilter(ArrayList<Orderhistory> newList) {
        salehistories = new ArrayList<>();
        salehistories.addAll(newList);
        notifyDataSetChanged();
    }
}
