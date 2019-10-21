package asia.nainglintun.myintthidarcustomer.Fragments;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import asia.nainglintun.myintthidarcustomer.Activities.CustomerActivity;
import asia.nainglintun.myintthidarcustomer.Activities.MainActivity;
import asia.nainglintun.myintthidarcustomer.R;
import asia.nainglintun.myintthidarcustomer.models.ApiClient;
import asia.nainglintun.myintthidarcustomer.models.Customer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class CustomerRankFragment extends Fragment {

    private Bitmap bitmap;
    private ImageView customerQrCode, Profile;
    TextView Customername;
    private String Customer_Id, Customer_name, paths;
    private TextView textViewPoint, textViewPointEight, textViewKyat, textViewPal, textViewYae, textViewshowTotalPoint;
    private LinearLayout linearLayout;

    public CustomerRankFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_customer_rank, container, false);
        ((CustomerActivity) getActivity()).setTitle("Rank");
        Customername = view.findViewById(R.id.customerName);
        textViewPoint = view.findViewById(R.id.pointNumber);
        textViewPointEight = view.findViewById(R.id.pointEight);
        textViewKyat = view.findViewById(R.id.customerRemainKyat);
        textViewPal = view.findViewById(R.id.customerRemaiPal);
        textViewYae = view.findViewById(R.id.customerRemaiYae);
        textViewshowTotalPoint = view.findViewById(R.id.showTotalPoint);
        Profile = view.findViewById(R.id.profile_image);
        bitmap = BitmapFactory.decodeResource(getContext().getResources(),
                R.drawable.default_profile);
        Profile.setImageBitmap(bitmap);

        linearLayout = view.findViewById(R.id.totalPointLayout);
        Call<Customer> call = MainActivity.apiInterface.getCustomerInfo(MainActivity.prefConfig.readName());
        call.enqueue(new Callback<Customer>() {
            @Override
            public void onResponse(Call<Customer> call, Response<Customer> response) {
                Customer_Id = String.valueOf(response.body().getId());
                Customer_name = response.body().getName();
                paths = response.body().getProfile();
                String totalRemainKyat = response.body().getDebitKyat();
                String totalRemainPal = response.body().getDebitPal();
                String totalRemainYae = response.body().getDebitYae();
                String Status = response.body().getStatus();
                String totalPoint = response.body().getTotal_point();
                if (Status.equals("Yes")) {
                    linearLayout.setVisibility(View.VISIBLE);
                    textViewshowTotalPoint.setText(totalPoint);

                }
                textViewKyat.setText(totalRemainKyat);
                textViewPal.setText(totalRemainPal);
                textViewYae.setText(totalRemainYae);
                Customername.setText(Customer_name);
                getPoint(Customer_Id);
                Log.d("PATHS",paths);

                if (!paths.equals("No")) {
                    Glide.with(getContext()).load(ApiClient.BASE_URL + paths).apply(RequestOptions.skipMemoryCacheOf(true).diskCacheStrategy(DiskCacheStrategy.NONE)).into(Profile);
                }
            }

            @Override
            public void onFailure(Call<Customer> call, Throwable t) {

            }
        });

        String name = MainActivity.prefConfig.readName();
        customerQrCode = view.findViewById(R.id.custQrCode);
        bitmap = BitmapFactory.decodeResource(getContext().getResources(),
                R.drawable.qr_code);
        customerQrCode.setImageBitmap(bitmap);
        Glide.with(getContext()).load(ApiClient.BASE_URL + "uploads/" + name + ".jpg").into(customerQrCode);


        return view;
    }


    public void getPoint(String Id) {

        Call<Customer> customerCall = MainActivity.apiInterface.getTotalPoint(Customer_Id);
        customerCall.enqueue(new Callback<Customer>() {
            @Override
            public void onResponse(Call<Customer> call, Response<Customer> response) {
                String totalQualtity = response.body().getQualtity();
                String totalPointEight = response.body().getPointEight();
                textViewPoint.setText(totalQualtity);
                textViewPointEight.setText(totalPointEight);

            }

            @Override
            public void onFailure(Call<Customer> call, Throwable t) {

            }
        });
    }

}
