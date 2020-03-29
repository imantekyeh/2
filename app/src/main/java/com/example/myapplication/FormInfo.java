package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class FormInfo implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private Activity activity;
    private LinearLayout layout;
    private EditText inputname, inputphone, inputemaile;
    private Button btn_click;
    private CheckBox cb_chek;


    public FormInfo(Activity activity, int layoutId) {
        this.activity = activity;
        this.layout = activity.findViewById(layoutId);
        this.activity = activity;
        inti();
    }

    private void inti() {
        if (layout == null) {
            return;
        }
        inputname = layout.findViewById(R.id.edt_name);
        inputemaile = layout.findViewById(R.id.edt_email);
        inputphone = layout.findViewById(R.id.edt_phone);
        btn_click = layout.findViewById(R.id.btn_input);
        cb_chek = layout.findViewById(R.id.checkBox);
        btn_click.setOnClickListener(this);
        cb_chek.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == btn_click.getId()) {
            String name = inputname.getText().toString().trim();
            String phone = inputphone.getText().toString().trim();
            String maile = inputemaile.getText().toString().trim();
            if (isValidInput(name, phone, maile)) {

                Intent intent = new Intent(activity, SecendActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("phone",phone);
                intent.putExtra("maile",maile);
                activity.startActivity(intent);
            }
        }
    }

    private boolean isValidInput(String name, String phone, String maile) {
        if (name.length() < 3) {
            inputname.requestFocus();
            Toast.makeText(activity, "نام کمتر از سه حرف نباشد", Toast.LENGTH_LONG).show();
            return false;
        }
        if (!phone.isEmpty() && (phone.length() != 11) || !phone.startsWith("09")) {
            Toast.makeText(activity, "شماره اشتباه وارد کردین", Toast.LENGTH_LONG).show();
            inputname.requestFocus();
            return false;
        }
        if (maile.lastIndexOf('@') <= 0 || !maile.contains(".") || maile.lastIndexOf('.') < maile.lastIndexOf('@')
                || maile.split("@").length > 2) {
            Toast.makeText(activity, "ایمیل اشتباه", Toast.LENGTH_SHORT).show();
            inputemaile.requestFocus();
            return false;
        }
        return true;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (buttonView.getId() == cb_chek.getId()) {
            inputphone.setEnabled(isChecked);

        }
    }
}
