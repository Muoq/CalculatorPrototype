
class Solver {

    fun solve(expressionArg: Expression): Int {
        val expression = Expression(expressionArg)

//        for (i in 0 until expression.size) {
//            if (expression.isOperator(i) && expression.getOperatorAt(i).id == Operator.OPEN_PARENTHESIS_ID) {
//                val tempExpression = Expression(i + 1, expression)
//                solveParentheses(tempExpression)
//            }
//        }

        for (i in 2 downTo 0) {
            var loopCtr = 0
            while (loopCtr < expression.size) {

                if (expression.isOperator(loopCtr) && expression.getOperatorAt(loopCtr).hierarchy == i) {
                    val operationTerms = expression.getSurroundingNumbers(loopCtr)
                    val operationSolution = expression.getOperatorAt(loopCtr).operation(operationTerms.first, operationTerms.second)
                    expression.setNumberAt(loopCtr - 1, operationSolution)
                    expression.removeAt(loopCtr)
                    expression.removeAt(loopCtr)
                    loopCtr--
                }

                loopCtr++
            }
        }

        return expression.getNumberAt(0)
    }

    fun solveParentheses(expression: Expression) {

    }

}
