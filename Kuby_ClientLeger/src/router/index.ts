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
  },
  {
    path: '/account',
    name: 'Account',
    component: () => import('../views/Account.vue'),
  },
  {
    path: '/product',
    name: 'Product',
    component: () => import('../views/Product.vue'),
  },
  {
    path: '/connexion',
    name: 'Connexion',
    component: () => import('../views/Connexion.vue'),
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
