package com.example.permissionx;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.permissionx.guolindeV.PermissionCallback;
import com.permissionx.guolindeV.PermissionX;

public class MainActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PermissionX permissionX = PermissionX.getInstance();
                permissionX.request(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}
                        , new PermissionCallback() {
                            @Override
                            public void afterCallback() {
                                if (allGranded){
                                    Intent intent = new Intent(Intent.ACTION_CALL);
                                    intent.setData(Uri.parse("tel:10086"));
                                    startActivity(intent);
                                }else {
                                    Toast.makeText(MainActivity.this, deniedList.toString(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }
        });
    }
}