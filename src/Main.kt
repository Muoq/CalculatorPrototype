
fun main(args: Array<String>) {
//    val exp1 = Expression("3*4-(4+5-3-81/9/3*7*(31-16+(7-5) + (3 + 6)) + 5*4 - 2) - 3")

    val exp1 = Expression("3+4p5*31-(41+21)p3")

    val solver = Solver()
    println(solver.solve(exp1))
}
