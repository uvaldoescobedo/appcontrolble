package com.nilhcem.blefun.mobile;

import android.app.Dialog;
import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.nilhcem.blefun.mobile.scan.ScanActivity;

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
              //  Intent i = new Intent(MenuPricipal.this, llenado_formulario.class);
                Intent i = new Intent(MenuPricipal.this, Search_paciente_Activity.class);
                startActivity(i);
            }
        });
    }

    public void Click_btn_musica(View view) {
        //dialogo personalizado
        final Dialog dialogPersonalizado = new Dialog(MenuPricipal.this);
        dialogPersonalizado.setContentView(R.layout.musica_dialog);
        // Podemos obtener los elementos dentro del layout ;)
        TextView btn_spotify = dialogPersonalizado.findViewById(R.id.btn_spotify);
        TextView btn_youtube = dialogPersonalizado.findViewById(R.id.btn_youtube);
        btn_spotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogPersonalizado.dismiss();
                openSpotify();
            }
        });
        btn_youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 openYoutube();
                dialogPersonalizado.dismiss();
            }
        });

        // Después mostrarla:
        dialogPersonalizado.show();
    }

    private void openYoutube(){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/")));
    }
    
    private void openSpotify(){
        final Intent intent1 = new Intent(MediaStore.INTENT_ACTION_MEDIA_PLAY_FROM_SEARCH);
        intent1.setComponent(new ComponentName("com.spotify.music", "com.spotify.music.MainActivity"));
        intent1.putExtra(MediaStore.EXTRA_MEDIA_FOCUS, "vnd.android.cursor.item/*");
        intent1.putExtra(SearchManager.QUERY, "");
        intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (intent1.resolveActivity(getPackageManager()) != null) {
            startActivity(intent1);
        }
    }

    public void Click_btn_muesa(View view) {
        Intent i = new Intent(MenuPricipal.this, ScanActivity.class);
        startActivity(i);
    }

    public void Click_btn_Lampara(View view) {
        Intent i = new Intent(MenuPricipal.this, ScanActivity.class);
        startActivity(i);
    }

    public void Clic_enDicom(View view) {
        //dialogo personalizado
        final Dialog dialogPersonalizado = new Dialog(MenuPricipal.this);
        dialogPersonalizado.setContentView(R.layout.dicom_dialog);
        // Podemos obtener los elementos dentro del layout ;)
        ConstraintLayout btn_leadTools = dialogPersonalizado.findViewById(R.id.btn_leadTools);
        ConstraintLayout btn_droidRender = dialogPersonalizado.findViewById(R.id.btn_droidRender);
        btn_leadTools.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogPersonalizado.dismiss();
                openleadTools();

            }
        });
        btn_droidRender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogPersonalizado.dismiss();
                openDroidRender();
            }
        });

        // Después mostrarla:
        dialogPersonalizado.show();
    }

    private void openleadTools() {
        //leadtools.datasetdemo
        try{
            startActivity(getPackageManager().getLaunchIntentForPackage("leadtools.datasetdemo"));
        } catch (Exception e) {
            startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://play.google.com/store/apps/details?id=" + "leadtools.datasetdemo")));
        }
    }

    private void openDroidRender() {
        //com.luolai.droidrender
        try{
            startActivity(getPackageManager().getLaunchIntentForPackage("com.luolai.droidrender"));
        } catch (Exception e) {
            startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://play.google.com/store/apps/details?id=" + "com.luolai.droidrender")));
        }

    }

    public void Click_btn_luz(View view) {
        //com.tuya.smartlife
        try{
            startActivity(getPackageManager().getLaunchIntentForPackage("com.tuya.smartlife"));
        } catch (Exception e) {
            startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://play.google.com/store/apps/details?id=" + "com.tuya.smartlife")));
        }
    }
}