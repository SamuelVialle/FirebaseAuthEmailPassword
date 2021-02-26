package com.samuelvialle.tutofirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.samuelvialle.tutofirebase.login.StartActivity;

public class MainActivity extends AppCompatActivity {

    /** #1 Définition des variables globales **/
    private Button btn_logout;

    /** #2 Méthode initUI pour la gestion design // code **/
    public void initUi() {
        btn_logout = findViewById(R.id.btn_logout);
    }

    /** #3 Ajout de la connexion à Firebase Auth **/
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //#2.1 Appel de la méthode initUI()
        initUi();

        //#3.1 Instanciation de Firebase Auth
        auth = FirebaseAuth.getInstance();

        //#4.1 Gestion du logout
        logout();
    }

    /** #4 Métode pour se déconnecter **/
    private void logout() {
        // Gestion de la déconnexion
        auth.signOut();
        // Affichage d'un Toast
        Toast.makeText(this, "Vous êtes déconnecté", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this, StartActivity.class));
    }
}