package com.nilhcem.blefun.mobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class confirmar_formulario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario_con_datos);
        getSupportActionBar().setTitle("CONFIRMAR FORMULARIO");
    }

    public void onclic_back(View view) {
        onBackPressed();
    }

    public void click_to_info_paciente(View view) {
        Intent i = new Intent(confirmar_formulario.this, info_paciente_Activity.class);
        startActivity(i);
    }
}