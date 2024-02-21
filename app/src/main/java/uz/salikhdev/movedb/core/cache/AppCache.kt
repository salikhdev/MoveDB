package uz.salikhdev.movedb.core.cache

import android.content.Context

class AppCache(context: Context) {

    private val sharedPreferences = context.getSharedPreferences("app_cache", Context.MODE_PRIVATE)
    private val SESSION_KEY = "SESSIOMN_KEY"
    private val IS_FIRST = "IS_FIRS"

    fun saveSession(token: String) {
        sharedPreferences.edit().putString(SESSION_KEY, token).apply()
    }

    fun removeSession() {
        sharedPreferences.edit().remove(SESSION_KEY).apply()
    }

    fun getSessionId(): String {
        return sharedPreferences.getString(SESSION_KEY, "")!!
    }

    fun isFirst(isFirst: Boolean) {
        sharedPreferences.edit().putBoolean(IS_FIRST, isFirst).apply()
    }

    fun getIsFirst(): Boolean {
        return sharedPreferences.getBoolean(IS_FIRST, true)
    }

}