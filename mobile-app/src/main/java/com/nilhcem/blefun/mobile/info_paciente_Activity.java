package com.nilhcem.blefun.mobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class info_paciente_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_paciente_);
    }

    public void onclic_back(View view) {
        onBackPressed();
    }

    public void click_to_add_paciente(View view) {
    }
}