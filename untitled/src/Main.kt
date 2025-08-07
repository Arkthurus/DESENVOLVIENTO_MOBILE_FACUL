import java.util.ArrayList

fun main() {
    var numeros   = listOf(10,15,20,25,30,35,40,45,50)
    println("Lista Original: ")
    println(numeros)
    println("----------------------")
    var numerosX2 = numeros.map{ it * 2}
    println("Lista x2: ")
    println(numerosX2)
    println("----------------------")
    var numeros30UP = numeros.filter { it > 30 }
    println("Lista Maiore de 30: ")
    println(numeros30UP)
    println("----------------------")
    var numerosAmigos= numeros.forEachIndexed { i , number ->  println("numero " + (i+1)+ " = " + number) }

    //-----------------------------------------------------------------------------------------------------//

    class Produto( var tarefa: String, var status: Boolean){
        ArrayList<>()
    }





}