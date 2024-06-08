package templates

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

private fun BufferedWriter.println(s: Any) {
    write(s.toString())
    newLine()
}