package solutions.uniqueusers

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * @see <a href="https://coderun.yandex.ru/problem/unique-users">Problem</a>
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val count = reader.readLine().trim().toInt()
    val users = List(count) { reader.readLine().trim() }

    val res = uniqueUsers(users)
    writer.println(res)

    reader.close()
    writer.close()
}

private fun uniqueUsers(users: List<String>): Int =
    users.map { Email.parse(it) }.toSet().size

private data class Email(
    val login: String,
    val domain: String,
) {
    companion object {
        fun parse(str: String): Email {
            val split = str.split("@")
            return Email(
                login = split[0].replace(".", "").split("-")[0],
                domain = split[1].split(".").let { it.take(it.lastIndex) }.joinToString(".")
            )
        }
    }
}


// Template functions
private fun BufferedWriter.println(s: Any = "") {
    write(s.toString())
    newLine()
}