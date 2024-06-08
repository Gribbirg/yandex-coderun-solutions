package solutions.grasshopper

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val (stepsCount, jumpLen) = reader.readLine().split(" ").map { it.toInt() }

    val res = grasshopper(stepsCount, jumpLen)
    writer.println(res)

    reader.close()
    writer.close()
}

private fun grasshopper(stepsCount: Int, jumpLen: Int): Int {
    val variantsByLevel = IntArray(stepsCount)
    variantsByLevel[0] = 1
    for (i in 1 until stepsCount) {
        variantsByLevel[i] = variantsByLevel
            .toList()
            .subList(
                maxOf(0, i - jumpLen),
                i,
            )
            .sum()
    }
    return variantsByLevel.last()
}

private fun BufferedWriter.println(s: Any) {
    write(s.toString())
    newLine()
}