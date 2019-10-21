package asia.nainglintun.myintthidarcustomer.Fragments;


import android.app.Dialog;
import android.app.ProgressDialog;
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
import android.widget.Toolbar;

import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import asia.nainglintun.myintthidarcustomer.Activities.CustomerActivity;
import asia.nainglintun.myintthidarcustomer.Activities.MainActivity;
import asia.nainglintun.myintthidarcustomer.Adapters.CustomerOrderRecyclerAdapter;
import asia.nainglintun.myintthidarcustomer.Adapters.bindvouchersaleRecyclerAdapter;
import asia.nainglintun.myintthidarcustomer.Adapters.editbindvouchersaleRecyclerAdapter;
import asia.nainglintun.myintthidarcustomer.R;
import asia.nainglintun.myintthidarcustomer.models.Orderhistory;
import asia.nainglintun.myintthidarcustomer.models.Salehistory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * SearchView.OnQueryTextListener
 * A simple {@link Fragment} subclass.
 */
public class OrderCustomerFragment extends Fragment implements SearchView.OnQueryTextListener {

    private Toolbar toolbar;
    private TextView purchaseDate, cuponCode, purchaseItem, gram;
    private RecyclerView recyclerView, recyclerViewDialog, recyclerViewEdit;
    private RecyclerView.LayoutManager layoutManager;
    private List<Orderhistory> salehistories;
    private CustomerOrderRecyclerAdapter adapter;
    private bindvouchersaleRecyclerAdapter adapterDialog;
    private editbindvouchersaleRecyclerAdapter adapterEditDialog;
    private ProgressDialog progressDialog;
    public static TextView textDialog, bindName;
    private Dialog dialog;
    private ImageView closeImg;
    private ImageButton btnEdit;


    private LinearLayout linearLayoutUpdate;

    public OrderCustomerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_history_customer, container, false);
        ((CustomerActivity) getActivity()).setTitle("Purchase Order List");

        setHasOptionsMenu(true);
        recyclerView = view.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);


        textDialog = view.findViewById(R.id.dialogText);

        dialog = new Dialog(getContext());
        progressDialog = new ProgressDialog(getContext());


        progressDialog.setMessage("Please Wait...");

        fetchInformation(MainActivity.prefConfig.readName());


        return view;
    }


    public void fetchInformation(String type) {
        progressDialog.setTitle("Loading Data....");
        progressDialog.show();

        Call<List<Orderhistory>> call = MainActivity.apiInterface.getOrderHistoryInfo(type);
        call.enqueue(new Callback<List<Orderhistory>>() {
            @Override
            public void onResponse(Call<List<Orderhistory>> call, Response<List<Orderhistory>> response) {
                progressDialog.dismiss();
                salehistories = response.body();

                adapter = new CustomerOrderRecyclerAdapter(salehistories, getContext());
                recyclerView.setAdapter(adapter);


            }

            @Override
            public void onFailure(Call<List<Orderhistory>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getContext(), "Purchase Order Not Found", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_items, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText = newText.toLowerCase();
        ArrayList<Orderhistory> newList = new ArrayList<>();

        for (Orderhistory orderhistory : salehistories) {
            String sDate = orderhistory.getOrderDate().toLowerCase();
            String shopName = orderhistory.getCustomerShop().toLowerCase();
            String town = orderhistory.getCustomerTwon().toLowerCase();
            if (sDate.contains(newText)) {
                newList.add(orderhistory);
            }
        }

        adapter.setFilter(newList);

        return true;

    }


}
