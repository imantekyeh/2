package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    public static final int REQ_CODE = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final FormInfo form = new FormInfo(this, R.id.laout_form_info);
        form.getBtn_click().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = form.getInputname().getText().toString().trim();
                String phone = form.getInputphone().getText().toString().trim();
                String mail = form.getInputemaile().getText().toString().trim();
                if (form.isValidInput(name, phone, mail)) {
                    Intent intent = new Intent(MainActivity.this, SecendActivity.class);
                    intent.putExtra("name", name);
                    intent.putExtra("mail", mail);
                    if (form.getCb_chek().isChecked()) {
                        intent.putExtra("phone", phone);
                    }
                    startActivityForResult(intent, REQ_CODE);
                }
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode==REQ_CODE && resultCode==RESULT_OK){
            Toast.makeText(this, "confirm", Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}
