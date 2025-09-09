package com.example.aula39

import android.widget.Button
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.w3c.dom.Text


@Composable
fun AppNav() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "tela1"){
        composable("tela1"){Tela1(navController)}
        composable("tela2/{nome}"){
            backstackEntry ->
            val nome = backstackEntry.arguments?.getString("nome")?:"Desnomeado"
            Tela2(
                nome = nome,
                onBack = {
                    navController.popBackStack()
                }
            )}
    }
}
@Composable
fun Tela1(navController: NavController){

    val nome = "Jackneildon"

    Button(
        onClick = {
            navController.navigate("tela2/$nome")
        }
    ){
        Text("Abrir Tela 2")
    }
}

@Composable
fun Tela2(nome : String, onBack: () -> Unit){

    Text("Bem Vindo $nome")

    Button(
        onClick = onBack
    ){
        Text("Abrir Tela 1")
    }
}

