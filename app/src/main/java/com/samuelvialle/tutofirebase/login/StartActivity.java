package com.samuelvialle.tutofirebase.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.samuelvialle.tutofirebase.R;

public class StartActivity extends AppCompatActivity {

    /** #1 Définition des variables globales **/
    Button btn_login, btn_register;

    /** #2 Méthode initUI pour la gestion design // code **/
    public void initUI(){
        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register);
    }

    /** #3 Méthodes pour la gestion des clics et l'ouverture des activités associées  **/
    /** #3.1  le login **/
    public void login(){
        btn_login.setOnClickListener(v ->  {
              Intent intent = new Intent(StartActivity.this, LoginActivity.class);
              startActivity(intent);
        });
    }
    /** #3.2  l'inscription **/
    public void register(){
        btn_register.setOnClickListener(v -> {
            Intent intent = new Intent(StartActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        // Appel de la méthode initUI()
        initUI();
        // Appel des méthodes de gestion des clic sur les boutons
        login();
        register();


    }
}