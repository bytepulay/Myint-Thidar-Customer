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
import asia.nainglintun.myintthidarcustomer.models.Salehistory;

public class saleRecyclerAdapter extends RecyclerView.Adapter<saleRecyclerAdapter.MyViewHolder> {

    private List<Salehistory> salehistories;
    private Context context;

    public saleRecyclerAdapter(List<Salehistory> salehistories, Context context) {
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

        holder.saleDate.setText("date : " + salehistories.get(i).getSaleDate());
        holder.voucherNo.setText("voucher no :" + salehistories.get(i).getVoucherNumber());
        holder.shopName.setText("shop: " + salehistories.get(i).getCustomerShop());
        holder.town.setText("Town : " + salehistories.get(i).getCustomerTwon());
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

    public void setFilter(ArrayList<Salehistory> newList) {
        salehistories = new ArrayList<>();
        salehistories.addAll(newList);
        notifyDataSetChanged();
    }
}
