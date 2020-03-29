package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SecendActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secend);
        Bundle extras = getIntent().getExtras();
        TextView tv_view = findViewById(R.id.tv_secend);

        if (extras != null) {
            String name = "";
            String phone = "";
            String mail = "";
            if (extras.containsKey("name")) {
                name = extras.getString("name");
            }
            if (extras.containsKey("phone")) {
                phone = extras.getString("phone");
            }
            if (extras.containsKey("mail")) {
                mail = extras.getString("mail");
            }
            tv_view.setText("name :" + name + "\n");
            tv_view.append("phone :" + phone + "\n");
            tv_view.append("mail :" + mail+"\n");
        }
    }

}