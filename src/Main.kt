
fun main(args: Array<String>) {
//    val exp1 = Expression("3*4-(4+5-3-81/9/3*7*(31-16+(7-5) + (3 + 6)) + 5*4 - 2) - 3")

    val exp1 = Expression("3r343")

    val solver = Solver()
    println(solver.solve(exp1))
    println(exp1.toString())
}
