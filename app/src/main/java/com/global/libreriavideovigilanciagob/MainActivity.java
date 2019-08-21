package com.global.libreriavideovigilanciagob;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.global.videovigilanciagob.LaunchVideovigilancia;

public class MainActivity extends AppCompatActivity {

    private LaunchVideovigilancia launchVideovigilancia;
    private Button btnIntegracion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        launchVideovigilancia = new LaunchVideovigilancia();
        btnIntegracion = (Button)findViewById(R.id.btnIntegracion);

        AlertDialog alertDialog = AlertaIntegracion();
        alertDialog.show();

        btnIntegracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean statusIntegracion = launchVideovigilancia.StartVigilancia(getApplicationContext());
                Log.e("Integracion",  ""+statusIntegracion);
            }
        });
    }

    private AlertDialog AlertaIntegracion(){
        AlertDialog.Builder builder =new AlertDialog.Builder(this);
        builder.setTitle("¿App instalada? ");
        builder.setMessage("Status: " + launchVideovigilancia.ValidacionVideoVigilanciaInstalada(getApplicationContext()));
        return builder.create();
    }
}
