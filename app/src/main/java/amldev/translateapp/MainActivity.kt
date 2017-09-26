package amldev.translateapp

import amldev.i18n.LocaleHelper
import android.content.Context
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message!!.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                message!!.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                message!!.setText(R.string.title_notifications)
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

        LocaleHelper.setLocale(this, LocaleHelper.getLanguage(this))

        basqueButton.setOnClickListener {
            println("Change to basque" + LocaleHelper.getLanguage(this))
            if (LocaleHelper.getLanguage(this) != "eu") LocaleHelper.setLocale(this, "eu")
        }

        englishButton.setOnClickListener {
            println("Change to english" + LocaleHelper.getLanguage(this))
            if (LocaleHelper.getLanguage(this) != "en") LocaleHelper.setLocale(this, "en")
        }

        spanishButton.setOnClickListener {
            println("Change to spanish" + LocaleHelper.getLanguage(this))
            if (LocaleHelper.getLanguage(this) != "es") LocaleHelper.setLocale(this, "es")
        }

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
