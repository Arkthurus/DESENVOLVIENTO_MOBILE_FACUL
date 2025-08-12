package com.example.arthurosoriomobile

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.example.arthurosoriomobile.ui.theme.ArthurOsorioMobileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            primeiraTela()
        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun primeiraTela(){
    Scaffold {
        Column {
            Row {
                bloco()
                bloco()
            }
            Row {
                bloco()
                bloco()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun bloco(){
        Column {
            Surface(color = Color.DarkGray,
                modifier = Modifier.width(200.dp).height(55.dp),
                shadowElevation = 80.dp,
                tonalElevation = 4.dp
            ){
                Text(text = "     NOTA 1",
                    color = Color.LightGray,
                    style = MaterialTheme.typography.titleLarge,
                    fontSize = TextUnit(28f, TextUnitType.Sp)
                )
            }

            Surface(color = Color.Gray,
                modifier = Modifier.width(200.dp).height(300.dp).padding( start = 0.dp),
                shadowElevation = 80.dp,
                tonalElevation = 4.dp
            ){
                Text(text = "bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla ",
                    color = Color.LightGray,
                    style = MaterialTheme.typography.titleLarge,
                    fontSize = TextUnit(28f, TextUnitType.Sp)
                )
            }
        }

}

