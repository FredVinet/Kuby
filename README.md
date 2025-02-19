# Kuby

Bienvenue dans le projet **Kuby**, une application web et logicielle développée avec un backend en **Java/MySQL**, un client léger en **Vue.js** avec **TypeScript**, et un client lourd en **Vue.js**, **TypeScript** et **Electron**.

---

## **Structure du projet**

```
kuby/
├── Kuby_API/           # Contient le backend en Java
│   ├── src/
│       ├── main/
│           ├── java/                   # Code source principal
│               ├── config/             # Configuration (ex. : CORS, JWT)
│               ├── controller/         # Dossier contenant les contrôleurs de l'API Java
│               ├── model/              # Dossier contenant les modèles de l'API Java
│               ├── repository/         # Dossier contenant les repositories de l'API Java avec CRUD repository
│               ├── service/            # Dossier contenant les services de l'API Java
│           ├── resources/              # Ressources pour l'API et les routes
│               ├── application.yml     # Fichier de connexion à la base de données
│               ├── data.sql            # Fichier contenant les données initiales
│               
├── Kuby_ClientLeger/   # Contient le client léger en Vue.js + Vuetify
│   ├── src/                # Code source principal
│   ├── public/             # Fichiers accessibles publiquement
│   ├── tsconfig.json       # Configuration TypeScript
│   ├── vite.config.ts      # Configuration de Vite
│   
├── Kuby_ClientLourd/   # Contient le premier client lourd en JavaFX
│   ├── src/
│       ├── main/
│           ├── java/       # Code source principal en Java
│               ├── controller/         # Dossier contenant les contrôleurs de l'application JavaFX
│           ├── resources/  # Ressources principales en FXML pour l'affichage des pages
│               ├── assets/             # Dossier contenant les images
│               ├── css/                # Dossier contenant le style
│               ├── view/               # Dossier contenant les fichiers FXML pour l'affichage des pages  
│
├── Kuby_ClientLourd2/   # Contient la version finale du client lourd en Vue.js + Vuetify + Electron
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

- **Java** >= 17
- **MySQL** >= 5.7

---

## **Installation**

### **1. Cloner le projet**

```bash
git clone https://github.com/FredVinet/Kuby.git
cd Kuby
```

---

### **2. Initialisation de la base de données**

Vous devez créer une base de données sur votre environnement local.

Modifiez les variables d'environnement dans `Kuby_API/src/main/resources/application.yml` :

- **DB_NAME** : `kubydata`
- **DB_USER** : [Votre choix]
- **DB_PASSWORD** : [Votre choix]

Le script de création de la base de données se trouve dans `Kuby_API/src/main/resources/data.sql`.

Depuis votre terminal :

```bash
mysql -u [votre_utilisateur] -p kubydata < [chemin_vers]/Kuby/Kuby_API/src/main/resources/data.sql
```

---

### **3. Configuration du backend**

1. Placez-vous dans le dossier `Kuby_API` :

   ```bash
   cd Kuby_API
   ```

2. Modifiez les paramètres de `application.yml` dans `Kuby_API/src/main/resources/` pour correspondre à votre base de données.

3. Revenez à la racine du projet.

4. Lancez l'API.

---

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

## **Scripts utiles**

### **Frontend**

| Commande        | Description                          |
| --------------- | ------------------------------------ |
| `npm install`   | Installe les dépendances Node.js.    |
| `npm run dev`   | Lance le serveur de développement.   |
| `npm run build` | Génère le build pour la production.  |

---

