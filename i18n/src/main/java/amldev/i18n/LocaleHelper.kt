package amldev.i18n

import android.annotation.TargetApi
import android.content.Context
import android.content.Intent
import android.os.Build
import android.preference.PreferenceManager
import java.util.*
import android.app.Activity
import android.content.DialogInterface
import android.support.v7.app.AlertDialog

/***************************************************************************************************
 * Created by Anartz Mugika (mugan86@gmail.com) on 30/7/17.
 ***************************************************************************************************/
object LocaleHelper {

    private val SELECTED_LANGUAGE = "SELECT_LANGUAGE"

    fun onAttach(context: Context): Context = setLocale(context, getPersistedData(context, Locale.getDefault().language))

    fun onAttach(context: Context, defaultLanguage: String): Context = setLocale(context, getPersistedData(context, defaultLanguage))

    fun getLanguage(context: Context): String =
            getPersistedData(context, Locale.getDefault().language)

    fun setLocale(context: Context, language: String): Context {
        persist(context, language)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return updateResources(context, language)
        }

        return updateResourcesLegacy(context, language)
    }

    private fun getPersistedData(context: Context, defaultLanguage: String): String {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        return preferences.getString(SELECTED_LANGUAGE, defaultLanguage)
    }

    private fun persist(context: Context, language: String) {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = preferences.edit()

        editor.putString(SELECTED_LANGUAGE, language)
        editor.apply()
    }

    @TargetApi(Build.VERSION_CODES.N)
    private fun updateResources(context: Context, language: String): Context {
        val locale = Locale(language)
        Locale.setDefault(locale)

        val configuration = context.resources.configuration
        configuration.setLocale(locale)
        configuration.setLayoutDirection(locale)

        return context.createConfigurationContext(configuration)
    }

    private fun updateResourcesLegacy(context: Context, language: String): Context {
        val locale = Locale(language)
        Locale.setDefault(locale)

        val resources = context.resources

        val configuration = resources.configuration
        configuration.locale = locale
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) configuration.setLayoutDirection(locale)

        resources.updateConfiguration(configuration, resources.displayMetrics)

        return context
    }

    fun restartApp(context: Context) {
        val restart_app_intent = Intent(context, context::class.java)
        restart_app_intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(restart_app_intent)
        (context as Activity).finish()
        context.overridePendingTransition(0, 0)
    }

    fun languageOptionsDialog(context: Context) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(context.resources.getString(R.string.make_your_language_selection))
        builder.setItems(context.resources.getStringArray(R.array.language_string), DialogInterface.OnClickListener { dialog, item ->
            setLocale(context, context.resources.getStringArray(R.array.language_codes) [item])
            restartApp(context)
        })
        builder.create().show()
    }
}