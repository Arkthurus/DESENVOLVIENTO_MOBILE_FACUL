package com.example.aula37.ui.theme

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aula37.TelaDeTarefas
import com.example.aula37.TelaTarefas
import com.example.aula37.ui.theme.ui.theme.Aula37Theme
import com.google.android.material.color.utilities.Variant

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Aula37Theme {
                Scaffold {
                    Surface {
                        var context = LocalContext.current
                        Column(modifier = Modifier.padding(it)) {
                            botaosssssss(context)
                        }
                    }
                }
            }
        }
    }
}

    @Composable
    private fun botaosssssss(context: Context) {
        Column {
            var telaTarefas = TelaTarefas::class.java
            Spacer(modifier = Modifier.height(20.dp))
            Botao(context, telaTarefas)
        }
    }


@Composable
private fun <T : Activity>Botao(context:Context, direcionamento: Class<T>) {
    Column {
        Button(
            modifier = Modifier
                .width(150.dp)
                .height(60.dp)
                .padding(
                    top = 15.dp,
                    end = 5.dp,
                    bottom = 10.dp
                ),
            shape = ButtonDefaults.filledTonalShape,
            onClick = {
                val intent = Intent(context, direcionamento)
                context.startActivity(intent)
            }) {

            Icon(
                imageVector = Icons.Default.DateRange,
                contentDescription = "",
                modifier = Modifier.size(70.dp)
            )
        }
    }
}