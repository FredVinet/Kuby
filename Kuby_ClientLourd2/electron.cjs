const { app, BrowserWindow } = require('electron');

let mainWindow;

app.whenReady().then(() => {
  mainWindow = new BrowserWindow({
    width: 1200,
    height: 800,
    webPreferences: {
      nodeIntegration: true, // Active Node.js dans Electron
    },
  });

  // Charge l'application Vue en mode développement ou production
  const devServerURL = "http://localhost:5173"; // Vite en dev
  const prodAppPath = `file://${__dirname}/dist/index.html`; // Build en prod

  mainWindow.loadURL(devServerURL);

  if (!app.isPackaged) {
    mainWindow.webContents.openDevTools(); // Ouvre la console dev en mode dev
  }
});

app.on('window-all-closed', () => {
  if (process.platform !== 'darwin') {
    app.quit();
  }
});
