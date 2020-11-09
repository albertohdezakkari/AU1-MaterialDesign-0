package com.svalero.splashscreen_26_oct_o.user.login.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.svalero.splashscreen_26_oct_o.R;
import com.svalero.splashscreen_26_oct_o.RegisterRelativeLayout;
import com.svalero.splashscreen_26_oct_o.user.login.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity {
    private static final int SCREEN = 2;

    private Button btnEnviar;
    private EditText edtEmail;
    private EditText edtPassword;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //3º--> Inicializar
        initComponents();
        //
        // 4º--> Presentador (Controller)
        loginPresenter = new LoginPresenter(this);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.login(
                        edtEmail.getText().toString(),
                        edtPassword.getText().toString()
                );
            }
        });
    }
    private void initComponents(){
        btnEnviar = findViewById(R.id.btnEnviar);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
    }
}