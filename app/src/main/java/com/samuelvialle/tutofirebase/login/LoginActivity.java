package com.samuelvialle.tutofirebase.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.samuelvialle.tutofirebase.MainActivity;
import com.samuelvialle.tutofirebase.R;

public class LoginActivity extends AppCompatActivity {

    /** #1 Définition des variables globales **/
    private TextView tv_title_login_register;
    private EditText et_mail_login_register, et_password_login_register;
    private Button btn_login_register;

    /** #4 Initialisation de FirebaseAuth **/
    FirebaseAuth auth;

    /** #2 Méthode initUI pour la gestion design // code **/
    public void initUi(){
        tv_title_login_register = findViewById(R.id.tv_title_login_register);
        et_mail_login_register = findViewById(R.id.et_mail_login_register);
        et_password_login_register = findViewById(R.id.et_password_login_register);
        btn_login_register = findViewById(R.id.btn_login_register);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Login et regsiter on le même layout les textes sont donnés depuis le code
        setContentView(R.layout.activity_login_register);

        // Appel de la méthode initUI()
        initUi();

        // Comme les activités login et regsiter font appellent au même layout il faut setter les widgets avec le bon texte
        tv_title_login_register.setText(R.string.login);
        btn_login_register.setText(R.string.login);
        // Arrivée ici vous pouvez recopier les #1, #2 et le onCreate dans RegisterActivity

        //#4.1 Instanciation à FirebaseAuth
        auth = FirebaseAuth.getInstance();

        //#5.1 Appel de la méthode login
        login();
    }

    /** #5 Ajout de la méthode pour la gestion du clic sur le bouton login **/
    private void login() {
        btn_login_register.setOnClickListener(v -> {
            // Récupération des données saisies
            String email = et_mail_login_register.getText().toString();
            String password = et_password_login_register.getText().toString();

            // Création d'un Toast si un des champs est vide
            // Si email vide
            if (TextUtils.isEmpty(email)) {
                Toast.makeText(LoginActivity.this, "Un nom d'utilisateur est requis", Toast.LENGTH_SHORT).show();
                // Si password vide
            } else if (TextUtils.isEmpty(password)) {
                Toast.makeText(LoginActivity.this, "Un mot de passe est requis", Toast.LENGTH_SHORT).show();
                // Si password moins de 6 caractères
            } else if (password.length() < 6) {
                Toast.makeText(LoginActivity.this, "Il faut 6 caractères ou plus", Toast.LENGTH_SHORT).show();
                // Un fois les vérifications faites, il est enfin possible d'enregister l'utilisateur avec la méthode registerUser
            } else {
                // Appelle de la méthode loginUser()
                loginUser(email, password);
            }
        });
    }

    private void loginUser(String email, String password) {
        auth.signInWithEmailAndPassword(email,password)
                .addOnSuccessListener(authResult -> {
                    // Affiche un Toast pour valider la connexion
                    Toast.makeText(LoginActivity.this, "Vous êtes connecté", Toast.LENGTH_SHORT).show();
                    // On envoie l'utilisateur loggué sur la MainActivity
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    // on ferme l'activité
                    finish();
                });
    }
}