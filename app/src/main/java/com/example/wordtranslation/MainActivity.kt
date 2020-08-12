package com.example.wordtranslation

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import org.w3c.dom.Text
import java.util.*


class MainActivity : AppCompatActivity() {
    lateinit var word: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        word=findViewById(R.id.tvWordToTranslate)
    }

    fun translateWord(view: View) {

        var button=findViewById<Button>(view.id)



        when(button.id){
            R.id.btnToFrench->{
                translateWord("fr")
                word.text=baseContext.resources.getString(R.string.wordToTranslate)
            }
            R.id.btnToSpanish->{
                translateWord("es")
                word.text=baseContext.resources.getString(R.string.wordToTranslate)
            }

            R.id.btnToEnglish->{
                translateWord("en")
                word.text=baseContext.resources.getString(R.string.wordToTranslate)
            }
        }
    }

    private fun translateWord(language:String){
        var local=Locale(language)
        var config=Configuration()
        Locale.setDefault(local)
        config.locale = local
        baseContext.resources.updateConfiguration(
            config,
            baseContext.resources.displayMetrics
        )
    }
}