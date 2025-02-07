import { defineStore } from 'pinia'
import { ref } from 'vue'
import { getIds, isTokenValid, setToken, removeToken } from '@/utils/auth'
import type { User } from '@/api/interfaces/User'

export const useUserConnectedStore = defineStore('userConnected', () => {
  const userId = ref<number | null>(null)
  const userDetails = ref<User | null>(null)

  // Méthode pour définir les informations de l'utilisateur
  const setUserInfo = (user: User) => {
    userId.value = user.user_id
    userDetails.value = user
  }

  // Méthode pour effacer les informations de l'utilisateur
  const clearUserInfo = () => {
    userId.value = null
    userDetails.value = null
    removeToken() // Supprimer le token du localStorage
  }

  // Méthode pour initialiser l'utilisateur à partir du token
  const initializeFromToken = async () => {
    const token = localStorage.getItem('authToken')
    if (token && isTokenValid(token)) {
      const ids = getIds(token)
      userId.value = ids.userId

      // Vous pouvez appeler une méthode pour récupérer les détails de l'utilisateur ici
    } else {
      clearUserInfo()
    }
  }

  return {
    userId,
    userDetails,
    setUserInfo,
    clearUserInfo,
    initializeFromToken,
  }
})