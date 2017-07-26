package amldev.translateapp

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import org.jetbrains.anko.find
import java.util.*


class MainActivity : AppCompatActivity() {

    private var mTextMessage: TextView? = null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                mTextMessage!!.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                mTextMessage!!.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                mTextMessage!!.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val basqueButton: Button = find(R.id.basqueButton)
        val englishButton: Button = find(R.id.englishButton)
        val spanishButton: Button = find(R.id.spanishButton)

        basqueButton.setOnClickListener {
            println("Change to basque")
            changeLang("eu", this)
        }

        englishButton.setOnClickListener {
            println("Change to english")
            changeLang("en", this)
        }

        spanishButton.setOnClickListener {
            println("Change to spanish")
            changeLang("es", this)
        }



        mTextMessage = find(R.id.message)
        val navigation: BottomNavigationView = find(R.id.navigation)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    fun getLocaleLanguage(context: Context): String {
        val langPref = "Language"
        val prefs = context.getSharedPreferences("LanguageDefaultPreferences", Activity.MODE_PRIVATE)
        return prefs.getString(langPref, "")
    }

    fun loadLocale(context: Context) {
        val langPref = "Language"
        val prefs = context.getSharedPreferences("LanguageDefaultPreferences", Activity.MODE_PRIVATE)
        val language = prefs.getString(langPref, "")
        changeLang(language, context)
    }

    fun changeLang(lang: String, context: Context) {
        if (lang == (""))
            return
        val myLocale = Locale(lang)
        saveLocale(lang, context)
        Locale.setDefault(myLocale)
        val config = android.content.res.Configuration()
        config.locale = myLocale
        context.getResources().updateConfiguration(config, context.getResources().getDisplayMetrics())
    }

    private fun saveLocale(lang: String, context: Context) {
        val langPref = "Language"
        val prefs = context.getSharedPreferences("LanguageDefaultPreferences", Activity.MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putString(langPref, lang)
        editor.commit()
    }

}
