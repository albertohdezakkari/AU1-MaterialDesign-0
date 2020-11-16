package com.svalero.splashscreen_26_oct_o.movies.lstMovies.model;

import android.os.Handler;

import com.svalero.splashscreen_26_oct_o.movies.lstMovies.contract.LstMoviesContract;

import java.util.ArrayList;

public class LstMoviesModel {
    final boolean resp = true;
    public void getMoviesWS(final LstMoviesContract.Model.OnLstMoviesListener
                                    onLstMoviesListener ){
        final Handler handler = new Handler();
        handler.postDelayed(
                new Runnable() { // Interface
                    @Override
                    public void run() {
                        // Cargar la 2ª pantalla
                        if(resp){
                            /*Seguir aquí con MVP*/
                            onLstMoviesListener.onFinished(new ArrayList());
                            /*Intent navegar = new Intent(
                                    loginActivity.getBaseContext(),
                                    RegisterRelativeLayout.class);
                            loginActivity.startActivity(navegar);*/
                        }else{
                            onLstMoviesListener.
                                    onFailure("Error de Servidor. ");
                        }
                    }
                }
                , 4000
        );
    }
}
