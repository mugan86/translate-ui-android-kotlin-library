package amldev.i18n

import android.content.Context

/***************************************************************************************************
 * Created by Anartz Mugika on 12/9/17.
 *
 * Return language name after pass get preference language value.
 **************************************************************************************************/
enum class Language {
    SELECT;

    fun getLanguageName(lang: String, context: Context): String {
        when (this) {
            SELECT -> return findLanguageNameWithLanguageCode(lang, context)
            else -> return context.resources.getString(R.string.english)
        }
    }
    private fun findLanguageNameWithLanguageCode(lang: String, context: Context): String {
        if (lang.equals("eu")) {
            return context.resources.getString(R.string.basque)
        } else if (lang.equals("es")) { return context.resources.getString(R.string.spanish) }
        return context.resources.getString(R.string.english)
    }

}