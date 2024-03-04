package uz.salikhdev.movedb.core.cache

import android.content.Context
import com.securepreferences.SecurePreferences
import uz.salikhdev.movedb.core.util.BooleanPreference
import uz.salikhdev.movedb.core.util.StringPreference
import javax.inject.Singleton

@Singleton
class AppCache(context: Context) {

    private val KEY = "AJHKLSFHKRWadf3io23jr43dAfdpskjfsodijf32"
    private val securePreferences = SecurePreferences(context, KEY, "local_storage.xml")

    var isFirst: Boolean by BooleanPreference(securePreferences, true)
    var sessionId: String by StringPreference(securePreferences, "")


}