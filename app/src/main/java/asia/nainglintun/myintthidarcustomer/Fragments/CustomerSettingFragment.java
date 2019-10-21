package asia.nainglintun.myintthidarcustomer.Fragments;


import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import asia.nainglintun.myintthidarcustomer.Activities.CustomerActivity;
import asia.nainglintun.myintthidarcustomer.Activities.MainActivity;
import asia.nainglintun.myintthidarcustomer.R;
import asia.nainglintun.myintthidarcustomer.models.ApiClient;
import asia.nainglintun.myintthidarcustomer.models.Customer;
import asia.nainglintun.myintthidarcustomer.models.ImageClass;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class CustomerSettingFragment extends Fragment implements View.OnClickListener {

    private Button btnCustomerChangePassword, bnCustometLogout, BnChangeCode;
    private EditText edCode;
    private static CircleImageView customerProfile;
    private final int IMG_REQUEST = 1;
    private Bitmap bitmap;

    public static String Customer_Id, profile;

    private ProgressDialog progressDialog;

    public CustomerSettingFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_customer_setting, container, false);

        ((CustomerActivity) getActivity()).setTitle("Setting");
        String name = MainActivity.prefConfig.readName();
        btnCustomerChangePassword = view.findViewById(R.id.btnCustomerPasswordSave);
        bnCustometLogout = view.findViewById(R.id.btnCustomerLogout);
        customerProfile = view.findViewById(R.id.customerProfile);
        bitmap = BitmapFactory.decodeResource(getContext().getResources(),
                R.drawable.default_profile);
        customerProfile.setImageBitmap(bitmap);
        edCode = view.findViewById(R.id.changeCode);
        BnChangeCode = view.findViewById(R.id.btnChangeCode);
        progressDialog = new ProgressDialog(getContext());

        progressDialog.setMessage("Please Wait...");


        Call<Customer> call1 = MainActivity.apiInterface.getCustomerInfo(MainActivity.prefConfig.readName());
        call1.enqueue(new Callback<Customer>() {
            @Override
            public void onResponse(Call<Customer> call, Response<Customer> response) {
                Customer_Id = String.valueOf(response.body().getId());

                String paths = response.body().getProfile();
                if (paths.equals("No")) {
                    bitmap = BitmapFactory.decodeResource(getContext().getResources(),
                            R.drawable.default_profile);
                    customerProfile.setImageBitmap(bitmap);
                } else if (!paths.equals("No")) {
                    Glide.with(getContext()).load(ApiClient.BASE_URL + paths).apply(RequestOptions.skipMemoryCacheOf(true).diskCacheStrategy(DiskCacheStrategy.NONE)).into(customerProfile);

                }

            }

            @Override
            public void onFailure(Call<Customer> call, Throwable t) {

            }
        });

        customerProfile.setOnClickListener(this);
        btnCustomerChangePassword.setOnClickListener(this);
        bnCustometLogout.setOnClickListener(this);
        BnChangeCode.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCustomerPasswordSave:
                uploadImage();
                break;
            case R.id.customerProfile:
                selectSaleImage();
                break;
            case R.id.btnCustomerLogout:
                MainActivity.prefConfig.DeleteName(MainActivity.prefConfig.readName());
                startActivity(new Intent(getContext(), MainActivity.class));
                getActivity().finish();
                break;

            case R.id.btnChangeCode:
                String eddCode = edCode.getText().toString();
                Call<Customer> call = MainActivity.apiInterface.changePinCode(MainActivity.prefConfig.readName(), eddCode);
                call.enqueue(new Callback<Customer>() {
                    @Override
                    public void onResponse(Call<Customer> call, Response<Customer> response) {
                        if (response.body().getResponse().equals("ok")) {
                            Toast.makeText(getContext(), "Success Change Comfirm Code", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Customer> call, Throwable t) {
                        Toast.makeText(getContext(), "Fail Change Comfirm Code", Toast.LENGTH_LONG).show();

                    }
                });
                break;
        }
    }


    private void uploadImage() {
        progressDialog.show();
        String name = MainActivity.prefConfig.readName();
        Log.e("work", "update method is work");
        String path = imageToString();
        String user_name = MainActivity.prefConfig.readName();
        Call<ImageClass> call = MainActivity.apiInterface.UpdateCustomerProfile(user_name, path);
        call.enqueue(new Callback<ImageClass>() {
            @Override
            public void onResponse(Call<ImageClass> call, Response<ImageClass> response) {
                progressDialog.dismiss();
                ImageClass imageClass = response.body();

                Toast.makeText(getContext(), "Server Response:" + imageClass.getResponse(), Toast.LENGTH_SHORT).show();
                String result = response.body().getResponse();

                Toast.makeText(getContext(), result, Toast.LENGTH_SHORT).show();

            }


            @Override
            public void onFailure(Call<ImageClass> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getContext(), "Change Fail", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void selectSaleImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, IMG_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == IMG_REQUEST && resultCode == RESULT_OK && data != null) {
            Uri path = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), path);
                customerProfile.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
    private String imageToString() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] imgByte = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(imgByte, Base64.DEFAULT);
    }
}
