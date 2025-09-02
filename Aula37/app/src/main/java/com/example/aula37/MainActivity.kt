package com.example.aula37

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aula37.ui.theme.Aula37Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Aula37Theme {
                Column{
                    header()
                    Spacer(modifier = Modifier.height(5.dp))
                    form()
                    Spacer(modifier = Modifier.height(5.dp))
                    nota()
                    Spacer(modifier = Modifier.height(5.dp))
                }
            }
        }
    }
}
@Preview
@Composable
fun header(){
    Scaffold(modifier = Modifier.height(150.dp)) {
        Column(modifier = Modifier.padding(it)){
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(210.dp)
                    .padding(
                        top = 10.dp,
                        bottom = 10.dp,
                        start = 10.dp,
                        end = 10.dp
                    )
                    .border(
                        shape = CircleShape,
                        border = BorderStroke(10.dp, color = Color.LightGray),

                        )
            ) {
                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .width(200.dp)
                        .height(5.dp)
                        .background(shape = CircleShape, color = Color.LightGray)
                        .padding(start = 10.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = "",
                            modifier = Modifier.size(60.dp)

                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "OPAPAPÉPIPÔN",
                            modifier = Modifier.padding(bottom = 25.dp, start = 30.dp, top = 10.dp),
                            style = MaterialTheme.typography.titleLarge
                        )
                    }
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(
                            start = 2.dp,
                            top = 20.dp
                        ),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Garoto de Programa",
                        style = MaterialTheme.typography.labelSmall
                    )
                }
            }
        }
    }
}
@Preview
@Composable
fun nota(){
    Column {
        Surface(modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(
                top = 10.dp,
                bottom = 10.dp,
                start = 10.dp,
                end = 10.dp)
            .border(
                shape = CircleShape,
                border = BorderStroke(10.dp, color = Color.LightGray),

                )
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .width(200.dp)
                    .height(5.dp)
                    .background(shape = CircleShape, color = Color.LightGray)
                    .padding(start = 10.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {

                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "",
                        modifier = Modifier.size(60.dp)
                            .padding(start = 20.dp)


                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = "Levar o gato pro karatê",
                        modifier = Modifier.padding(start = 30.dp),
                        style = MaterialTheme.typography.bodySmall)
                    Icon(
                        imageVector = Icons.Default.Create,
                        contentDescription = "",
                        modifier = Modifier.size(100.dp)
                            .padding(start = 70.dp)


                    )
                }
            }
        }
    }
}

@Composable
fun form(onSubmit: (String) -> Unit){

    var nota by remember {
        mutableStateOf("nota")
    }

    Surface(modifier = Modifier
        .width(500.dp)
        .height(100.dp)
        .padding(
            top = 10.dp,
            bottom = 10.dp,
            start = 10.dp,
            end = 10.dp)
    ) {
        Row() {
            TextField(
                modifier = Modifier
                    .padding(top    = 10.dp,
                        start  = 15.dp,
                        end    = 5.dp
                    ).
                    width(255.dp),
                value = nota,
                onValueChange = {
                    nota = it
                }
            )
            Botao(
                OnClick = {
                    onSubmit(nota)
                    nota = ""
                }
            )
        }
    }
}

fun notas(){

}

@Composable
private fun Botao(OnClick: () -> Unit) {


    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        Column {
            Button(
                modifier = Modifier.
                fillMaxWidth().
                padding(top = 15.dp),
                onClick = {Log.d("apertou", "o botaum")},
            ){
                Text("Botaum")
            }
        }
    }
}
