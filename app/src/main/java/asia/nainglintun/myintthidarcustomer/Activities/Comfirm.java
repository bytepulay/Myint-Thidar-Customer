package asia.nainglintun.myintthidarcustomer.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import asia.nainglintun.myintthidarcustomer.R;
import asia.nainglintun.myintthidarcustomer.models.Customer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static asia.nainglintun.myintthidarcustomer.Activities.MainActivity.prefConfig;

public class Comfirm extends AppCompatActivity {
    private Button bnComfirm;
    private EditText edComfirm;
    public String comfirmCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comfirm);

        final String text = getIntent().getStringExtra("uname");
        edComfirm = findViewById(R.id.editComfirm);
        bnComfirm = findViewById(R.id.btnComfirm);

            bnComfirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    comfirmCode = edComfirm.getText().toString();
                Call<Customer> call = MainActivity.apiInterface.performUserLogin(text);
                call.enqueue(new Callback<Customer>() {
                    @Override
                    public void onResponse(Call<Customer> call, Response<Customer> response) {
                        if (response.body().getResponse().equals("customer")) {
                            String name = response.body().getUserName();
                            String rowUser = response.body().getResponse();
                            String password = response.body().getPassword();
                            prefConfig.writeRowUser(rowUser);
                            prefConfig.writeName(name);
                            if (password.equals(comfirmCode)) {
                                startActivity(new Intent(Comfirm.this, CustomerActivity.class));
                                finish();
                            } else if (!password.equals(comfirmCode)) {
                                startActivity(new Intent(Comfirm.this, MainActivity.class));
                                finish();
                            }
                        } else if (response.body().getResponse().equals("new")) {
                            Toast.makeText(Comfirm.this, "please register", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Customer> call, Throwable t) {
                      Log.d("TEST","fail no data ");
                    }
               });

                }
            });


    }
}
