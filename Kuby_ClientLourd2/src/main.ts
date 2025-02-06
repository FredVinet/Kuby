import './assets/main.css'
import { createApp } from 'vue'
import { createPinia } from 'pinia'

// Vuetify
import 'vuetify/styles'
import { createVuetify } from 'vuetify'
import '@mdi/font/css/materialdesignicons.css'
import * as components from 'vuetify/components'
import * as directives from 'vuetify/directives'
import { fr } from 'vuetify/locale'

import App from './App.vue'
import router from './router'

const vuetify = createVuetify({
  components,
  directives,
  locale: {
    locale: 'fr',
    messages: { fr },
  },
  icons: {
    defaultSet: 'mdi',
  },
  theme: {
    defaultTheme: 'light',
    themes: {
      light: {
        colors: {
          primary: '#d1a671', 
          primaryDarken: '#b89a7a',
          secondary: '#ACB5BB', 
          accent: '#000000', 
          error: '#AD3E32',
          info: '#000000', 
          success: '#4CAF50',
          warning: '#FFC107',
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
})

const app = createApp(App)

app.use(vuetify)
app.use(createPinia())
app.use(router)

app.mount('#app')
