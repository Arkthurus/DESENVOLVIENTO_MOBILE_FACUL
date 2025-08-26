package com.example.aula35.ui.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.aula35.ui.theme.ui.theme.Aula35Theme

class Tela2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Aula35Theme {
               Column {
                   Text("Segunda Tela - Yupi \\o/")

                   val itemReceived = intent.getStringExtra("Nome")

                   if (itemReceived!= null){
                       Text("nome recebido: $itemReceived")
                   }else Text("item n recebido );")

               }
            }
        }
    }
}

