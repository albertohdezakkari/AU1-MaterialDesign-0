package com.svalero.splashscreen_26_oct_o;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {
    private static final int SCREEN = 2;
    private Button btnEnviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //3º--> Inicializar
        initComponents();

        //
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Cargar la 2ª pantalla
                Intent navegar = new Intent(
                        getBaseContext(), RegisterRelativeLayout.class);
                startActivity(navegar);
            }
        });
    }
    private void initComponents(){
        btnEnviar = findViewById(R.id.btnEnviar);
    }
}