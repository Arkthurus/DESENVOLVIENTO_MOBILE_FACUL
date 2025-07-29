import java.util.Scanner
fun main() {
    var sc = Scanner(System.`in`)
    val name = "Kotlin"
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    println("Altura?")
    var linhas = sc.nextInt()
    println("Largura?")
    var colunas = sc.nextInt()

    tabuleiro(linhas, colunas, sc)

}
fun tabuleiro(linhas: Int, colunas: Int, sc: Scanner){
    for (i in 0 until linhas) {
        //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
        // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
        for (l in 0 until colunas){
            print("[.]")
        }
        println()
    }
    println("Digite as cordenadas(x=altura/y=largura):")
    print("x=")
    var x = sc.nextInt()
    print("y=")
    var y = sc.nextInt()
    for (i in 0 until linhas) {
        for (l in 0 until colunas){
            if (i==(x-1)&& l==(y-1)){
                print("[X]")
            }else{
            print("[.]")}
        }
        println()
    }
}
