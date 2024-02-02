package uz.salikhdev.movedb.core.cache

import android.content.Context

class AppCache(context: Context) {

    private val sharedPreferences = context.getSharedPreferences("app_cache", Context.MODE_PRIVATE)
    private val TOKEN_KEY = "TOKEN_KEY"

    fun saveToken(token: String) {
        sharedPreferences.edit().putString(TOKEN_KEY, token).apply()
    }

    fun getToken(): String {
        return sharedPreferences.getString(TOKEN_KEY, "")!!
    }

}