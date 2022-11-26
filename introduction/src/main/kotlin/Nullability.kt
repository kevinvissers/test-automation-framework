/**
 * Nullability & Null safety
 */
fun main() {

    // compilation error
    // val nonNullableString: String = null

    // Nullable variable

    var nullableString: String? = null
    nullableString = "Not null anymore"

    var nullableInt: Int? = 5
    nullableInt = null


    // Null safety

    val counter: Int? = 5

    //val inc = counter.plus(5) // Compilation error

    // Safe call
    val incSafe: Int? = counter?.plus(5)
    println(incSafe)

    // Elvis
    val incElvis: Int = counter?.plus(5) ?: 0
    println(incElvis)

    // "double Exclamation mark" operator
    val incExclamation: Int = counter!!.plus(5)
    println(incExclamation)

}
