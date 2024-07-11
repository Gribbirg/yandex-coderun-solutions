package solutions.threeblocksrow

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * @see <a href="https://coderun.yandex.ru/problem/three-blocks-row">Problem</a>
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = reader.readLine().trim().toInt()

    val res = threeBlocksRow(n)
    writer.println(res)

    reader.close()
    writer.close()
}

private fun threeBlocksRow(n: Int): Long {
    val countByLastOnes = LongArray(3).also { it[0] = 1 }

    repeat(n) {
        countByLastOnes[0] = countByLastOnes.sum().also {
            countByLastOnes[2] = countByLastOnes[1]
            countByLastOnes[1] = countByLastOnes[0]
        }
    }

    return countByLastOnes.sum()
}


// Template functions
private fun BufferedWriter.println(s: Any = "") {
    write(s.toString())
    newLine()
}