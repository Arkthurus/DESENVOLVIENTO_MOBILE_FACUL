package com.example.aula3

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aula3.ui.theme.Aula3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {


            TelaForm()


        }
    }
}

@Composable
@Preview
fun TelaForm() {

    var nome by remember {
        mutableStateOf("nome")
    }
    var email by remember {
        mutableStateOf("email")
    }
    var pass by remember {
        mutableStateOf("senha")
    }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
            .padding(top = 30.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally){
            Text( text = "Cadastro")

            TextField(
                modifier = Modifier
                    .padding(top = 15.dp)
                    .fillMaxWidth(),
                value = nome,
                onValueChange = {
                    nome = it
                }
            )

            TextField(
                modifier = Modifier
                    .padding(top = 15.dp)
                    .fillMaxWidth(),
                value = email,
                onValueChange = {
                    email = it
                }
            )
            TextField(
                modifier = Modifier
                    .padding(top = 15.dp)
                    .fillMaxWidth(),
                value = pass,
                onValueChange = {
                    pass = it
                }
            )
            Botao()
        }
    }
}

@Preview
@Composable
fun Botao() {

    var contador by remember {
        mutableStateOf(0)
    }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        Column {
//            Text("Contador: $contador")
            Button(modifier = Modifier.fillMaxWidth().padding(top = 15.dp), onClick = {
                Log.d("Eae Delicia", "Vc se Cadastrou")
            }) {
                Text("N aperta o BOTÃO")
            }
        }

    }
}