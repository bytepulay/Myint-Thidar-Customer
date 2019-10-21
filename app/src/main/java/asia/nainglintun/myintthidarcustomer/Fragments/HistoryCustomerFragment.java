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
import asia.nainglintun.myintthidarcustomer.Adapters.CustomerPurchaseRecyclerAdapter;
import asia.nainglintun.myintthidarcustomer.Adapters.bindvouchersaleRecyclerAdapter;
import asia.nainglintun.myintthidarcustomer.Adapters.editbindvouchersaleRecyclerAdapter;
import asia.nainglintun.myintthidarcustomer.R;
import asia.nainglintun.myintthidarcustomer.models.Salehistory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryCustomerFragment extends Fragment implements SearchView.OnQueryTextListener {

private Toolbar toolbar;
private TextView purchaseDate,cuponCode,purchaseItem,gram;
    private RecyclerView recyclerView,recyclerViewDialog,recyclerViewEdit;
    private RecyclerView.LayoutManager layoutManager;
    private List<Salehistory> salehistories;
    private CustomerPurchaseRecyclerAdapter adapter;
    private bindvouchersaleRecyclerAdapter adapterDialog;
    private editbindvouchersaleRecyclerAdapter adapterEditDialog;
    private ProgressDialog progressDialog;
    public static TextView textDialog,bindName;
    private Dialog dialog;
    private ImageView closeImg;
   private ImageButton btnEdit;



    private LinearLayout linearLayoutUpdate;

    public HistoryCustomerFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history_customer, container, false);
        ((CustomerActivity)getActivity()).setTitle("Purchase History List");
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



    public void fetchInformation(String type){
        progressDialog.setTitle("Loading Data....");
        progressDialog.show();

        Call<List<Salehistory>> call = MainActivity.apiInterface.getSaleHistoryInfo(type);
        call.enqueue(new Callback<List<Salehistory>>() {
            @Override
            public void onResponse(Call<List<Salehistory>> call, Response<List<Salehistory>> response) {
                progressDialog.dismiss();
                salehistories = response.body();

                adapter = new CustomerPurchaseRecyclerAdapter(salehistories,getContext());
                recyclerView.setAdapter(adapter);


            }

            @Override
            public void onFailure(Call<List<Salehistory>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getContext(), "Purchase History Not Found", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_items,menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this);
    }


    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {

        s = s.toLowerCase();
        ArrayList<Salehistory> newList = new ArrayList<>();

        for (Salehistory salehistory : salehistories)
        {
            String sDate = salehistory.getSaleDate().toLowerCase();
            if (sDate.contains(s)){
                newList.add(salehistory);
            }
        }

        adapter.setFilter(newList);

        return true;


    }
}
