import com.sun.corba.se.impl.io.TypeMismatchException
import java.util.*

class Expression() {

    companion object {
        val operators = listOf('(', ')','p', '*', '/', '+', '-')
    }

    var expression: MutableList<Any> = mutableListOf()
    var isNumber: MutableList<Boolean> = mutableListOf()

    var size: Int = 0
        get() {
            return expression.size
        }

    constructor(expressionString: String): this() {
        for (char in expressionString) {
            if (char in operators) {
                addOperator(Operator(char))
            } else if (char == ' ') {
                continue
            } else {
                if (isNumber.isNotEmpty() && isNumber[isNumber.size - 1]) {
                    expression[expression.size - 1] = expression.last() as Int * 10 + char.toString().toInt()
                } else {
                    addNumber(char.toString().toInt())
                }
            }
        }
    }

    constructor(openingIndex: Int, expressionArg: Expression): this() {
        for (i in openingIndex until expressionArg.size) {
            if (expressionArg.isNumber(i)) {
                addNumber(expressionArg.getNumberAt(i))
            } else {
                addOperator(expressionArg.getOperatorAt(i))
            }
        }
    }

    constructor(expressionArg: Expression): this() {
        for (i in 0 until expressionArg.size) {
            if (expressionArg.isNumber(i)) {
                addNumber(expressionArg.getNumberAt(i))
            } else {
                addOperator(expressionArg.getOperatorAt(i))
            }
        }
    }

    fun addNumber(num: Int) {
        expression.add(num)
        isNumber.add(true)
        size++
    }

    fun addOperator(operator: Operator) {
        expression.add(operator)
        isNumber.add(false)
        size++
    }

    fun removeAt(index: Int) {
        expression.removeAt(index)
        isNumber.removeAt(index)
        size--
    }

    fun removeLast() {
        expression.removeAt(size - 1)
        isNumber.removeAt(size - 1)
        size--
    }

    fun setNumberAt(index: Int, num: Int) {
        expression.set(index, num)
        isNumber.set(index, true)
    }

    fun setOperatorAt(index: Int, operator: Operator) {
        expression.set(index, operator)
        isNumber.set(index, false)
    }

    fun isNumber(index: Int) = isNumber[index]


    fun isOperator(index: Int) = !isNumber[index]

    fun getNumberAt(index: Int): Int {
        if (!isNumber(index)) {
            throw TypeMismatchException("Error: The element you are trying to access is not of type Int")
        }

        return expression[index] as Int
    }

    fun getOperatorAt(index: Int): Operator {
        if (!isOperator(index)) {
            throw TypeMismatchException("Error: The element you are trying to access is not of type Operator")
        }

        return expression[index] as Operator
    }

    fun getSurroundingNumbers(index: Int): Pair<Int, Int> {
        return Pair(getNumberAt(index - 1), getNumberAt(index + 1))
    }

    override fun toString(): String {
        var classString = ""

        for (i in 0 until expression.size) {
            classString += (expression[i].toString())
        }

        return classString
    }

}
