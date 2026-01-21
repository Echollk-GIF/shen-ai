import { defineStore } from 'pinia'
import { ref } from 'vue'
import { getLoginUser } from '@/api/userController.ts'

const LOGIN_USER_STORAGE_KEY = 'loginUser'

// 从 localStorage 恢复登录状态
function loadLoginUserFromStorage(): API.LoginUserVO {
  try {
    const stored = localStorage.getItem(LOGIN_USER_STORAGE_KEY)
    if (stored) {
      return JSON.parse(stored)
    }
  } catch (error) {
    console.error('从 localStorage 恢复登录状态失败:', error)
  }
  return {
    userName: '未登录',
  }
}

// 保存登录状态到 localStorage
function saveLoginUserToStorage(user: API.LoginUserVO) {
  try {
    if (user && user.id) {
      localStorage.setItem(LOGIN_USER_STORAGE_KEY, JSON.stringify(user))
    } else {
      localStorage.removeItem(LOGIN_USER_STORAGE_KEY)
    }
  } catch (error) {
    console.error('保存登录状态到 localStorage 失败:', error)
  }
}

export const useLoginUserStore = defineStore('loginUser', () => {
  // 从 localStorage 初始化登录状态
  const loginUser = ref<API.LoginUserVO>(loadLoginUserFromStorage())

  /**
   * 获取登录用户信息（从服务器验证并更新）
   */
  async function fetchLoginUser() {
    try {
      const res = await getLoginUser()
      if (res.data.code === 0 && res.data.data) {
        loginUser.value = res.data.data
        saveLoginUserToStorage(res.data.data)
      } else {
        // 如果服务器返回未登录，清除本地存储
        loginUser.value = { userName: '未登录' }
        saveLoginUserToStorage(loginUser.value)
      }
    } catch (error) {
      console.error('获取登录用户信息失败:', error)
      // 网络错误时不清除本地存储，保持当前状态
    }
  }

  function setLoginUser(newLoginUser: API.LoginUserVO) {
    loginUser.value = newLoginUser
    saveLoginUserToStorage(newLoginUser)
  }

  /**
   * 清除登录状态（登出时调用）
   */
  function clearLoginUser() {
    loginUser.value = { userName: '未登录' }
    localStorage.removeItem(LOGIN_USER_STORAGE_KEY)
  }

  return { loginUser, setLoginUser, fetchLoginUser, clearLoginUser }
})
