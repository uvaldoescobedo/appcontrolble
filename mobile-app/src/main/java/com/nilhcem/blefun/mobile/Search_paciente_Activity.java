package com.nilhcem.blefun.mobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Search_paciente_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_paciente_);
    }

    public void onclic_to_formulario(View view) {
          Intent i = new Intent(Search_paciente_Activity.this, llenado_formulario.class);
        startActivity(i);

    }

    public void onclic_to_Back(View view) {
        this.onBackPressed();
    }
}