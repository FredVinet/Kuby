const { app, BrowserWindow } = require('electron');

let mainWindow;

app.whenReady().then(() => {
  mainWindow = new BrowserWindow({
    width: 1680,
    height: 900,
    webPreferences: {
      nodeIntegration: true, // Active Node.js dans Electron
    },
  });

  const ServerURL = "http://localhost:5173"; 

  mainWindow.loadURL(ServerURL);

});

app.on('window-all-closed', () => {
  if (process.platform !== 'darwin') {
    app.quit();
  }
});
