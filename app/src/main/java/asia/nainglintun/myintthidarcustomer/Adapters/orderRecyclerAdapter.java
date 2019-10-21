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

public class orderRecyclerAdapter extends RecyclerView.Adapter<orderRecyclerAdapter.MyViewHolder> {

    private List<Orderhistory> orderhistories;
    private Context context;

    public orderRecyclerAdapter(List<Orderhistory> orderhistories, Context context) {
        this.orderhistories = orderhistories;
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

        holder.saleDate.setText("date : " + orderhistories.get(i).getOrderDate());
        holder.voucherNo.setText("voucher no :" + orderhistories.get(i).getVoucherNumber());
        holder.shopName.setText("shop: " + orderhistories.get(i).getCustomerShop());
        holder.town.setText("Town : " + orderhistories.get(i).getCustomerTwon());
        holder.quantity.setText("Quantity :" + orderhistories.get(i).getQty());
        holder.point_eight.setText("Point Eight :" + orderhistories.get(i).getPointEight());
    }

    @Override
    public int getItemCount() {
        return orderhistories.size();
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
        orderhistories = new ArrayList<>();
        orderhistories.addAll(newList);
        notifyDataSetChanged();
    }
}
