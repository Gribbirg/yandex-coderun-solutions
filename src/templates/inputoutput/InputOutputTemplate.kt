package templates.inputoutput

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    // code here

    reader.close()
    writer.close()
}

// fun here


// Template functions
private fun BufferedWriter.println(s: Any) {
    write(s.toString())
    newLine()
}

private fun <T> List<T>.toPair(): Pair<T, T> {
    require(size == 2) { "Incorrect size" }
    return Pair(first(), last())
}