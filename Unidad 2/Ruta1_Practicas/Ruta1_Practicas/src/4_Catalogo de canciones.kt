fun main() {
    val description = Song("It´s my life","Bon Jovi",1993,15000)
    description.descriptionSong()
    println(description.popularity)
}

class Song(val title: String, val artist: String, val year: Int, val reproducciones: Int){

    val popularity: Boolean
        get() = reproducciones >= 1000

    fun descriptionSong(){
        println("$title, interpretada por $artist, se lanzo en $year")
    }
}