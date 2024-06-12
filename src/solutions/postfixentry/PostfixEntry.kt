package solutions.postfixentry

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

/**
 * @see <a href="https://coderun.yandex.ru/problem/postfix-entry">Problem</a>
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val entry = reader.readLine().split(" ").map { Operand.get(it) }

    val res = postfixEntry(entry)
    writer.println(res)

    reader.close()
    writer.close()
}

private fun postfixEntry(entry: List<Operand>): Num {
    val stack = Stack<Num>()
    entry.forEach {
        if (it is Num) {
            stack.push(it)
        } else {
            val operator = it as Operator
            val second = stack.pop()
            val first = stack.pop()
            stack.push(operator.calc(first, second))
        }
    }
    return stack.pop()
}

private abstract class Operand {
    companion object {
        fun get(string: String): Operand =
            if (string.toIntOrNull() != null) {
                Num(string.toInt())
            } else {
                Operator.get(string)
            }
    }
}

private data class Num(val value: Int) : Operand() {
    operator fun plus(num: Num): Num = Num(value + num.value)
    operator fun minus(num: Num): Num = Num(value - num.value)
    operator fun times(num: Num): Num = Num(value * num.value)

    override fun toString(): String {
        return value.toString()
    }
}

private sealed class Operator(val sym: String, val calc: (Num, Num) -> Num) : Operand() {
    data object Add : Operator("+", { a, b -> a + b })
    data object Sub : Operator("-", { a, b -> a - b })
    data object Mul : Operator("*", { a, b -> a * b })

    companion object {
        fun get(sym: String) = when (sym) {
            Add.sym -> Add
            Sub.sym -> Sub
            Mul.sym -> Mul
            else -> throw IllegalArgumentException("Unknown sym: $sym")
        }
    }
}

private fun BufferedWriter.println(s: Any) {
    write(s.toString())
    newLine()
}