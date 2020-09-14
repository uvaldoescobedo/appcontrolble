package com.nilhcem.blefun.mobile;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.nilhcem.blefun.mobile.interact.InteractActivity;
import com.nilhcem.blefun.mobile.interact.InteractActivity2;
import com.nilhcem.blefun.mobile.scan.ScanActivity;

public class Seleccion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion);
    }

    public void botonUno(View view) {
        Intent intent = new Intent(Seleccion.this, ScanActivity.class);
        intent.putExtra("clase","1");
        startActivity(intent);
    }

    public void botonDos(View view) {
        Intent intent = new Intent(Seleccion.this, ScanActivity.class);
        intent.putExtra("clase", "2");
        startActivity(intent);
    }

/*
    // Los metodos siguientes son para medir cuanto tiempo pasa sin actividad
    public static final long DISCONNECT_TIMEOUT = 30000;
    private static Handler disconnectHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            // todo
            return true;
        }
    });
    private Runnable disconnectCallback = new Runnable() {
        @Override
        public void run() {
          // Ponemos la accionque hace tras esperar 30s sin interaccion
            finish();
        }
    };

    public void resetDisconnectTimer(){
        disconnectHandler.removeCallbacks(disconnectCallback);
        disconnectHandler.postDelayed(disconnectCallback, DISCONNECT_TIMEOUT);
    }

    public void stopDisconnectTimer(){
        disconnectHandler.removeCallbacks(disconnectCallback);
    }

    @Override
    public void onUserInteraction(){
        resetDisconnectTimer();
    }

    @Override
    public void onResume() {
        Toast.makeText(this,"Se Regreso",Toast.LENGTH_SHORT).show();
        super.onResume();
        resetDisconnectTimer();
    }

    @Override
    public void onStop() {
        Toast.makeText(this,"Se Stopeo",Toast.LENGTH_SHORT).show();
        super.onStop();
        stopDisconnectTimer();
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(this,"Se Destruyo",Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }*/
}
