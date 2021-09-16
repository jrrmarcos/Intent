package com.example.intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.intent.databinding.ActivityMainBinding
import com.example.intent.databinding.ActivityOutraBinding

class OutraActivity : AppCompatActivity() {
    private val activityOutraBinding: ActivityOutraBinding by lazy {
        ActivityOutraBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityOutraBinding.root)

        supportActionBar?.title = "Outra Activity" //Kotlin
        supportActionBar?.subtitle = "Recebe e retorna um valor"

        val parametrosBundle = intent.extras
        if(parametrosBundle != null) {
            val recebido = parametrosBundle.getString(MainActivity.PARAMETRO,"")
            activityOutraBinding.recebidoTv.text = recebido
        }
        activityOutraBinding.retornarBt.setOnClickListener{
            finish()
        }

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
}