data class Neighbor{
    val id: Long;
    val name: String;
    val avatarUrl: String;
    val address
    val phoneNumber
    val about
}


fun String.concat(text: String){
    println(text)
}
val maString = "Ma string"
maString.concat(text:"Hello")

fun Neighbor.fullName() = "$first"