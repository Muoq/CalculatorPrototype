
class Expression() {

    var expression: MutableList<Any> = mutableListOf()
    var isNumber: MutableList<Boolean> = mutableListOf()

    var size: Int = 0

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

    fun print() {
        println(expression.toString())

        for (i in 0 until expression.size) {

        }
    }

}
