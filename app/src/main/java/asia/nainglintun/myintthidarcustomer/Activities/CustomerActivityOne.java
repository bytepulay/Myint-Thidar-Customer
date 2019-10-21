package asia.nainglintun.myintthidarcustomer.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import asia.nainglintun.myintthidarcustomer.R;

public class CustomerActivityOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_one);
        Log.d("Test","intent success ");
    }
}
