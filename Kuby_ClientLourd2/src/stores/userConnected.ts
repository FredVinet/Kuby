import { defineStore } from 'pinia'
import { ref } from 'vue'
import { getIds, isTokenValid } from '@/utils/auth'
import type { User } from '@/api/interfaces/User'
import UserService from '@/api/services/UserService'

export const useUserConnectedStore = defineStore('userConnected', () => {
  const userId = ref<number | null>(null)
  const userDetails = ref<Record<string, any> | null>(null)
  const userRole = ref<string | null>(null)

  // Méthode pour définir les informations de l'utilisateur
  const setUserInfo = (newUserId: number, newUserRole: string) => {
    userId.value = newUserId
    userRole.value = newUserRole
  }

  // Méthode pour effacer les informations de l'utilisateur
  const clearUserInfo = () => {
    userId.value = null
    userDetails.value = null
    userRole.value = null

    localStorage.removeItem('authToken')
  }

  const fetchUserInfo = async () => {
    if (!userId.value) {
      console.error('Aucun ID utilisateur')
      return
    }
  
    try {
      const details = await UserService.getUserById(userId.value)
      userDetails.value = details
    } catch (error) {
      userDetails.value = null
    }
  }

  // Méthode pour initialiser l'utilisateur à partir du token
  const initializeFromToken = async () => {
    const token = localStorage.getItem('authToken')
    if (token && isTokenValid(token)) {
      const ids = getIds(token)
      setUserInfo(ids.userId, ids.userRole)
      console.log("userRole", userRole.value)

      await fetchUserInfo()
    } else {
      clearUserInfo()
    }
  }

  return {
    userId,
    userDetails,
    userRole,
    setUserInfo,
    clearUserInfo,
    initializeFromToken,
    fetchUserInfo,
  }
})