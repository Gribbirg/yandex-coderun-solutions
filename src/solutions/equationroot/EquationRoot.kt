package solutions.equationroot

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * @see <a href="https://coderun.yandex.ru/problem/equation-root">Problem</a>
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val a = reader.readLine().trim().toInt()
    val b = reader.readLine().trim().toInt()
    val c = reader.readLine().trim().toInt()

    val res = equationRoot(a, b, c)
    writer.println(res.message)

    reader.close()
    writer.close()
}

private fun equationRoot(a: Int, b: Int, c: Int): Result =
    if (c < 0) Result.NoSolution
    else if (a == 0)
        if (b == c * c) Result.Infinitive
        else Result.NoSolution
    else ((c * c - b) / a.toDouble()).let { if (it % 1.0 == 0.0) Result.Num(it.toInt()) else Result.NoSolution }

private sealed class Result(val message: String) {
    class Num(num: Int) : Result(num.toString())
    object NoSolution : Result("NO SOLUTION")
    object Infinitive : Result("MANY SOLUTIONS")
}

private fun BufferedWriter.println(s: Any) {
    write(s.toString())
    newLine()
}