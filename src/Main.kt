
fun main(args: Array<String>) {
    val exp1 = Expression("1 + 2 * (3 - 4 + (4 / 2)) - 5")

    println(exp1.toString())

    exp1.removeLast()
    exp1.removeAt(exp1.size - 1)

    println(exp1.toString())

    for (i in 0 until exp1.size) {
        print((exp1.expression[i] is Operator).toString() + " ")
    }
    println("")
    for (i in 0 until exp1.size) {
        print((exp1.expression[i] is Int).toString() + " ")
    }
    println("\n" + exp1.size)
}
