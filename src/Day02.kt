fun main() {
    fun part1(input: List<String>): Int {
        var position = 0
        var depth = 0

        input.forEach {
            val pair = it.split(" ")
            val type = pair[0]
            val value = pair[1].toInt()
//            println("type : $type and value : $value")
            when (type) {
                "forward" -> position += value
                "down" -> depth += value
                "up" -> depth -= value
            }
        }

        return position * depth
    }

    fun part2(input: List<String>): Int {
        var position = 0
        var depth = 0
        var aim = 0

        input.forEach {
            val pair = it.split(" ")
            val type = pair[0]
            val value = pair[1].toInt()
//            println("type : $type and value : $value")
            when (type) {
                "forward" -> {
                    position += value
                    depth += aim * value
                }
                "down" -> aim += value
                "up" -> aim -= value
            }
        }

        return position * depth
    }

    // test if implementation meets criteria from the description, like:
//    val testInput = readInput("Day01_test")
//    check(part1(testInput) == 1)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
