package com.nilhcem.blefun.mobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MenuPricipal extends AppCompatActivity {
    TextView btn_paciente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pricipal);
        btn_paciente = findViewById(R.id.txt_paciente);
        btn_paciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(),"Clic en paciente",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MenuPricipal.this,llenado_formulario.class);
                startActivity(i);
            }
        });
    }
}