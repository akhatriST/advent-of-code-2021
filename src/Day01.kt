fun main() {
    fun part1(input: List<String>): Int {
        val inputAsInts = input.map { it.toInt() }
        var increasedCount = 0
        for (index in inputAsInts.indices) {
            if (index != 0)
                if (inputAsInts[index] > inputAsInts[index - 1])
                    increasedCount++
        }
        return increasedCount
    }

    fun part2(input: List<String>): Int {
        val inputAsInts = input.map { it.toInt() }
        var increasedCount = 0
        var prevMeasurement = 0
        for (index in inputAsInts.indices) {
            if (index < inputAsInts.size - 2) {
                val measurement = inputAsInts[index] + inputAsInts[index + 1] + inputAsInts[index + 2]
                if (prevMeasurement != 0 && measurement > prevMeasurement) {
                    increasedCount++
                }
                prevMeasurement = measurement
            }
        }
        return increasedCount
    }

    fun part2JetbrainsWay01(input: List<String>): Int {
        return input.map { it.toInt() }.windowed(3).windowed(2).count { (a, b) ->
            b.sum() > a.sum()
        }
    }

    // Since A + B + C <=> B + C + D, we can eliminate the common part
    fun part2JetbrainsWay02(input: List<String>): Int {
        return input.map { it.toInt() }.windowed(4).count {
            it[0] < it[3]
        }
    }

    // test if implementation meets criteria from the description, like:
//    val testInput = readInput("Day01_test")
//    check(part1(testInput) == 1)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
