import { defineStore } from 'pinia'
import { ref } from 'vue'
import { getIds, isTokenValid } from '@/utils/auth'
import UserService from '@/api/services/UserService'
import { useCartStore } from '@/stores/cartStore'

export const useUserConnectedStore = defineStore('userConnected', () => {
  const userId = ref<number | null>(null)
  const userDetails = ref<Record<string, any> | null>(null)

  const setUserInfo = (newUserId: number) => {
    userId.value = newUserId
  }

  const clearUserInfo = () => {
    userId.value = null
    userDetails.value = null

    localStorage.removeItem('authToken')
    localStorage.removeItem('cart')

    useCartStore().$reset()
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
      console.error('Erreur lors de la récupération des détails utilisateur :', error)
      userDetails.value = null
    }
  }

  const initializeFromToken = async () => {
    const token = localStorage.getItem('authToken')
    if (token && isTokenValid(token)) {
      const ids = getIds(token)
      setUserInfo(ids.userId)

      await fetchUserInfo()
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
    fetchUserInfo,
  }
})
