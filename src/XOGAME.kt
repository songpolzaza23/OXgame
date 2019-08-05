var round = 1
var player = 'O'
var OX = true
var rowInd = 0
var colInd = 0
val table = arrayOf(
    arrayOf(' ', '1', '2' , '3'),
    arrayOf('1', '-', '-' , '-'),
    arrayOf('2', '-', '-' , '-'),
    arrayOf('1', '-', '-' , '-')
)

fun printWelcome() {
    println("Welcome to OX game")
}

fun printTable() {
    for (row in table) {
        println()
        for (col in row) {
            print("$col")
        }
    }
    println()
}

fun printTurn() {
    if (round % 2 == 1) {
        player = 'X'
    } else {
        player = 'O'
    }
    println("$player turn")
}

fun checkWin(){
    while (true) {
        for (i in 1..3) {
            if (table[i][1] == player && table[i][2] == player && table[i][3] == player) {
                println("------------------ Player $player Win-------------------")
                println("--------------------------------------------------")
                OX = false
                printTable()
                break
            }
        }
        for (i in 1..3) {
            if (table[1][i] == player && table[2][i] == player && table[3][i] == player) {
                println("------------------ Player $player Win-------------------")
                println("--------------------------------------------------")
                OX = false
                printTable()
                break
            }
        }
        if (table[1][1] == player && table[2][2] == player && table[3][3] == player) {
            println("------------------ Player $player Win-------------------")
            println("--------------------------------------------------")
            OX = false
            printTable()
        }
        if (table[1][3] == player && table[2][2] == player && table[3][1] == player) {
            println("------------------ Player $player Win-------------------")
            println("--------------------------------------------------")
            OX = false
            printTable()
        }
        break
    }
}

fun main() {
    printWelcome()
    while (OX) {
        print("Round $round")
        printTable()
        printTurn()
        print("Please input Row Col: ")
        var input: String? = readLine()
        var rcList :List<String>? = input?.split(" ")
        if (rcList?.size != 2){
            println("Error: Must input 2 numbers Row Col (Ex: 1 2)")
            continue
        }
        rowInd = rcList[0].toInt()
        colInd = rcList[1].toInt()
        if (rowInd >= 4 || colInd >= 4){
            println("--------------------------------------------------")
            println("--Number must less than 4. You must input again---")
            println("--------------------------------------------------")
            continue
        }
        if (table[rowInd][colInd].equals('X') || table[rowInd][colInd].equals('O')) {
            println("--------------------------------------------------")
            println("Please input again. Because position has been used")
            println("--------------------------------------------------")
            continue
        }
        println("Row ${rcList?.get(0)} col ${rcList?.get(1)}")
        println("--------------------------------------------------")
        table[rowInd][colInd] = player
        checkWin()
        round++;

    }

}

