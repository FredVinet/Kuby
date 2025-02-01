import './assets/main.css'
import { createApp } from 'vue'
import { createPinia } from 'pinia'

// Vuetify
import 'vuetify/styles';
import { createVuetify } from "vuetify"
import '@mdi/font/css/materialdesignicons.css'
import * as components from 'vuetify/components'
import * as directives from 'vuetify/directives'

import App from './App.vue'
import router from './router'

const pinia = createPinia()

const vuetify = createVuetify({
  components,
  directives,
  icons: {
    defaultSet: 'mdi',
  },
  theme: {
    defaultTheme: 'light',
    themes: {
      light: {
        colors: {
          primary: '#d1a671', // Dorée
          secondary: '#F0E3D3', //Dorée fond main 
          accent: '#eae3de',  
          error: '#FF5252',    
          info: '#100E0E', //Noir Footer
          success: '#4CAF50',  
          warning: '#700b15',  //Rouge
        },
      },
      dark: {
        colors: {
          primary: '#f44336',
          secondary: '#c90076',
          accent: '#8c9eff',
          error: '#b71c1c',
        },
      },
    },
  },
});

const app = createApp(App)

app.use(vuetify)
app.use(router)
app.use(pinia)
app.mount('#app')
