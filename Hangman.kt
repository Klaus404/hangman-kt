import kotlin.random.Random

val words = listOf("castravete", "muratura", "cal", "animal", "caine", "sabie", "cingatoare", "naparca",
"dihor", "bomba", "lamaie", "magazin", "chibrit", "pancreas", "cuvant", "castig")
var word = ""
val guesses = arrayListOf<Char>()
var remainingGuesses = 6
var mistakes = 0

fun main() {
    setupGame()
}

fun setupGame() {
    val wordIndex = Random.nextInt(words.size)
    word = words[wordIndex].uppercase()

    for(i in word.indices)
        guesses.add('_')

    var gameOver = false
    do{
        printGameStatus()
        println("Please enter a letter: ")
        val input = readln()?:""

        if(input.isEmpty()) {
            println("That's not a valid input, please try again")
        }
        else{
            val letter = input[0].uppercase()
            if(word.contains(letter)){
                for(i in word.indices){
                    if (word[i].toString() == letter)
                        guesses[i] = letter.first()
                }
                if(!guesses.contains('_')) {
                    gameOver = true
                    println("YOU GUESSED THE WORD!")
                }
            }
            else{
                println("Sorry, that's not part of the word")
                remainingGuesses--
                mistakes++
                if (mistakes == 6)
                    gameOver = true


            }
        }


    } while (!gameOver)

    if(mistakes == 6){
        printGameStatus()

    }
}

fun printGameStatus(){
    when(mistakes){
        0 -> printZeroMistakes()
        1 -> printOneMistake()
        2 -> printTwoMistake()
        3 -> printThreeMistake()
        4 -> printFourMistake()
        5 -> printFiveMistake()
        6 -> printSixMistake()
    }

    print("Word: ")
    for(element in guesses)
        print("$element ")
    println("\n You have $remainingGuesses guess(es) left.")
}



fun printZeroMistakes(){
    println("   |------|-")
    println("   |      |")
    println("   |        ")
    println("   |        ")
    println("   |        ")
    println("   |        ")
    println("  /|\\     ")
    println(" / | \\    ")
    println()
}

fun printOneMistake()
{
    println("   |------|-")
    println("   |      |")
    println("   |      O ")
    println("   |        ")
    println("   |        ")
    println("   |        ")
    println("  /|\\     ")
    println(" / | \\    ")
    println()
}

fun printTwoMistake()
{
    println("   |------|-")
    println("   |      |")
    println("   |      O ")
    println("   |      | ")
    println("   |      | ")
    println("   |        ")
    println("  /|\\     ")
    println(" / | \\    ")
    println()
}

fun printThreeMistake()
{
    println("   |------|-")
    println("   |      |")
    println("   |      O ")
    println("   |     /| ")
    println("   |      | ")
    println("   |        ")
    println("  /|\\     ")
    println(" / | \\    ")
    println()
}

fun printFourMistake()
{
    println("   |------|-")
    println("   |      |")
    println("   |      O ")
    println("   |     /|\\ ")
    println("   |      | ")
    println("   |        ")
    println("  /|\\     ")
    println(" / | \\    ")
    println()
}

fun printFiveMistake()
{
    println("   |------|-")
    println("   |      |")
    println("   |      O ")
    println("   |     /|\\ ")
    println("   |      | ")
    println("   |     /   ")
    println("  /|\\     ")
    println(" / | \\    ")
    println()
}

fun printSixMistake()
{
    println("   |------|-")
    println("   |      |")
    println("   |      O ")
    println("   |     /|\\ ")
    println("   |      | ")
    println("   |     / \\  ")
    println("  /|\\     ")
    println(" / | \\    ")
    println("GAME OVER :(")
    println()
    println("The word was $word")
}