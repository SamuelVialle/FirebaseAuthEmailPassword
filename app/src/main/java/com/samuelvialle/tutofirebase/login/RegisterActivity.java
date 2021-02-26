package com.samuelvialle.tutofirebase.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.samuelvialle.tutofirebase.R;

public class RegisterActivity extends AppCompatActivity {

    /**
     * #1 Définition des variables globales
     **/
    private TextView tv_title_login_register;
    private EditText et_mail_login_register, et_password_login_register;
    private Button btn_login_register;

    /** #6 Ajout de la connexion à Firebase Auth **/
    private FirebaseAuth auth;

    /**
     * #2 Méthode initUI pour la gestion design // code
     **/
    public void initUi() {
        tv_title_login_register = findViewById(R.id.tv_title_login_register);
        et_mail_login_register = findViewById(R.id.et_mail_login_register);
        et_password_login_register = findViewById(R.id.et_password_login_register);
        btn_login_register = findViewById(R.id.btn_login_register);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Login et register on le même layout les textes sont donnés depuis le code
        setContentView(R.layout.activity_login_register);
        // Appel de la méthode initUI()
        initUi();

        //#3 Comme les activités login et regsiter font appel au même layout il faut setter les widgets avec le bon texte
        tv_title_login_register.setText(R.string.register);
        btn_login_register.setText(R.string.register);

        // #6.1 Récupération de l'instance de connexion à Authentication
        auth = FirebaseAuth.getInstance();

        //#7 Ne pas oublier d'appeler la méthode register
        register();
    }


    /**
     * #4 Gestion du clic sur le bouton register
     */
    public void register() {
        // Ajout du listener sur le bouton
        btn_login_register.setOnClickListener(v -> {
            // Définition des variables qui seront envoyées à Firebase pour l'ajout d'un compte
            String email = et_mail_login_register.getText().toString();
            String password = et_password_login_register.getText().toString();

            // Création d'un Toast si un des champs est vide
            // Si email vide
            if (TextUtils.isEmpty(email)) {
                Toast.makeText(RegisterActivity.this, "Un nom d'utilisateur est requis", Toast.LENGTH_SHORT).show();
                // Si password vide
            } else if (TextUtils.isEmpty(password)) {
                Toast.makeText(RegisterActivity.this, "Un mot de passe est requis", Toast.LENGTH_SHORT).show();
                // Si password moins de 6 caractères
            } else if (password.length() < 6) {
                Toast.makeText(RegisterActivity.this, "Il faut 6 caractères ou plus", Toast.LENGTH_SHORT).show();
                // Un fois les vérifications faites, il est enfin possible d'enregister l'utilisateur avec la méthode registerUser
            } else {
                registerUser(email, password);
            }
        });
    }

    /** #5 Gestion de l'enregistrement d'un nouvel utilisateur **/
    private void registerUser(String email, String password) {
        //#6.2 Création de l'utilisateur dans Firebase
        auth.createUserWithEmailAndPassword(email, password)
                // Ajout du addOnCompleteListener
            .addOnCompleteListener(RegisterActivity.this, task -> {
                if (task.isSuccessful()) {
                    // pour afficher un Toast de réussite et renvoyé vers la page de connexion
                    Toast.makeText(RegisterActivity.this, "Vous êtes enregistré ! \n Vous pouvez vous connecter maintenant",
                            Toast.LENGTH_SHORT).show();
                    // On renvoie alors vers la page de connexion
                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                } else {
                    // pour afficher un Toast d'erreur
                    Toast.makeText(RegisterActivity.this, "L'enregistrement à échoué, ré-essayer",
                            Toast.LENGTH_SHORT).show();
                }
            });
    }
}
