package com.example.roman.qr;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

import static android.Manifest.permission.CAMERA;

public class MainActivity extends AppCompatActivity {

    private Button btnScan;
    private Button btnGenerate;
    private TextView textView;
    public static final int CHOOSE_ADDRESS_FROM_QR = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnScan = (Button) findViewById(R.id.btn_scan);
        btnGenerate = (Button) findViewById(R.id.btn_generate);
        textView = (TextView) findViewById(R.id.textScan);

        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, QRReadActivity.class);
                startActivityForResult(intent, CHOOSE_ADDRESS_FROM_QR);
            }
        });
        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, QRGeneratorActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == CHOOSE_ADDRESS_FROM_QR) {
            if (resultCode == RESULT_OK) {
                textView.setText(data.getStringExtra(QRReadActivity.ADDRESS));
            }else {
                textView.setText("");
            }
        }
    }
}
















