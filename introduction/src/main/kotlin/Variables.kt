/**
 * Basic usage of variables
 */
fun main(args: Array<String>) {

    // Immutable variable

    val readOnlyVariable: String = "I'm a read only variable"

    // Below line will result in an error
    // readOnlyVariable = "Some other text"

    // Mutable variable

    var writeableVariable: String = "I'm a writeable variable"
    writeableVariable = "Some other text"


    // Inferred type

    val inferredVariable = "I know I'm a String"
    println(inferredVariable::class.qualifiedName)

    // Objects

    val list = mutableListOf("hello")
    list.add("world")

}
