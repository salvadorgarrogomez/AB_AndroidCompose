fun main() {
    val amanda = Person("Amanda", 33,"play tennis", null)
    val atiqah = Person("Atiqah", 33,"climb", amanda)

    amanda.showProfile()
    atiqah.showProfile()
}

class Person(val name: String, var age: Int, val hobby: String?, val referrer: Person?) {
    fun showProfile(){
        println("Name: $name")
        println("Age: $age")
        if (hobby != null){
            print("Likes to $hobby. ")
        }
        if (referrer != null) {
            print("Has a referrer named ${referrer.name}")
            if (referrer.hobby != null) {
                println(", who likes to ${referrer.hobby}.\n")
            }
        } else {
            println("Doesn't have a referrer.\n")
        }
    }
}
