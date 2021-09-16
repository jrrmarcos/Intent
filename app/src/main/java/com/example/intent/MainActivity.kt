package com.example.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.example.intent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding

    companion object {
        val PARAMETRO = "PARAMETRO"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        //getSupportActionBar()?.setTitle("Tratando Intents") //Java
        supportActionBar?.title = "Tratando Intents" //Kotlin
        supportActionBar?.subtitle = "Principais tipos"

        Log.v("${getString(R.string.app_name)}/${localClassName}","onCreate: Início CC")
    }

    override fun onStart() {
        super.onStart()
        Log.v("${getString(R.string.app_name)}/${localClassName}","onStart: Início CV")
    }

    override fun onResume() {
        super.onResume()
        Log.v("${getString(R.string.app_name)}/${localClassName}","onResume: Início CPP")
    }

    override fun onPause() {
        super.onPause()
        Log.v("${getString(R.string.app_name)}/${localClassName}","onPause: Fim CPP")
    }

    override fun onStop() {
        super.onStop()
        Log.v("${getString(R.string.app_name)}/${localClassName}","onStop: Fim CV")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("${getString(R.string.app_name)}/${localClassName}","onDestroy: Fim CC")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.outraActivityMi -> {
                //Abrir outra activity
                val outraActivityIntent: Intent = Intent(this, OutraActivity::class.java)

                //Passagem usando Bundle
                val parametrosBundle: Bundle = Bundle()
                parametrosBundle.putString(PARAMETRO, activityMainBinding.parametroEt.text.toString())

                outraActivityIntent.putExtras(parametrosBundle)

                startActivity(outraActivityIntent)
                true
            }
            R.id.viewMi -> {
                //Abrir um navegador
                true
            }
            R.id.callMi -> {
                //Fazer uma chamada
                true
            }
            R.id.dialMi -> {
                //Abrir o discador
                true
            }
            R.id.pickMi -> {
                //Pegar uma imagem
                true
            }
            R.id.chooserMi -> {
                //Abrir listas de aplicativos
                true
            }
            else -> {
                false
            }
        }
    }
}