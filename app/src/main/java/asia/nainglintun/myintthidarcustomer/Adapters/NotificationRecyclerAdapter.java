package asia.nainglintun.myintthidarcustomer.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import asia.nainglintun.myintthidarcustomer.R;
import asia.nainglintun.myintthidarcustomer.models.Notification;

public class NotificationRecyclerAdapter extends RecyclerView.Adapter <NotificationRecyclerAdapter.MyViewHolder>{

    private List<Notification> orderhistories;
    private Context context;



    public NotificationRecyclerAdapter(List<Notification> orderhistories, Context context) {
        this.orderhistories = orderhistories;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_notification,parent,false);

        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {

        holder.oneDate.setText(orderhistories.get(i).getDate_one());
        holder.oneTitle.setText(orderhistories.get(i).getTitle_one());
       // holder.shopName.setText("shop: " +orderhistories.get(i).getCustomer_id());
//        holder.town.setText("Town : " + orderhistories.get(i).getCustomerTwon());
    }

    @Override
    public int getItemCount() {
        return orderhistories.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView groupDate,oneDate,oneTitle,groupTitle;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

           // groupDate = itemView.findViewById(R.id.groupDate);
            oneDate = itemView.findViewById(R.id.oneDate);
            oneTitle= itemView.findViewById(R.id.title);
           //groupTitle = itemView.findViewById(R.id.groupTitle);
        }
    }
}
