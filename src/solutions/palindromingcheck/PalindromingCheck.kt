package solutions.palindromingcheck

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * @see <a href="https://coderun.yandex.ru/problem/palindroming-check">Problem</a>
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val s = reader.readLine()

    val res = palindromingCheck(s)
    writer.println(res.msg)

    reader.close()
    writer.close()
}

private fun palindromingCheck(s: String) =
    s.replace(" ", "").lowercase().let { it == it.reversed() }.toResult()

private enum class Result(val msg: String) {
    TRUE("It is a palindrome"),
    FALSE("It is not a palindrome");
}

private fun Boolean.toResult() = if (this) Result.TRUE else Result.FALSE

// Template functions
private fun BufferedWriter.println(s: Any = "") {
    write(s.toString())
    newLine()
}