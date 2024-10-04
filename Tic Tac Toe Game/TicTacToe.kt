import java.util.Scanner

val board : MutableList<MutableList<String>> = MutableList(3){ MutableList(3) {"__ "} }
val set : HashSet<Int> = HashSet()
val s = Scanner(System.`in`)
var n = 1
var xo = "X"

fun main() {
    println("Welcome to TicTacToe game")
    printBoard(board)
    while(true){
        //printBoard(board)
        println("Player $n turn ( Enter number from 1 to 9): ")
        var pos = s.nextInt()
        if(checkNumber(pos)) {
            printBoard(board, c = xo, pos = pos)
            if (checkWin(board,"X  ")) {
                println("Player $n wins!!!")
                break
            }
        }
        else{
            println("Can't enter number")
            printBoard(board)
            continue
        }
        if(n == 1){
            n++
            xo = "O"
        }
        else{
            n--
            xo = "X"
        }

//        println("Player 2 turn ( Enter number from 1 to 9): ")
//        pos = s.nextInt()
//        if(checkNumber(pos)) {
//            printBoard(board, c = "O", pos = pos)
//            if (checkWin(board,"O  ")) {
//                println("Player 2 wins!!!")
//                break
//            }
//        } else{
//            println("Can't enter number")
//            return
//        }

        if(set.size == 9){
            println("Match Draw")
            break
        }

    }
}

fun checkNumber(pos: Int): Boolean {
    if(set.contains(pos)){
        return false
    }
    set.add(pos)
    return true
}

fun printBoard(board : MutableList<MutableList<String>>, c : String = "__ ", pos : Int = 0) {
    if (pos > 0) {
        val row = (pos - 1) / 3
        val col = (pos - 1) % 3
        board[row][col] = "$c  "
    }

    for (i in 0 until 3) {
        for (j in 0 until 3) {
            print(board[i][j])
        }
        println()
    }
}

fun checkWin(board : MutableList<MutableList<String>>, c: String): Boolean {
    //print(board)
    for(i in 0 until 3){
        if(board[i][0] == c && board[i][1] == c && board[i][2] == c){
            return true
        }
    }
    for(i in 0 until 3){
        if(board[0][i] == c && board[1][i] == c && board[2][i] == c){
            return true
        }
    }
    if(board[0][0] == c && board[1][1] == c && board[2][2] == c){
        return true
    }
    if(board[0][2] == c && board[1][1] == c && board[2][0] == c){
        return true
    }
    return false
}
