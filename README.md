# Kuby

Bienvenue dans le projet **Kuby**, une application web et logiciel développée avec un backend en **JAVA/MySQL** et un client léger en **Vue.js** avec **TypeScript** et lourd en **Vue.js** avec **TypeScript** et **Electron**.

---

## **Structure du projet**

```
kuby/
├── Kuby_API/           # Contient le backend en JAVA
│   ├── src/
│       ├── main/
│           ├── java/                   # Code source principal
│               ├── config/             # Configuration (ex. : Cors, Jwt)
│               ├── controller/         # Dossier contenant les controllers de l'api JAVA
│               ├── model/              # Dossier contenant les models de l'api JAVA
│               ├── repository/         # Dossier contenant les repository de l'api JAVA avec CRUD repository
│               ├── service/            # Dossier contenant les services de l'api JAVA
│           ├── resources/              # Point d'entrée pour l'API et les routes
│               ├── application.yml/    # Fichier de connexion à la base de donnée
│               ├── data.sql/           # Fichier contenant la base de donnée
│               
├── Kuby_ClientLeger/   # Contient le client léger en Vue.js + vuetify
│   ├── src/                # Code source principal
│   ├── public/             # Fichiers accessibles publiquement
│   ├── tsconfig.json       # Configuration TypeScript
│   ├── vite.config.ts      # Configuration de Vite
│   
├── Kuby_ClientLourd/   # Contient le premier client lourd en JavaFx
│   ├── src/
│       ├── main/
│           ├── java/       # Code source principal en JAVA
│               ├── controller/         # Dossier contenant les controllers de l'application JavaFx
│           ├── resources/  # Code source principal en FXML pour l'affichage des pages
│               ├── assets/             # Dossier contenant les images
│               ├── css/                # Dossier contenant le style 
│               ├── view/               # Dossier contenant les fichiers FXML pour l'affichage des pages  
│
├── Kuby_ClientLourd2/   # Contient le client lourd en version final en Vue.js + vuetify et electron
│   ├── src/                # Code source principal
│   ├── public/             # Fichiers accessibles publiquement
│   ├── electron.cjs        # Configuration Electron
│   ├── tsconfig.json       # Configuration TypeScript
│   ├── vite.config.ts      # Configuration de Vite
│
└── README.md          # Documentation principale
```

---

## **Prérequis**

Assurez-vous d’avoir les outils suivants installés :

### Frontend

- **Node.js** >= 18.x
- **npm** >= 8.x (inclus avec Node.js)

### Backend

- **JAVA** >= 17
- **MySQL** >= 5.7

## **Installation**

### **1. Cloner le projet**

```bash
git clone https://github.com/FredVinet/Kuby.git
cd Kuby
```

---

### **2. Initialisation de la base de données**

Vous devez monter une base de données sur votre environnement local :

Il faut changer les variables d'environnement de `Kuby_API/src/main/resources/application.yml`

- **DB_NAME** : kubydata
- **DB_USER** : comme vous le souhaitez
- **DB_PASSWORD** : comme vous le souhaitez

Le script de création de la base de données se trouve dans `Kuby_API/src/main/resources/data.sql`.

Depuis votre terminal :

```bash
mysql -u [votre_utilisateur] -p kubydata < [dossier enregistrement]/Kuby/Kuby_API/src/main/resources/data.sql
```

---

### **3. Configuration du backend**

1. Placez-vous dans le dossier `Kuby_API` :

   ```bash
   cd Kuby_API
   ```

2. Modifiez les données du `application.yml` dans `Kuby_API/src/main/resources/` pour celles de votre propre base de données.

3. Revenez à la racine du projet.

4. Lancez l'API.

### **4. Configuration du client léger**

1. Placez-vous dans le dossier `Kuby_ClientLeger` :

   ```bash
   cd Kuby_ClientLeger
   ```

2. Installez les dépendances Node.js :

   ```bash
   npm install
   ```

3. Lancez le serveur de développement :

   ```bash
   npm run dev
   ```

4. Accédez à l'application dans votre navigateur à l'adresse :
   ```
   http://localhost:5173
   ```

---

### **5. Configuration du client lourd**

1. Placez-vous dans le dossier `Kuby_ClientLourd2` :

   ```bash
   cd Kuby_ClientLourd2
   ```

2. Installez les dépendances Node.js :

   ```bash
   npm install
   ```

3. Lancez le serveur de développement :

   ```bash
   npm run dev
   ```

---

## **Fonctionnalités principales**

- **API** :

  - API REST construite en JAVA.
  - Base de données MySQL.
  - Gestion des variables d'environnement avec `.yml`.
  - Structure modulaire (routes, contrôleurs, modèles).

- **Client léger** :
  - Framework Vue.js avec TypeScript.
  - Architecture modulaire avec composants réutilisables.
  - Gestion de l'état global via Pinia (optionnel).
  - Support de Vue Router pour la navigation.

- **Client Lourd** :
  - Framework Vue.js avec TypeScript et Electron.
  - Architecture modulaire avec composants réutilisables.
  - Gestion de l'état global via Pinia (optionnel).
  - Support de Vue Router pour la navigation.

---

## **Scripts utiles**

### Frontend

| Commande        | Description                          |
| --------------- | ------------------------------------ |
| `npm install`   | Installe les dépendances Node.js.    |
| `npm run dev`   | Lance le serveur de développement.   |
| `npm run build` | Génère le build pour la production.  |
| `npm run lint`  | Analyse et corrige le code (ESLint). |

# Client Lourd

Page Stock : 
    - Filtre par prix, famille, variété
    - Mettre a jour aprés Modification et ajout total et réinitilisé card quand supprimer
    - Gestion inventaire

Page Client : 
    - Card si pas d'adresse pas d'adresse
    - Modification client
    - Mettre a jour

Page Fournisseur : 
    - Ajouter un fournisseur, mettre verification nom de rue seulement int 

Page Commande Client : 
    - Modifier Commande a faire
    - Rajouter Titre   

Page Commande Client : 
    - Modifier Commande a faire
    - Rajouter titre

Connexion : 
    - A faire et gerer la suppression une fois admin 


# Client Leger

Page main : 
    - Coup de coeur et nouveauté Modifier les product.title product.wine product.price

Page Catalogue 
    - Filtre
        - Année et prix a modifier pour avoir genre une jauge ou un min max (car la si tu met 1 ta genre 81 12 1)
        - Trié par vin aussi 
    - Card
        - Sur les card enlever les rounded pour correspondre au reste du site
        - Afficher info type de vin et cépage du vin 
        - Aligner pour chaque card les info au meme endroit décalage 

Connexion c'est bon 

Account :  
    - Modifier couleur du texte dans account 
    - Vos Adresse enlever le shadow de la card 
    - Vos commandes voir les statuts

Panier : 
    - Mettre une marge start article
    - Ajouter une image 
    - Contour Card = contour card résumé de la commande 
    - Modif statut commande

Page Product : 
    - Mettre une marge start a la description 


Générale faire remonter en haute de la page a chaque changement de page 
