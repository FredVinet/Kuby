import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  {
    path: '/',
    name: 'stock',
    component: () => import('../views/Stock.vue'),
    meta: { requiresAuth: true }
  },
  {
    path: '/clientslist',
    name: 'clientslist',
    component: () => import('../views/MyClients.vue'),
    meta: { requiresAuth: true }
  },
  {
    path: '/supplierslist',
    name: 'supplierslist',
    component: () => import('../views/MySuppliers.vue'),
    meta: { requiresAuth: true }
  },
  {
    path: '/clientsorders',
    name: 'clientsorders',
    component: () => import('../views/MyClientsOrders.vue'),
    meta: { requiresAuth: true }
  },
  {
    path: '/suppliersorders',
    name: 'suppliersorders',
    component: () => import('../views/MySuppliersOrders.vue'),
    meta: { requiresAuth: true }
  },
  {
    path: '/connexion',
    name: 'connexion',
    component: () => import('../views/Connexion.vue'),
    meta: { requiresAuth: true }
  },
]

const router = createRouter({
  history: createWebHistory(),
  routes,
  scrollBehavior(to, from, savedPosition) {    
    return { top: 0 };
  },
})


export default router
