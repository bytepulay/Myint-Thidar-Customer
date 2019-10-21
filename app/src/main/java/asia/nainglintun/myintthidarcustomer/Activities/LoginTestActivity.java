package asia.nainglintun.myintthidarcustomer.Activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class LoginTestActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    TextView textViewName;
    private static final int REQUEST_CAMERA = 1;


    ZXingScannerView zXingScannerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        zXingScannerView = new ZXingScannerView(this);
        setContentView(zXingScannerView);
        checkPermission();

    }

    @Override
    public void handleResult(Result rawResult) {
    Intent intent  = new Intent(LoginTestActivity.this,Comfirm.class);
    intent.putExtra("uname",rawResult.getText());
    startActivity(intent);
    
    finish();

    }

    @Override
    protected void onPause() {
        super.onPause();
        zXingScannerView.stopCamera();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    private static final int MY_CAMERA_PERMISSION = 1;


    private void checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (this.checkCallingOrSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                this.requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_CAMERA_PERMISSION);
            }else{
                zXingScannerView.startCamera();
                zXingScannerView.setResultHandler(this);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == MY_CAMERA_PERMISSION) {
            boolean flag = (grantResults[0] == PackageManager.PERMISSION_GRANTED) && grantResults.length != 0;

            if (!flag) {
                Toast.makeText(this, "No Camera permission", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                zXingScannerView.startCamera();
                zXingScannerView.setResultHandler(this);
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

}