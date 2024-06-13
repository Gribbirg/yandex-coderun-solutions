package solutions.{DIR_NAME}

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * @see <a href="https://coderun.yandex.ru/problem/{LINK_NAME}">Problem</a>
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    // input code here

    val res = {FUN_NAME}()
    writer.println(res)

    reader.close()
    writer.close()
}

private fun {FUN_NAME}() {

}


// Template functions
private fun BufferedWriter.println(s: Any = "") {
    write(s.toString())
    newLine()
}

private fun <T> List<T>.toPair(): Pair<T, T> {
    require(size == 2) { "Incorrect size" }
    return Pair(first(), last())
}