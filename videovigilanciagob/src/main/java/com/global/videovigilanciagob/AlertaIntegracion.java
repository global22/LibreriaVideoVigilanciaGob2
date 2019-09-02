package com.global.videovigilanciagob;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class AlertaIntegracion extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alerta_integracion);
        AlertDialog alertDialog = AlertaInstall();
        alertDialog.show();
    }

    private AlertDialog AlertaInstall(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder
                .setTitle("Inicie videovigilancia gob.")
                .setMessage("Puede instalar el modulo de Videovigilancia gob compatible con Claro360.")
                .setNegativeButton("Instalar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        LanzaDescarga();
                    }
                })
                .setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        finish();
                    }
                });
        return builder.create();
    }

    private void LanzaDescarga() {
        String urlDescarga = getResources().getString(R.string.URL_VIDEOPLAY);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlDescarga));
        startActivity(intent);
    }
}
