import { defineStore } from 'pinia';
import type { Article } from '@/api/interfaces/Article'; // Importez l'interface Article

export const useCartStore = defineStore('cartStore', {
  state: () => ({
    cartItems: JSON.parse(localStorage.getItem('cart') || '[]') as {
      product: Article; // Utilisez Article au lieu de Product
      quantity: number;
    }[],
  }),
  getters: {
    totalPrice: (state) => {
        return state.cartItems.reduce((total, item) => {
            return total + item.product.article_price * item.quantity;
        }, 0);
    }
},

  actions: {
      // Ajouter un produit au panier
      addToCart(product: Article, quantity: number = 1) {
        const existingItem = this.cartItems.find(
          (item) => item.product.article_id === product.article_id
        );
        if (existingItem) {
          existingItem.quantity += quantity;
        } else {
          this.cartItems.push({ product, quantity });
        }
        this.saveCart();
      },
    
      // Mettre à jour la quantité d'un produit
      updateQuantity(productId: number, quantity: number) {
        const item = this.cartItems.find((item) => item.product.article_id === productId);
        if (item) {
          item.quantity = quantity;
          if (item.quantity <= 0) {
            this.removeFromCart(productId);
          }
        }
        this.saveCart();
      },

    // Supprimer un produit du panier par rapport à son ID
    removeFromCart(productId: number) {
      const index = this.cartItems.findIndex((item) => item.product.article_id === productId);
      if (index !== -1) {
        this.cartItems.splice(index, 1); // Supprime l'élément spécifique
        this.saveCart();
      }
    },

    // Vider le panier
    clearCart() {
      this.cartItems = [];
      this.saveCart();
    },

    // Sauvegarder le panier dans localStorage
    saveCart() {
      localStorage.setItem('cart', JSON.stringify(this.cartItems));
    },
  },
});