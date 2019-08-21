package com.global.videovigilanciagob;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;


public class LaunchVideovigilancia {
    private static final String TAG_LAUNCH = "LaunchVideoVigilancia";
    Context contextApp;
    String correoUser, passUser, uriPattern, packageVideo, urlDescarga;
    Uri uriVideo;


    //
    public Boolean StartVigilancia(@NonNull Context contextRecibido){
        contextApp = contextRecibido;

        IniciaStrings(contextApp);

        Log.e(TAG_LAUNCH, "Inciando integracion, se buscara app VideoVigilancia...");
        uriVideo = GeneraUri();
        Log.e(TAG_LAUNCH, "Uri generado: " + uriVideo);
        if(ValidacionVideoVigilanciaInstalada(contextApp)){
            Intent intent = new Intent(Intent.ACTION_VIEW, uriVideo);
            contextApp.startActivity(intent);
            Log.e(TAG_LAUNCH, "Lanzando app...");
            return true;
        }else{
            Log.e(TAG_LAUNCH, "No se encontro app, indique al usuario que necesita instalar la app...");
            Intent intent = new Intent(contextApp, AlertaIntegracion.class);
            contextApp.startActivity(intent);
            return false;
        }
    }

    private Uri GeneraUri() {
        uriPattern = contextApp.getResources().getString(R.string.URI_VIDEOVIG);
        return Uri.parse(uriPattern);
    }

    public Boolean ValidacionVideoVigilanciaInstalada(Context contextValidacion){
        IniciaStrings(contextValidacion);
        try{
            Log.e(TAG_LAUNCH, "Buscando app VideoVigilancia...");
            PackageManager packageManager = contextValidacion.getPackageManager();
            packageManager.getPackageInfo(packageVideo, 0);
            Log.e(TAG_LAUNCH, "App encontrada...");
            return true;
        }catch (PackageManager.NameNotFoundException e){
            Log.e(TAG_LAUNCH, "No se encontro la app :(");
            return false;
        }
    }

    private void IniciaStrings(Context contextValidacion) {
        uriPattern = contextValidacion.getResources().getString(R.string.URI_VIDEOVIG);
        packageVideo = contextValidacion.getResources().getString(R.string.PACKAGEMODULE);
        urlDescarga = contextValidacion.getResources().getString(R.string.URL_VIDEOPLAY);
    }

    public void DescargaVideoVigilancia(Context contextInstala){
        Log.e(TAG_LAUNCH, "Lanzando web de descarga...");
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlDescarga));
        contextApp.startActivity(intent);
    }
}
