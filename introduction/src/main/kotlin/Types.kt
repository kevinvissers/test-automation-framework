/**
 * Basic Types
 */
fun main() {

    // Integers

    val int: Int = 15
    val long: Long = 15L
    val short: Short = 15
    val byte: Byte = 15

    // Floating point

    val double: Double = 15.0
    val float: Float = 15.0F

    val inferredFloat = 15.0f
    println(inferredFloat::class.qualifiedName)

    // Text

    val string: String = "A string"
    val char: Char = 'A'

    // Special notations

    val hex: Byte = 0x0F
    val bin: Byte = 0b0001111

    val oneMillion = 1_000_000
    val creditCard = 1234_5678_9101_1121L
    val hexFormatted = 0xFF_EC_DE_5E
    val binFormatted = 0b11110000_11001100_10011001_00100010

    val uByte: UByte = 0b00001111U

}
