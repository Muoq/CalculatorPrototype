
fun main(args: Array<String>) {
//    val exp1 = Expression("1 + 2 * (3 - 4 + (4 / 2)) - 5")

    val exp1 = Expression("3*4*5+6-21/3*9 + 45/9-3- 127*24")

    val solver = Solver()
    println(solver.solve(exp1))
}
