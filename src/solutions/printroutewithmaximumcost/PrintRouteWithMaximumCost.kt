package solutions.printroutewithmaximumcost

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val rowsCount = reader.readLine().split(" ")[0].toInt()
    val field = Array(rowsCount) { reader.readLine().split(" ").map { it.toInt() }.toIntArray() }

    val route = printRoutes(field)

    println(route.sum)
    println(route.route.joinToString(" ") { it.shortName })

    reader.close()
}

private fun printRoutes(inputField: Array<IntArray>): RouteData {
    val field = Array(inputField.size) { Array<PointData?>(inputField[0].size) { null } }

    field[0][0] = PointData(inputField[0][0])
    for (i in 1..field[0].lastIndex) {
        field[0][i] = PointData(inputField[0][i] + field[0][i - 1]!!.value, Direction.RIGHT)
    }

    for (i in 1..field.lastIndex) {
        field[i][0] = PointData(inputField[i][0] + field[i - 1][0]!!.value, Direction.DOWN)
        for (j in 1..field[0].lastIndex) {
            field[i][j] = if (field[i - 1][j]!! > field[i][j - 1]!!)
                PointData(inputField[i][j] + field[i - 1][j]!!.value, Direction.DOWN)
            else
                PointData(inputField[i][j] + field[i][j - 1]!!.value, Direction.RIGHT)
        }
    }

    val route = ArrayList<Direction>()
    var i = field.lastIndex
    var j = field[0].lastIndex

    while (field[i][j]!!.direction != null) {
        route.add(field[i][j]!!.direction!!)
        if (field[i][j]!!.direction == Direction.RIGHT) {
            j--
        } else {
            i--
        }
    }

    return RouteData(
        sum = field.last().last()!!.value,
        route = route.reversed(),
    )
}

private data class RouteData(
    val sum: Int,
    val route: List<Direction>,
)

private data class PointData(
    val value: Int,
    val direction: Direction? = null,
) : Comparable<PointData> {
    override fun compareTo(other: PointData): Int = value.compareTo(other.value)
}

private enum class Direction(
    val shortName: String,
) {
    DOWN("D"),
    RIGHT("R");
}