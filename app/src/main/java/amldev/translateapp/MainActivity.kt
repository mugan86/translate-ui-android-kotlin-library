package amldev.translateapp

import amldev.i18n.LocaleHelper
import android.content.Context
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import org.jetbrains.anko.find

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

    //To use LocaleHelper select language
    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(LocaleHelper.onAttach(base))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val basqueButton: Button = find(R.id.basqueButton)
        val englishButton: Button = find(R.id.englishButton)
        val spanishButton: Button = find(R.id.spanishButton)

        LocaleHelper.setLocale(this, LocaleHelper.getLanguage(this))

        basqueButton.setOnClickListener {
            println("Change to basque" + LocaleHelper.getLanguage(this))
            if (LocaleHelper.getLanguage(this) != "eu") changeLang("eu")
        }

        englishButton.setOnClickListener {
            println("Change to english" + LocaleHelper.getLanguage(this))
            if (LocaleHelper.getLanguage(this) != "en") changeLang("en")
        }

        spanishButton.setOnClickListener {
            println("Change to spanish" + LocaleHelper.getLanguage(this))
            if (LocaleHelper.getLanguage(this) != "es") changeLang("es")
        }



        mTextMessage = find(R.id.message)
        val navigation: BottomNavigationView = find(R.id.navigation)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }



    fun changeLang(lang: String) {
        var changeLanguage: Boolean = false;
        if (lang != LocaleHelper.getLanguage(this)) changeLanguage = true

        if(changeLanguage) {
            LocaleHelper.setLocale(this, lang)
            println("change language from " + LocaleHelper.getLanguage(this) + " to " + lang)
            LocaleHelper.restartApp(this)
        }

    }

}
