# Connexion via email password avec Firebase Authentication

<p align="center">
  <img src="https://samuelvialle.com/imgGit/startActivity.png" width="200" title="startActivity.java">
  <img src="https://samuelvialle.com/imgGit/loginActivity.png" width="200" title="loginActivity.java">
  <img src="https://samuelvialle.com/imgGit/registerActivity.png" width="200" title="registerActivity.java">
</p>

Cette application montre comment ajouter à la main une gestion de connexion via email password
     
Elle comprend : 
   - Une première page pour choisir entre login (se connecter) ou register (s'enregistrer)
   - Une page d'authentification par email et password --> StartActivity
   - Une page pour vous enregistrer --> RegisterActivity
   - Un bouton pour se déconnecter --> MainActivity
   - Une page qui gère votre application

Avant de commencer à coder, il faut se rendre dans la console de Firebase, accéder à un projet déjà créé ou en créer un (attention 20 projets max avant dépassement du quota)
     
### Ajouter votre application au projet
<p align="center">
     <img src="https://samuelvialle.com/imgGit/addAppToFB.png">
</p>
Remplir le formulaire d'ajout d'application sans oublier d'y insérer le SHA1*
<p align="center">
     <img src="https://samuelvialle.com/imgGit/addAppToFirebase.png">
</p>

*Insérer le SHA1 :
- Sous Android Studio :
- Ouvrir l'onglet Gradle (sur la partie droite de l'écran)</td>
     <p align="center">
          <img src="https://samuelvialle.com/imgGit/Gradle.png">
     </p>
- Dérouler Tasks > Android ou App > Android 
- Double cliquer sur signingReport
     <p align="center">
          <img src="https://samuelvialle.com/imgGit/Gradle2.png">
     </p>
- Dans le terminal qui vient de s'ouvrir, copier le SHA1 puis le coller dans le formulaire de Firebase
*Penser à sélectionner app dans le menu déroulant à coté du marteau (make) 

Récupérer le fichier de configuration json, le copier dans le répertoire app d'Android Studio (répertoire acessible depuis la vue Project)
 // Ajout d'une photo
        
Quitter le didacticiel de Firebase puis rendez-vous dans l'onglet Authentication
            // Ajout d'une photo
Activer l'authentification par Adresse e-mail/Mot de passe dans Sign-in method
Ajouter un email factice pour tester la page login de votre application dans Users
     
De retour dans Firebase cliquer sur Tools > Firebase
Dans l'assistant cliquer sur Authentication > Choisir n'importe quel choix puis ajouter les dépendances requises          

Vous allez enfin pouvoir commencer le codage ;)
                
## Le design de l'app

#### 1 activity_start.xml --> Ajouter 2 boutons et une image (facultatif)
        // Ajout image 
     
#### 2 activity_login_register --> Ajouter 1 TextView pour le titre, 2 EditText un mail et un password, 1 bouton
    Ce layout servira pour l'activité Login et pour l'activité Register le texte sera changé via la code  

#### 3 StartActivity.java : impléméntation du code

#### 4 LoginActivity.java : implémentation du code

#### 5 RegisterActivity.java : copie du code similaire à loginActivity

#### 6 LoginActivity.java : Liaison avec Firebase Authentication, gestion du login pour afficher l'activité MainActivity si user OK

#### 7 MainActivity.java : Ajout du bouton de déconnexion

#### 8 Vous pouvez maintenant lancer l'application pour la tester
        
        
