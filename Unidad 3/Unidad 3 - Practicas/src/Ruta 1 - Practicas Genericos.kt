class FillInTheBlankQuestion (val questionText: String, val answer: String, val difficulty: String,
)

class TrueOrFalseQuestion (val questionText: String, val answer: Boolean, val difficulty: String,
)

class NumericQuestion (val questionText: String, val answer: Int, val difficulty: String,
)

// Uso de clases genericas
data class Question<T>(val questionText: String, val answer: T, val difficulty: Difficulty) {
    // Posibilidad de recuperacion de datos
    /*
    override fun toString(): String {
        return "Question('$questionText', '$answer', '$difficulty')"
    }

     */
}

enum class Difficulty {
    EASY, MEDIUM, HARD
}

object StudentProgress {
    var total: Int = 10
    var answered: Int = 3
}

interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()
}

class Quiz : ProgressPrintable {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?",28, Difficulty.HARD)

    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }

    override val progressText: String
        get() = "${answered} of ${total} answered."

    override fun printProgressBar() {
        repeat(Quiz.answered) {
            print("▓")
        }
        repeat(Quiz.total - Quiz.answered) {
            print("▒")
        }
        println()
        println(progressText)
    }

    fun printQuiz() {
        question1.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question2.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question3.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
    }
}
/*
val Quiz.StudentProgress.progressText: String
    get() = "${answered} of ${total} answered."



override val progressText: String
    get() = "${answered} of ${total} answered."

fun Quiz.StudentProgress.printProgressBar (){
    repeat(Quiz.answered) {
        print("▓")
    }
    repeat(Quiz.total - Quiz.answered) {
        print("▒")
    }
    println()
    println(Quiz.progressText)
}

 */

fun main() {
    /*
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?",28, Difficulty.HARD)
    println(question1).toString()
    println(question2).toString()
    println(question3).toString()
    **
    **
    println("${StudentProgress.answered} of ${StudentProgress.total} answered.")

    println("${Quiz.answered} of ${Quiz.total} answered.")

     */
    // println(Quiz.progressText)
    // Quiz.printProgressBar()

    Quiz().printProgressBar()
    Quiz().apply { printQuiz() }
}