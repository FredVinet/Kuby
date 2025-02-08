import { isTokenValid } from '@/utils/auth';
import { createRouter, createWebHistory } from 'vue-router';

const routes = [
  {
    path: '/',
    name: 'main',
    component: () => import('../views/main.vue'),
  },
  {
    path: '/catalogue',
    name: 'Catalogue',
    component: () => import('../views/Catalogue.vue'),
  },
  {
    path: '/cart',
    name: 'Cart',
    component: () => import('../views/Cart.vue'),
    meta: { requiresAuth: true }
  },
  {
    path: '/account',
    name: 'Account',
    component: () => import('../views/Account.vue'),
    meta: { requiresAuth: true }
  },
  {
    path: '/connexion',
    name: 'Connexion',
    component: () => import('../views/Connexion.vue'),
  },
  {
    path: '/product',
    name: 'Product',
    component: () => import('../views/Product.vue'),
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

// Ajouter un guard pour vérifier l'authentification
router.beforeEach((to, from, next) => {
  const token = localStorage.getItem('authToken'); // Récupérer le token depuis le localStorage

  if (to.meta.requiresAuth && (!token || !isTokenValid(token))) {
      // Si la route nécessite une connexion et que le token est invalide ou manquant
      next('/connexion'); // Redirigez l'utilisateur vers la page de connexion
  } else {
      // Sinon, autorisez l'accès
      next();
  }
});

export default router;
