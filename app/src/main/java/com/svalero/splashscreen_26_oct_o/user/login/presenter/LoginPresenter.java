package com.svalero.splashscreen_26_oct_o.user.login.presenter;

import android.content.Intent;
import android.os.Handler;

import com.svalero.splashscreen_26_oct_o.RegisterRelativeLayout;
import com.svalero.splashscreen_26_oct_o.user.login.view.LoginActivity;

public class LoginPresenter {
    // LoginController=>
    // LoginPresenter=>
    // Negociador =>
    private LoginActivity loginActivity;

    public LoginPresenter(LoginActivity loginActivity) {
        this.loginActivity = loginActivity;
    }

    public void login(String email,
                      String password){
        // 1º=> Validar datos de entrada
            // Clase Validaciones, (estática)
        // 2º=> Consultar el API para Login
        // Lanzar un proceso en 2º plano que se active a los 4sg
        // package--> Manejar hilos
        final boolean resp = true;
        final Handler handler = new Handler();
        handler.postDelayed(
                new Runnable() { // Interface
                    @Override
                    public void run() {
                        // Cargar la 2ª pantalla
                        if(resp){
                            /*Seguir aquí con MVP*/
                            Intent navegar = new Intent(
                                    loginActivity.getBaseContext(),
                                    RegisterRelativeLayout.class);
                            loginActivity.startActivity(navegar);
                        }
                    }
                }
                , 4000
        );
        // 3º=> Responder user (correcto) o user (incorrecto)
        // 4º=> Cambiar de pantalla
        // Cargar la 2ª pantalla


    }
}
/*
// MVC => MVP Model View Presenter

* */
