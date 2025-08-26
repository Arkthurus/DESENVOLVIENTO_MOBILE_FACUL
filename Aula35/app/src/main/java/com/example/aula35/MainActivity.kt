package com.example.aula35

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.aula35.ui.theme.Aula35Theme
import com.example.aula35.ui.theme.Tela2

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Aula35Theme {
                Column {
                    minhaTela()

                }
            }
        }
    }
}

@Composable
@Preview
fun minhaTela(){

    Scaffold {
        var context = LocalContext.current

        Column(
            modifier = Modifier.padding(it)
        ) {
            Text("Tela01")
            buttonTest(context)
            SwichScreen(context)
            SwichScreenWithInfo(context)
        }
    }
}

@Composable
private fun SwichScreen(context: Context) {
    Button(
        onClick = {
            val intent = Intent(context, Tela2::class.java)
            context.startActivity(intent)
        }
    ) {
        Text("Mudar tela")
    }
}

@Composable
private fun buttonTest(context: Context) {
    Button(
        onClick = {
            Toast.makeText(context, "Testando Botão", Toast.LENGTH_SHORT).show()
        }
    ) {
        Text("Teste Botão")
    }
}

@Composable
private fun SwichScreenWithInfo(context: Context) {

    val nameItem = "Douglas Del Lago"

    Button(
        onClick = {
            val intent = Intent(context, Tela2::class.java)

            intent.putExtra("Nome", nameItem)

            context.startActivity(intent)
        }
    ) {
        Text("Mudar tela 2")
    }
}