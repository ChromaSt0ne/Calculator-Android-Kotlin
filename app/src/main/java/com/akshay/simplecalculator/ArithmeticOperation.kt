package com.akshay.simplecalculator

class ArithmeticOperation : IArithmeticOperation {

    private var num1:Float? = null

    private var num2:Float? = null
    override fun add() : Float {
        return num1!! + num2!!
    }
    override fun subtract(): Float {
        return num1!! - num2!!
    }

    override fun multiply(): Float {
        return num1!! * num2!!
    }

    internal fun getNum1() : Float? {
        return num1
    }
    internal fun getNum2() : Float? {
        return num2
    }

    internal fun setNum1(value :Float?) {
         num1 = value
    }
    internal fun setNum2(value :Float?) {
        num2 = value
    }

}

fun Float.isNonZero(): Boolean {
    return this != 0f
}


fun ArithmeticOperation.divide(): Float {
    return this.getNum1()!! / this.getNum2()!!!!
}