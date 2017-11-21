
class Expression() {

    companion object {
        val operators = listOf('(', ')', '*', '/', '+', '-')
    }

    var expression: MutableList<Any> = mutableListOf()
    var isNumber: MutableList<Boolean> = mutableListOf()

    var size: Int = 0

    constructor(expressionString: String): this() {
        for (char in expressionString) {
            if (char in operators) {
                addOperator(Operator(char))
            } else if (char == ' ') {
                continue
            } else {
                addNumber(char.toString().toInt())
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

    override fun toString(): String {
        var classString = ""

        for (i in 0 until expression.size) {
            classString += (expression[i].toString())

            print(isNumber[i].toString() + " ")
        }

        return classString
    }

}
