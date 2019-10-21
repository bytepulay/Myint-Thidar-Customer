package asia.nainglintun.myintthidarcustomer.Activities;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import asia.nainglintun.myintthidarcustomer.Fragments.CustomerRankFragment;
import asia.nainglintun.myintthidarcustomer.Fragments.CustomerSettingFragment;
import asia.nainglintun.myintthidarcustomer.Fragments.HistoryCustomerFragment;
import asia.nainglintun.myintthidarcustomer.Fragments.NotificationCustomerFragment;
import asia.nainglintun.myintthidarcustomer.Fragments.OrderCustomerFragment;
import asia.nainglintun.myintthidarcustomer.R;

public class CustomerActivity extends AppCompatActivity {
    private TextView mTextMessage;
    public static FragmentManager fragmentManager;
    //private ActionBar actionBar;
    private Toolbar toolbar;
    BottomNavigationView navView;





    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragmentManager.beginTransaction().replace(R.id.frame_layout_customer, new CustomerRankFragment()).commit();
                    toolbar.setTitle("Rank");
                    return true;
                case R.id.navigation_dashboard:
                    fragmentManager.beginTransaction().replace(R.id.frame_layout_customer,new HistoryCustomerFragment()).commit();
                    toolbar.setTitle("History");

                    return true;

                case R.id.navigation_order:
                    fragmentManager.beginTransaction().replace(R.id.frame_layout_customer,new OrderCustomerFragment()).commit();
                    toolbar.setTitle("order");

                    return true;
                case R.id.navigation_notifications:
                    fragmentManager.beginTransaction().replace(R.id.frame_layout_customer,new NotificationCustomerFragment()).commit();
                    toolbar.setTitle("Notification");

                    return true;
                case R.id.navigation_setting:
                    fragmentManager.beginTransaction().replace(R.id.frame_layout_customer,new CustomerSettingFragment()).commit();
                    //fragmentManager.beginTransaction().replace(R.id.frame_layout_customer,new NotificationGroupCustomerFragment()).commit();

                    toolbar.setTitle("Setting");
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Rank");

        fragmentManager = getSupportFragmentManager();



        if(findViewById(R.id.frame_layout_customer)!=null)
        {
            if(savedInstanceState!=null)
            {
                return;
            }
            fragmentManager.beginTransaction().add(R.id.frame_layout_customer,new CustomerRankFragment()).commit();
        }

        navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        //onBackPressed();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_items,menu);
//        return true;
//    }

    @Override
    public void onBackPressed() {
        BottomNavigationView mBottomNavigationView = findViewById(R.id.nav_view);
        if (mBottomNavigationView.getSelectedItemId() == R.id.navigation_home)
        {
            super.onBackPressed();
            finish();
        }
        else
        {
            mBottomNavigationView.setSelectedItemId(R.id.navigation_home);
            finish();
        }
    }
}