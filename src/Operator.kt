import java.math.BigDecimal
import java.security.InvalidParameterException

open class Operator() {

    companion object {
        val validOperators = listOf('(', ')', 'p','r', '*', '/', '+', '-')

        val powerOperation = { x: BigDecimal, y: BigDecimal -> BigDecimal(Math.pow(x.toDouble(), y.toDouble()))}
        val rootOperation = {x: BigDecimal, y: BigDecimal ->
            val xDouble = x.toDouble()
            val yDouble = y.toDouble()

            BigDecimal(Math.pow(yDouble, 1 / xDouble))
        }
        val multiplyOperation = {x: BigDecimal, y: BigDecimal -> x * y}
        val divideOperation = {x: BigDecimal, y: BigDecimal -> x / y}
        val addOperation = {x: BigDecimal, y: BigDecimal -> x + y}
        val subtractOperation = {x: BigDecimal, y: BigDecimal -> x - y}

        val OPEN_PARENTHESIS_ID = 7
        val CLOSE_PARENTHESIS_ID = 6
        val POWER_ID = 5
        val ROOT_ID = 4
        val MULTIPLY_ID = 3
        val DIVIDE_ID = 2
        val ADD_ID = 1
        val SUBTRACT_ID = 0

        val PARENTHESIS_HIERARCHY = 4
        val POWER_HIERARCHY = 2
        val MULTIPLY_HIERARCHY = 1
        val ADD_HIEREARCHY = 0

        val emptyOperation: (BigDecimal, BigDecimal) -> BigDecimal = {x, y -> x}

        val operatorsList = listOf(emptyOperation, emptyOperation, powerOperation, rootOperation, multiplyOperation,
                                    divideOperation, addOperation, subtractOperation)
        val idList = listOf(OPEN_PARENTHESIS_ID, CLOSE_PARENTHESIS_ID,POWER_ID, ROOT_ID,
                            MULTIPLY_ID, DIVIDE_ID, ADD_ID, SUBTRACT_ID)

        val HIERARCHY_AMOUNT = 4
    }

    var operation = emptyOperation
    private var operatorTypeChar = ' '

    var id = -1
    var hierarchy = -1

    constructor(operatorChar: Char): this() {
        if (operatorChar !in validOperators) {
            throw InvalidParameterException("Error: \'" + operatorChar.toString() + "\' is not a valid operator.")
        }

        operatorTypeChar = operatorChar
        operation = operatorsList[validOperators.indexOf(operatorChar)]
        id = idList[validOperators.indexOf(operatorChar)]
        hierarchy = id / 2
    }

    override fun toString(): String {
        return operatorTypeChar.toString()
    }

}
