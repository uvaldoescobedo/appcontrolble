package com.nilhcem.blefun.mobile;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ebanx.swipebtn.OnStateChangeListener;
import com.ebanx.swipebtn.SwipeButton;
import com.nilhcem.blefun.mobile.interact.GattClient;
import com.nilhcem.blefun.mobile.interact.InteractActivity;

import java.nio.file.Files;

public class SwtichActivity extends AppCompatActivity {
    public static final String EXTRA_DEVICE_ADDRESS = "mAddress";

    private final GattClient mGattClient = new GattClient();
    private TextView textView;
    private ImageView imageView;
    private FloatingActionButton fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swtich);

        String nombre = getIntent().getStringExtra("nombre");
        final String ON=getIntent().getStringExtra("ON");
        final String OFF=getIntent().getStringExtra("OFF");

        textView = findViewById(R.id.texto);
        textView.setText(nombre);
        imageView = findViewById(R.id.fondo);
        fb = findViewById(R.id.floatingActionButton3);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        String address = getIntent().getStringExtra(EXTRA_DEVICE_ADDRESS);
        mGattClient.onCreate(this, address, new GattClient.OnCounterReadListener() {
            @Override
            public void onCounterRead(final String value) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //aqui en la varable value se trae los datos desde arduino
                        Toast.makeText(SwtichActivity.this, "Texto REcibido:"+value, Toast.LENGTH_LONG).show();
                        //  mButton.setText("Texto REcibido:"+Integer.toString(value));
                    }
                });
            }

            @Override
            public void onSignalReadRssi(final String value) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(SwtichActivity.this, "Señal:" + value, Toast.LENGTH_LONG).show();
                        if(Math.abs(Integer.parseInt(value))>55){
                            AlertDialog.Builder builder = new AlertDialog.Builder(SwtichActivity.this);
                            builder.setTitle("ALERTA DE SEÑAL");
                            builder.setMessage("Acercar Mas al Dispositivo");
                            builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //metemos lo que hace cuando se le da clic en aceptar
                                    onBackPressed();
                                }
                            });
                            AlertDialog dialog = builder.create();
                            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                @Override
                                public void onDismiss(DialogInterface dialog) {
                                    //metemos lo que hara si da clic fuera del dialogo
                                    onBackPressed();
                                }
                            });
                            dialog.show();
                        }
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
                            Toast.makeText(SwtichActivity.this, "Connection error", Toast.LENGTH_LONG).show();
                        }else{

                            Toast.makeText(SwtichActivity.this, "Connection Sucess", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }

        });
        SwipeButton enableButton = (SwipeButton) findViewById(R.id.switchs);
        enableButton.setOnStateChangeListener(new OnStateChangeListener() {
            @Override
            public void onStateChange(boolean active) {
                if(active){
                    Toast.makeText(SwtichActivity.this, "State: " + ON, Toast.LENGTH_SHORT).show();
                    mGattClient.writeInteractor("ON");
                }else{
                    Toast.makeText(SwtichActivity.this, "State: " + OFF, Toast.LENGTH_SHORT).show();
                    mGattClient.writeInteractor("OFF");
                }

            }
        });

        enableButton.setOnStateChangeListener(new OnStateChangeListener() {
            @Override
            public void onStateChange(boolean active) {
                if(mesarriba){
                    mGattClient.writeInteractor("Mesa->abajo");
                    mesarriba=false;
                }else{
                    mGattClient.writeInteractor("Mesa->Arriba");
                    mesarriba = true;
                }
                Toast.makeText(SwtichActivity.this, "Se esta dezlizando", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private Boolean mesarriba = false;
    @Override
    protected void onDestroy() {
        Toast.makeText(this,"Se Destruyo",Toast.LENGTH_SHORT).show();
        super.onDestroy();
        mGattClient.onDestroy();
    }

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

}
