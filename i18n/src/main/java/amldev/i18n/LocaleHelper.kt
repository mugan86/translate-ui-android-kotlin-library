package amldev.i18n

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.preference.PreferenceManager
import android.support.v7.app.AlertDialog
import java.util.*

/***************************************************************************************************
 * Created by Anartz Mugika (mugan86@gmail.com) on 30/7/17. Updated: 20/01/2018
 * Manage Locale language use in app.
 ***************************************************************************************************/
object LocaleHelper {

    private val SELECTED_LANGUAGE = "SELECT_LANGUAGE"

    fun onAttach(context: Context): Context = setLocale(context, getPersistedData(context, Locale.getDefault().language))


    fun getLanguage(context: Context): String = getPersistedData(context, Locale.getDefault().language)

    private fun setLocale(context: Context, language: String): Context {
        persist(context, language)
        return updateResources(context, language)
    }

    private fun getPersistedData(context: Context, defaultLanguage: String): String =
            PreferenceManager.getDefaultSharedPreferences(context).getString(SELECTED_LANGUAGE, defaultLanguage)


    private fun persist(context: Context, language: String) {
        val editor = PreferenceManager.getDefaultSharedPreferences(context).edit()

        editor.putString(SELECTED_LANGUAGE, language)
        editor.apply()
    }

    private fun updateResources(context: Context, language: String): Context {
        val locale = Locale(language)
        Locale.setDefault(locale)

        val configuration = context.resources.configuration
        configuration.setLocale(locale)
        configuration.setLayoutDirection(locale)

        return context.createConfigurationContext(configuration)
    }


    fun languageOptionsDialog(context: Context) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(context.resources.getString(R.string.make_your_language_selection))
        builder.setItems(context.resources.getStringArray(R.array.language_string), DialogInterface.OnClickListener { _, item ->
            setLocale(context, context.resources.getStringArray(R.array.language_codes) [item])
            restartApp(context)
        })
        builder.create().show()
    }

    fun changeLang(context:Context, lang: String) {
        var changeLanguage = false
        if (lang != getLanguage(context)) changeLanguage = true

        if(changeLanguage) {
            setLocale(context, lang)
            restartApp(context)
        }
    }

    private fun restartApp(context: Context) {
        val restartAppIntent = Intent(context, context::class.java)
        restartAppIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(restartAppIntent)
        (context as Activity).finish()
        context.overridePendingTransition(0, 0)
    }
}