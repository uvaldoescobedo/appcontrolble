package com.nilhcem.blefun.mobile;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class llenado_formulario extends AppCompatActivity {
    Button registrar;
    Spinner sexo;
    String[] sexos = {"Selecciona Sexo","Hombre", "Mujer"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llenado_formulario);
        getSupportActionBar().setTitle("FORMULARIO");
        registrar = findViewById(R.id.btn_registrar);
        sexo = findViewById(R.id.sexo);
        sexo.setAdapter(new ArrayAdapter<String>(llenado_formulario.this, android.R.layout.simple_spinner_dropdown_item,sexos ));

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(llenado_formulario.this,confirmar_formulario.class);
                startActivity(i);
            }
        });

        sexo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),sexo.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                if(sexo.getSelectedItem().toString().equals(sexos[1])){
                        sexo.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.color.color_men));
                }else if(sexo.getSelectedItem().toString().equals(sexos[2])){
                    sexo.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.color.color_woman));
                }else{
                    sexo.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.color.alert_color));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}