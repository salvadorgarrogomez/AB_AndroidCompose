val trick = {
    print("No treats\n")
}

val treat: () -> Unit = {
    print("Have a treat!\n")
}

fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
    if (isTrick) {
        return trick
    } else {
        if (extraTreat != null) {
            print(extraTreat(5))
        }
        return treat
    }
}

fun main() {
    /*
    val coins: (Int) -> String = {
        "$it quarters\n"
    }

    val cupcake: (Int) -> String = {
        "Have a cupcake"
    }

     */
    val treatFunction = trickOrTreat(false) {
        "$it quarters\n"
    }
    val trickFunction = trickOrTreat(true, null)

    repeat(4) {
        treatFunction()
    }
    trickFunction()
}