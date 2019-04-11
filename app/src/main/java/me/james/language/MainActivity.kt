package me.james.language

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import java.util.*


class MainActivity : AppCompatActivity() {

    companion object {
        private const val CHINESE_SIMPLIFIED = 1
        private const val CHINESE_TRADITIONAL = 2
        private const val ENGLISH_US = 3
    }

    private var language by Preference("locale_lau", 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        simplified_chinese.setOnClickListener {
            language = CHINESE_SIMPLIFIED
            switchLanguage(CHINESE_SIMPLIFIED)
        }
        traditional_chinese.setOnClickListener {
            language = CHINESE_TRADITIONAL
            switchLanguage(CHINESE_TRADITIONAL)
        }
        english_us.setOnClickListener {
            language = ENGLISH_US
            switchLanguage(ENGLISH_US)
        }
    }

    private fun switchLanguage(languageCode:Int){
        val resources = resources
        val config = resources.configuration
        val dm = resources.displayMetrics

        if (languageCode == CHINESE_SIMPLIFIED) {
            config.locale = Locale.SIMPLIFIED_CHINESE
        } else if (languageCode == CHINESE_TRADITIONAL) {
            config.locale = Locale("zh", "HK")
        } else if(languageCode == ENGLISH_US){
            config.locale = Locale.US
        }else{
            config.locale = Locale.getDefault()
        }
        resources.updateConfiguration(config, dm)

        //更新语言后，destroy当前页面，重新绘制

        finish()

        val it = Intent(this@MainActivity, MainActivity::class.java)
        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(it)
    }
}
