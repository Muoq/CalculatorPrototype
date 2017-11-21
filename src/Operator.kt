import java.security.InvalidParameterException

class Operator() {

    companion object {
        val validOperators = listOf('(', ')', '*', '/', '+', '-')

        val multiplyOperation = {x: Int, y: Int -> x * y}
        val divisideOperation = {x: Int, y: Int -> x / y}
        val addOperation = {x: Int, y: Int -> x + y}
        val subtractOperation = {x: Int, y: Int -> x - y}

        val emptyOperation: (Int, Int) -> Int = {x, y -> x}

        val operatorsList = listOf(emptyOperation, emptyOperation, multiplyOperation, divisideOperation,
                                    addOperation, subtractOperation)
    }

    var operation = emptyOperation
    var operatorTypeChar = ' '

    constructor(operatorChar: Char): this() {
        if (operatorChar !in validOperators) {
            throw InvalidParameterException("Error: \'" + operatorChar.toString() + "\' is not a valid operator.")
        }

        operatorTypeChar = operatorChar
        operation = operatorsList[validOperators.indexOf(operatorChar)]
    }

    override fun toString(): String {
        return operatorTypeChar.toString()
    }

}
