package com.example.aula37

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aula37.ui.theme.Aula37Theme
import com.example.aula37.ui.theme.MainActivity


class TelaTarefas : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Aula37Theme {
                Column{
                    TelaDeTarefas()
                    Spacer(modifier = Modifier.height(5.dp))
                    Cabecalho()
                    Spacer(modifier = Modifier.height(5.dp))
                    //Tarefa
                    Spacer(modifier = Modifier.height(5.dp))
                    Formulario {  }
                }
            }
        }
    }
}
data class Tarefa(var status:Boolean, var texto : String)

@Preview
@Composable
fun TelaDeTarefas(){

    var tarefas = remember {
        mutableStateListOf(Tarefa(false, "estudar"),
                           Tarefa(true, "morrer"))
    }

    Scaffold {
            innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 5.dp)
        ) {

            Cabecalho()
            Spacer(modifier = Modifier.height(5.dp))

            Formulario(
                aoAdicionar = {
                        novaNota ->
                    tarefas.add(Tarefa(false, novaNota))
                }
            )

            Spacer(modifier = Modifier.height(5.dp))

            LazyColumn {
                items(count = tarefas.size) {
                    Tarefa(tarefas[it], aoPressionar = {tarefas[it].status = !tarefas[it].status}, onHold = {tarefas.remove(tarefas[it])})
                    Spacer(modifier = Modifier.height(5.dp))
                }
            }
        }
    }
}


@Preview
@Composable
fun Cabecalho(){

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    ){

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Outlined.Person,
                contentDescription = "Icone perfil",
                modifier = Modifier.size(60.dp)
            )

            Column {

                Text(
                    text = "José Silveira",
                    style = MaterialTheme.typography.headlineLarge
                )

                Text(
                    text = "Melhor Programador",
                    style = MaterialTheme.typography.bodySmall
                )

            }
        }

    }

}

// @ Preview
@Composable
fun Formulario(aoAdicionar: (String) -> Unit){

    var context = LocalContext.current

    var textoInput by remember {
        mutableStateOf("")
    }

    Row {

        TextField(
            value = textoInput,
            onValueChange = { textoInput = it }
        )

        Spacer(modifier = Modifier.width(5.dp))

        Button(
            onClick = {
                // pegar a var textoInput
                // add ela no array
                aoAdicionar(textoInput)
                textoInput = ""
            }
        ) {

            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Icone Add"
            )

            Text("Add")

        }
        Button(
            onClick = {
                val intent = Intent(context, MainActivity::class.java)
                context.startActivity(intent)
            }
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Icone Add",
                modifier = Modifier.size(20.dp)
            )
        }


    }

}

//@Preview
@Composable
fun Tarefa(objTarefa: Tarefa, aoPressionar : () -> Unit, onHold : () -> Unit){

    // onClick -> apagar
    // onHold -> mudar ---- classe Tarefa(string, icon)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        onClick = {
            aoPressionar()
        },
    ) {

        Row (
            modifier = Modifier.fillMaxHeight().padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ){

            Icon(
                imageVector = if(objTarefa.status )Icons.Outlined.Check else Icons.Outlined.Close,
                contentDescription = "Icon Fav"
            )

            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = objTarefa.texto,
                style = MaterialTheme.typography.bodyLarge
            )
        }

    }

}
