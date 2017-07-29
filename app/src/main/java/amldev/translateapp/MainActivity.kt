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
import android.content.Intent



class MainActivity : AppCompatActivity() {

    private var mTextMessage: TextView? = null
    private var startLanguageSelect: String? = null
    private val myLocale: Locale? = null

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

        startLanguageSelect = getLocaleLanguage(this)
        println("46 ${getLocaleLanguage(this)}")

        loadLocale(this, getLocaleLanguage(this))

        basqueButton.setOnClickListener {
            println("Change to basque" + getLocaleLanguage(this))
            if (getLocaleLanguage(this) != "eu") changeLang("eu")
        }

        englishButton.setOnClickListener {
            println("Change to english" + getLocaleLanguage(this))
            if (getLocaleLanguage(this) != "en") changeLang("en")
        }

        spanishButton.setOnClickListener {
            println("Change to spanish" + getLocaleLanguage(this))
            if (getLocaleLanguage(this) != "es") changeLang("es")
        }



        mTextMessage = find(R.id.message)
        val navigation: BottomNavigationView = find(R.id.navigation)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    fun getLocaleLanguage(context: Context): String {
        return context.getSharedPreferences("LanguageDefaultPreferences", Activity.MODE_PRIVATE).getString("Language", "")
    }

    fun loadLocale(context: Context, lang: String) {

        val myLocale = Locale(lang)
        saveLocale(lang, context)
        Locale.setDefault(myLocale)
        val config = android.content.res.Configuration()
        config.locale = myLocale
        context.getResources().updateConfiguration(config, context.getResources().getDisplayMetrics())
        // changeLang(lang, context)
    }

    fun changeLang(lang: String?) {
        var changeLanguage: Boolean = false;
        if (lang != getLocaleLanguage(this)) changeLanguage = true

        if(changeLanguage) {
            saveLocale(lang, this);
            restarApp()
        }

    }

    private fun saveLocale(lang: String?, context: Context) {
        val langPref = "Language"
        val prefs = context.getSharedPreferences("LanguageDefaultPreferences", Activity.MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putString(langPref, lang)
        editor.commit()
    }

    fun restarApp() {
        /*val restart_app_intent = Intent(context, MainActivity::class.java)
        restart_app_intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(restart_app_intent)
        (context as Activity).finish()*/

        val intent = intent
        overridePendingTransition(0, 0)
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        finish()

        overridePendingTransition(0, 0)
        startActivity(intent)
    }

}
