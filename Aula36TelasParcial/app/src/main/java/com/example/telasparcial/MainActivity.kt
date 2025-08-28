package com.example.telasparcial

import android.os.Bundle
import android.text.style.BackgroundColorSpan
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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.example.telasparcial.ui.theme.TelasParcialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TelasParcialTheme {
                Column {
                    SearchBar()
                    Spacer(modifier = Modifier.height(5.dp))
                    Surface() {

                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun Button() {

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        Column {
//            Text("Contador: $contador")
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 15.dp,
                        end = 5.dp
                    ),
                shape = ButtonDefaults.filledTonalShape,
                onClick = {
                    Log.d("Eae Delicia", "Vc se Cadastrou")
                }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "",
                    modifier = Modifier.size(40.dp)
                )
            }
        }

    }
}

@Preview
@Composable
fun SearchBar() {

    var contactName by remember {
        mutableStateOf("Pesquisar")
    }

    Surface(
        modifier = Modifier
            .width(600.dp)
            .height(100.dp)
            .padding(
                top = 10.dp,
                bottom = 10.dp,
                start = 10.dp,
                end = 10.dp
            )
    ) {
        Row() {
            TextField(

                modifier = Modifier
                    .padding(
                        top = 10.dp,
                        bottom = 10.dp,
                        start = 15.dp,
                        end = 5.dp
                    ),
                value = contactName,
                onValueChange = {
                    contactName = it
                }
            )
            Button()
        }
    }

}

@Preview(showBackground = true)
@Composable
fun RecentContactCard() {
    Scaffold {
        Column(modifier = Modifier.padding(it)) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp)
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
                            text = "NomeContato",
                            modifier = Modifier.padding(bottom = 30.dp, start = 30.dp, top = 20.dp),
                            style = MaterialTheme.typography.titleLarge
                        )
                    }
                }
            }
        }
    }
}