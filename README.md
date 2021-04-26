# Groupe de hadjia_i

# Prérequis :

- Installation de <B>Laravel</B> avec <B>composer</B>.<br><br>
- Configuration de <B>MAMP PRO 4</B>.<br>
    Lancer le serveur et vérifier que les ports soient bien configurés (notemment <B>MySQL</B>).<br><br>
- Configurer le fichier <i>.env</i> de <B>Laravel</B> avec les informations de la base de données pour pouvoir s'y connecter.<br><br>

# Préparation de la Base De Données :

- Mise en place des fichiers migrations avec la commande :<br>
    <i>php artisan make:migration {name}</i><br><br>
- On ajoute les bonnes colonnes dans les tables correspondantes et lance avec la commande :<br>
    <i>php artisan migrate</i><br><br>
- Mise en place des fichiers seeders avec la commande :<br>
    <i>php artisan make:seeder {name}</i><br><br>
- Après configuration, on lance la commande :<br>
    <i>php artisan db:seed</i><br><br>

# Mise en place des Routes :

- Dans le fichier app/routes/api.php :<br>
    <i>Route::<B>{method}</B>('<B>/{path}</B>', [<B>{name}</B>Controller::class, '<B>function</B>']);</i><br>
        (Les mots en <B>gras</B> sont à personnaliser pour chaques routes)<br><br>
- On se place dans ce fichier pour ne pas avoir à mettre le mot <B>api</B> devant le <B>/path</B> dans les routes.<br><br>

# Construction des Controllers et des Models

- Mise en place des fichiers Controllers avec la commande :<br>
    <i>php artisan make:controller {name}</i><br><br>
- Chaques Routes précédemment misent en place dans le fichier route à sa propre fonction dans la classe correspondante.<br><br>
    <B>Exemple :</B><br>
        Cette route : <i>Route::post('/auth', [UserController::class, 'auth']);</i><br>
        Fait appel à : La <i>fonction</i> <B>auth</B> de la <i>classe</i> <B>UserController</B><br><br>
- Cependant, ces mêmes Controllers font appel à des Models pour éviter d'avoir tout le code dans les fichiers Controllers.<br><br>
    <B>Exemple :</B><br>
        Cette fonction dans <i>UserController.php</i> :<br><br>
        <img src="laravel_api/docu.jpg"><br><br>Fait appel à cette fonction dans le Model <i>User.php</i><br><br><img src="laravel_api/docu2.jpg"><br><br>

# Phase de Test avec Postman

- Le logiciel <B>Postman</B> va nous permettre de tester nos routes avec des requêtes.<br><br>
- Il suffit de séléctionner la méthode <i>-Dans notre cas : get, post, put, delete-</i> et de rentrer le path, par exemple : <i>localhost:8000/api/users</i><br><br>
- Il est également possible de rentrer des informations, par exemple dans le cas d'une méthode <i>post</i> ou <i>put</i>.<br><br>
    <B>Exemple :</B><br>
        Pour une requête post visant à créer un nouveau restaurant :<br><br><img src="laravel_api/docu3.jpg"><br><br><br>
- On analyse ensuite la réponse affichée par Postman et on vérifie que le Status_code renvoyé est bien le bon et que l'objet a bien été créé.<br><br>
    <B>Exemple :</B><br>
        Pour la requête envoyée précédemment, on a la réponse :<br><br><img src="laravel_api/docu4.jpg"><br><br>
- Tout est correct et l'objet est maintenant dans la base de données : La route est fonctionnelle.<br><br><br>

# Fin
