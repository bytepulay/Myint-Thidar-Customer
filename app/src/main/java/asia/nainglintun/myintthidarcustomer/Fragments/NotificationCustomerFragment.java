package asia.nainglintun.myintthidarcustomer.Fragments;


import android.app.Dialog;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import asia.nainglintun.myintthidarcustomer.Activities.CustomerActivity;
import asia.nainglintun.myintthidarcustomer.Activities.MainActivity;
import asia.nainglintun.myintthidarcustomer.Activities.RecyclerTouchListener;
import asia.nainglintun.myintthidarcustomer.Adapters.NotificationGroupRecyclerAdapter;
import asia.nainglintun.myintthidarcustomer.Adapters.NotificationRecyclerAdapter;
import asia.nainglintun.myintthidarcustomer.Adapters.bindvouchersaleRecyclerAdapter;
import asia.nainglintun.myintthidarcustomer.Adapters.editbindvouchersaleRecyclerAdapter;
import asia.nainglintun.myintthidarcustomer.R;
import asia.nainglintun.myintthidarcustomer.models.Customer;
import asia.nainglintun.myintthidarcustomer.models.Notification;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationCustomerFragment extends Fragment {

    private Toolbar toolbar;
    private RecyclerView recyclerView, recyclerViewDialog, recyclerViewGroup;
    private RecyclerView.LayoutManager layoutManager, layoutManagerGroup;
    private List<Notification> salehistories, notifications;
    private NotificationRecyclerAdapter adapter;
    private NotificationGroupRecyclerAdapter notiAdapter;
    private bindvouchersaleRecyclerAdapter adapterDialog;
    private editbindvouchersaleRecyclerAdapter adapterEditDialog;
    private ProgressDialog progressDialog;
    public static TextView textDialog, bindName;
    private Dialog dialog;
    private ImageView closeImg;
    private ImageButton btnEdit;
    private String Customer_Id, profile;
    private TextView notiOneTitle, notiOneDescription;

    private ArrayList<String> dataList;
    private ArrayList<String> nameList;

    private LinearLayout linearLayoutUpdate, linearLayoutNotiOne;
    public static String city;

    public NotificationCustomerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_notification_customer, container, false);
        ((CustomerActivity) getActivity()).setTitle("Notification");

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerViewGroup = view.findViewById(R.id.recyclerViewGroup);
        layoutManager = new LinearLayoutManager(getContext());
        layoutManagerGroup = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerViewGroup.setLayoutManager(layoutManagerGroup);
        recyclerView.setHasFixedSize(true);
        recyclerViewGroup.setHasFixedSize(true);


        textDialog = view.findViewById(R.id.dialogText);

        dialog = new Dialog(getContext());
        progressDialog = new ProgressDialog(getContext());


        progressDialog.setMessage("Please Wait...");

        Call<Customer> call = MainActivity.apiInterface.getCustomerInfo(MainActivity.prefConfig.readName());
        call.enqueue(new Callback<Customer>() {
            @Override
            public void onResponse(Call<Customer> call, Response<Customer> response) {
                Customer_Id = String.valueOf(response.body().getId());
                profile = response.body().getProfile();
                city = response.body().getTown();

                fetchInformation(Customer_Id);


            }

            @Override
            public void onFailure(Call<Customer> call, Throwable t) {
                Toast.makeText(getContext(), "fail", Toast.LENGTH_SHORT).show();

            }
        });

        fetchNotificationGroup();



        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                String noti_one_title, noti_one_description;

                noti_one_title = salehistories.get(position).getTitle_one();
                noti_one_description = salehistories.get(position).getNoti_one();

                Showpopup(noti_one_title, noti_one_description);


            }

            @Override
            public void onLongClick(View view, int position) {


            }
        }));


        recyclerViewGroup.addOnItemTouchListener(new RecyclerTouchListener(getContext(), recyclerViewGroup, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                String noti_one_title, noti_one_description;

                noti_one_title = notifications.get(position).getTitle_group();
                noti_one_description = notifications.get(position).getNoti_group();

                Showpopup(noti_one_title, noti_one_description);


            }

            @Override
            public void onLongClick(View view, int position) {


            }
        }));


        return view;
    }


    private void Showpopup(String noti_one_title, String noti_one_description) {

        dialog.setContentView(R.layout.custom_noti_one_popup_dialog);
        notiOneTitle = dialog.findViewById(R.id.notiOneDetialTitle);
        notiOneDescription = dialog.findViewById(R.id.notiOneDescription);
        notiOneTitle.setText(noti_one_title);
        notiOneDescription.setText(noti_one_description);


        closeImg = dialog.findViewById(R.id.closeImage);
        closeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();


    }


    private void ShowpopupGroup(String noti_group_title, String noti_group_description) {

        dialog.setContentView(R.layout.custom_noti_group_popup_dialog);
        notiOneTitle = dialog.findViewById(R.id.notiOneDetialTitle);
        notiOneDescription = dialog.findViewById(R.id.notiOneDescription);
        notiOneTitle.setText(noti_group_title);
        notiOneDescription.setText(noti_group_description);


        closeImg = dialog.findViewById(R.id.closeImage);
        closeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();


    }


    public void fetchInformation(String Id) {
        progressDialog.setTitle("Loading Data....");
        progressDialog.show();

        Call<List<Notification>> call = MainActivity.apiInterface.readNotification(Id);
        call.enqueue(new Callback<List<Notification>>() {
            @Override
            public void onResponse(Call<List<Notification>> call, Response<List<Notification>> response) {
                progressDialog.dismiss();
                salehistories = response.body();

                adapter = new NotificationRecyclerAdapter(salehistories, getContext());
                recyclerView.setAdapter(adapter);


            }

            @Override
            public void onFailure(Call<List<Notification>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getContext(), "Notification Not Found", Toast.LENGTH_SHORT).show();
            }
        });
    }



    public void fetchNotificationGroup() {
        Call<List<Notification>> notificationCall = MainActivity.apiInterface.readGroupNotification(city);
        notificationCall.enqueue(new Callback<List<Notification>>() {
            @Override
            public void onResponse(Call<List<Notification>> call, Response<List<Notification>> response) {
                notifications = response.body();
                String group = response.body().get(0).getTitle_group();
                notiAdapter = new NotificationGroupRecyclerAdapter(notifications, getContext());
                recyclerViewGroup.setAdapter(notiAdapter);
            }

            @Override
            public void onFailure(Call<List<Notification>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getContext(), "Notification Not Found", Toast.LENGTH_SHORT).show();
            }
        });

    }

}



