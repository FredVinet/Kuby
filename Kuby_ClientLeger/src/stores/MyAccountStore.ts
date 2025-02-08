import { defineStore } from 'pinia'
import { ref } from 'vue'
import UserService from '@/api/services/UserService'
import AddressService from '@/api/services/AddressService'
import { getIds } from '@/utils/auth'
import type { User } from '@/api/interfaces/User'
import type { Address } from '@/api/interfaces/Address'

export const useMyAccountStore = defineStore('MyAccount', () => {
  const user = ref<User | null>(null)
  const addresses = ref<Address[]>([])
  const loading = ref(false)


  // Fonction pour mettre à jour la liste après une modification
  const setAddresses = (newAddresses: Address[]) => {
    addresses.value = newAddresses.sort((a, b) => (b.is_default ? 1 : -1))
  }

  const fetchUserData = async () => {
    loading.value = true
    const token = localStorage.getItem('authToken') ?? ''
    const Ids = getIds(token)

    try {
      user.value = await UserService.getUserById(Ids.userId)
      const response = await AddressService.getAddressesByUser(user.value.user_id ?? 0)
      setAddresses(response)

    } catch (err) {
      console.error(err)
    } finally {
      loading.value = false
    }
  }

  return {
    user,
    addresses,
    loading,
    fetchUserData,
    setAddresses,
  }
})
