package templates.number

private fun Number.toDigits() = toString().toCharArray().map(Char::digitToInt)