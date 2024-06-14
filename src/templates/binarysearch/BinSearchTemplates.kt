package templates.binarysearch

fun lastBinSearch(): Int {
    var left = 0
    var right = Int.MAX_VALUE
    while (left < right) {
        val medium = (left + right + 1) / 2
        if (check()) {
            left = medium
        } else {
            right = medium - 1
        }
    }
    return left
}

fun firstBinSearch(): Int {
    var left = 0
    var right = Int.MAX_VALUE
    while (left < right) {
        val medium = (left + right) / 2
        if (check()) {
            right = medium
        } else {
            left = medium + 1
        }
    }
    return left
}

private fun check() = false