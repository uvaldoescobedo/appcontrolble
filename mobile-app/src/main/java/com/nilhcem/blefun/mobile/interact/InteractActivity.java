package com.nilhcem.blefun.mobile.interact;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.nilhcem.blefun.mobile.R;  //---------ESTO PARA QUE ES?-------------
import com.nilhcem.blefun.mobile.SwtichActivity;

public class InteractActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_DEVICE_ADDRESS = "mAddress";

    private final GattClient mGattClient = new GattClient();
    private Button mButton;
    private LinearLayout scrollView;
    private TextView textViewError;
    ImageView bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt10, bt11, bt12, bt13, bt14, bt15, bt16, bt17, bt18;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interact_activity);

      //  mButton = findViewById(R.id.interact_button);
     //   mButton.setEnabled(false);
    /*   mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGattClient.writeInteractor();
            }
        });*/
        scrollView = findViewById(R.id.scroll);
        //     scrollView.getRootView().setVisibility(View.GONE);
        textViewError = findViewById(R.id.error);
        textViewError.getRootView().setVisibility(View.GONE);

        //declaraciones de los botones
        bt1 = findViewById(R.id.bt1); //unimos el boton dela vista con la logica
        bt1.setImageResource(R.drawable.respaldo_arriba);// le mandamos la imagen en jpg,png pero con nombre en minusculas
        bt1.setOnClickListener(this);//Accion de boton ala imagen

        bt2 = findViewById(R.id.bt2);
        bt2.setImageResource(R.drawable.segunda);
        bt2.setOnClickListener(this);

        bt3 = findViewById(R.id.bt3);
        bt3.setOnClickListener(this);

        bt4 = findViewById(R.id.bt4);
        bt4.setOnClickListener(this);

        bt5 = findViewById(R.id.bt5);
        bt5.setOnClickListener(this);

        bt6 = findViewById(R.id.bt6);
        bt6.setOnClickListener(this);

        bt7 = findViewById(R.id.bt7);
        bt7.setOnClickListener(this);

        bt8 = findViewById(R.id.bt8);
        bt8.setOnClickListener(this);

        bt9 = findViewById(R.id.bt9);
        bt9.setImageResource(R.drawable.respaldo_abajo);
        bt9.setOnClickListener(this);

        bt10 = findViewById(R.id.bt10);
        bt10.setOnClickListener(this);

        bt11 = findViewById(R.id.bt11);
        bt11.setOnClickListener(this);

        bt12 = findViewById(R.id.bt12);
        bt12.setOnClickListener(this);

        bt13 = findViewById(R.id.bt13);
        bt13.setOnClickListener(this);

        bt14 = findViewById(R.id.bt14);
        bt14.setOnClickListener(this);

        bt15 = findViewById(R.id.bt15);
        bt15.setOnClickListener(this);

        bt16 = findViewById(R.id.bt16);
        bt16.setOnClickListener(this);



      /*  String address = getIntent().getStringExtra(EXTRA_DEVICE_ADDRESS);
        mGattClient.onCreate(this, address, new GattClient.OnCounterReadListener() {
            @Override
            public void onCounterRead(final int value) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(InteractActivity.this, "Texto REcibido:"+Integer.toString(value), Toast.LENGTH_LONG).show();
                      //  mButton.setText("Texto REcibido:"+Integer.toString(value));
                    }
                });
            }

            @Override
            public void onConnected(final boolean success) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                      //  mButton.setEnabled(success);

                        if (!success) {
                            Toast.makeText(InteractActivity.this, "Connection error", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(InteractActivity.this, "Connection Sucess", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }

        });*/
    }
/*
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mGattClient.onDestroy();
    }*/

    @Override
    public void onClick(View v) {
        String address = getIntent().getStringExtra(EXTRA_DEVICE_ADDRESS);
        switch (v.getId()) {
            case R.id.bt1: {
                //accion del boton
                int imagen=R.drawable.ultra; //imagen del boton como png con el nombre en minusculas
                String nombre = "Boton1";
                String ON = "Accion ON";//lo que mandara a arduino en ON
                String OFF = "Accion OFF";//lo que mandara a arduino en OFF
                Intent intent = new Intent(this, SwtichActivity.class);
                intent.putExtra("nombre", nombre);
                intent.putExtra("imagen", imagen);
                intent.putExtra("ON", ON);
                intent.putExtra("OFF", OFF);
                intent.putExtra(InteractActivity.EXTRA_DEVICE_ADDRESS, address);
                startActivity(intent);
                break;
            }
            case R.id.bt2: {
                //accion del boton
              /* int imagen=R.drawable.example;
                String nombre = "Boton2";
                String ON="Accion ON";//lo que mandara a arduino en ON
                String OFF="Accion OFF";//lo que mandara a arduino en OFF
                Intent intent = new Intent(this, SwitchActivity.class);
                intent.putExtra("nombre", nombre);
                intent.putExtra("imagen", imagen);
                intent.putExtra("ON", ON);
                intent.putExtra("OFF", OFF);
                startActivity(intent);*/
                break;
            }
            case R.id.bt9: {
                //accion del boton
                int imagen=R.drawable.respaldo_abajo; //imagen del boton como png con el nombre en minusculas
                String nombre = "Boton9";
                String ON = "Accion ON";//lo que mandara a arduino en ON
                String OFF = "Accion OFF";//lo que mandara a arduino en OFF
                Intent intent = new Intent(this, SwtichActivity.class);
                intent.putExtra("nombre", nombre);
                intent.putExtra("imagen", imagen);
                intent.putExtra("ON", ON);
                intent.putExtra("OFF", OFF);
                intent.putExtra(InteractActivity.EXTRA_DEVICE_ADDRESS, address);
                startActivity(intent);
                break;
            }
            default:{
                Toast.makeText(InteractActivity.this,"Atinele Bien",Toast.LENGTH_LONG).show();
            }

        }
    }

}
